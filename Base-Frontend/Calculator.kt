fun gerarFator(lista:List<String>):modFlo
fun danoT(ataq:ataque,pokeA:pokemon,pokeD:pokemon,fatores:modFlo){
    val w=fatores.contains(wonderGuard)
    val r=calculos(ataq,pokeA,pokeD,w)
    val m=fatores.mult1()
}
fun calculos(ataq:ataque,pokeA:pokemon,pokeD:pokemon,wonder:Boolean):Float{
    val a=if(ataq.special){pokeA.spAtk.toFloat()}else{pokeA.atk.toFloat()}
    val d=if(ataq.special){pokeD.spDef}else{pokeD.def}
    val l=pokeA.level*2f/5+2
    val power=ataq.power
    val p2=(power*l*a/d/50)+2
    val stab=if(pokeA.t.vTipo(ataq.tipo)){1.5f}else{1f}
    val m=pokeD.t[ataq.tipo]
    val fr=if(wonder && m<=1f){0f}else{pokeD.t[ataq.tipo]}
    val result=fr*stab*p2
    return result
}
class modFlo(val nome: List<String>, val valor: List<Float>){//amazena modificadores baseados em Float
operator fun times(n:Pair<String,Float>):modFlo{
    val (nT,mD)=n
    val i =this.indexOf(nT)
    val v=this[i]
    if(v==0f){//para antes caso um tipo garanta imunidade
        return this
    }
    val nM=mD*this[i]
    val novo=this-nT
    if(nM==1f){//retira o tipo da lista caso ele passe a causar dano neutro
        return novo
    }
    else{
        return novo+Pair(nT,nM)
    }
}
    operator fun plus(other: Pair<String, Float>): modFlo {
        val (nT, nM) = other
        return modFlo(this.nome + nT, this.valor + nM)
    }
    operator fun minus(s: String): modFlo {
        if (this.size() == 0){
            return this
        }
        if (!this.nome.contains(s)) {
            return this
        }
        val x = this.indexOf(s)
        return modFlo(this.nome.filterNot { it == s }, this.valor.filterIndexed { index, i -> index != x })
    }
    operator fun get(i: Int): Float {//quando for pegar o float use o operador get
        if (this.size() == 0){
            return 1f
        }
        return this.valor[i]
    }
    operator fun get(i: String): Float {//versão alternativa do get que usa string
        val x = this.indexOf(i)
        if (x<0){
            return 1f
        }
        return this.valor[x]
    }
    fun indexOf(s: String): Int {
        return this.nome.indexOf(s)
    }
    fun wonderGuard(i: Int):modFlo{
        if(i>=this.size()){
            return this
        }
        else if(this[i]<=1f){
            val novo=this-this.getS(i)
            return novo.wonderGuard(i)
        }
        else{
            return this.wonderGuard(i+1)
        }
    }
    fun contains(s: String):Boolean {
        return this.nome.contains(s)
    }
    fun getS(i: Int):String{//quando for pegar a string use getS()
        return this.nome[i]
    }
    fun getP(i: Int):Pair<String,Float>{//retorna um pair
        return Pair(this.getS(i),this[i])
    }
    fun size(): Int {
        return this.nome.size
    }
    fun mult1(): Float {
        if (this.size() == 0) {
            return 1.0f
        } else {
            if (this.nome.contains("guts2") && this.nome.contains("burn")) {//a partiride certa geração guts retira o decriscimo de burn
                return (this - "burn").mult(0)
            } else {
                return this.mult(0)
            }
        }
    }
    fun mult(i: Int): Float {
        if (i >= this.size()) {
            return 1f
        } else {
            return this[i] * this.mult(i + 1)
        }

    }
}
class pokemon(val t:type,val atk:Int,val spAtk:Int,val def:Int,val spDef:Int,val level:Int){}
class type(val nome: String, val modifica: modFlo){//armazena as informacoes do tipo
fun vTipo(s: String):Boolean{
    return s in this.nome
}
    operator fun get(i:String):Float{
        return this.modifica[i]
    }
}
class ataque(val tipo: String, val power: Int ,val special: Boolean){//armazena as informacoes do ataque
}
fun duotype(tp1: type,tp2: type):type{//combina os dois tipos para calcular o dano recebido por um pokemon com dois tipos
    return type(tp1.nome+tp2.nome, combinar(tp1.modifica,tp2.modifica,0))
}
fun combinar(a1: modFlo,a2: modFlo,n :Int):modFlo{
    if(n>=a2.size()){//todos os elementos foram analisados
        return a1
    }
    else if(a1.contains(a2.getS(n))){// retorna alterando os tipos da lista
        return combinar((a1*a2.getP(n)),a2,n+1)
    }
    else{
        return combinar((a1+a2.getP(n)),a2,n+1)

    }
}