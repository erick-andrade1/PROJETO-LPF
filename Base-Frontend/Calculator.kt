//Programa que roda no navegador
import kotlinx.browser.*

//funcao de teste:
fun mainTest(){
    val ma=modFlo(listOf("F","G","W"),listOf(2F,0.5F,2f))
    val mb=modFlo(listOf("N","G","W"),listOf(0.5F,2F,2f))
    val mc=modFlo(listOf("N","F","W"),listOf(1F,1F,1f))
    val t1=type("N",ma)
    val t3=type("W",mb)
    val t2=type("F",mc)
    val t4=duoType(t1,t1)
    val t5=duoType(t1,t3)
    val t6=duoType(t2,t3)
    val ataqF=ataque("F",100,true)
    val ataqG=ataque("G",100,true)
    val ataqW=ataque("W",100,false)
    val ataqN=ataque("N",100,false)
    val poke1=pokemon(t5,50,50,50,50,100)
    val poke2=pokemon(t4,50,50,50,50,50)
    val poke3=pokemon(t6,50,50,50,50,10)
    val fator1=gerarFator("gutsburn")
    val fator2=gerarFator("")
    val fator3=gerarFator("burn")
    val fator4=gerarFator("wonder")
    val listA=listOf(ataqF,ataqG,ataqW,ataqN)
    val listP=listOf(poke1,poke2,poke3)
    val listF=listOf(fator1,fator2,fator3,fator4)
    for(a in listA){
        for(p1 in listP){
            for(p2 in listP){
                for(f in listF){
                    println(danoT(a,p1,p2,f))
                }
            }
        }
    }
}

@JsName("gerarFator")
fun gerarFator(lista:String):modFlo{
    val x1=if("guts" in lista){if("burn" in lista || "poison" in lista){Pair("guts",2f)}else{Pair("guts",1f)}}
    else{if("burn" in lista){Pair("burn",0.5f)}else{Pair("guts",1f)}}
    val f=if("wonder" in lista){modFlo(listOf("wonder"),listOf(1f))}else{modFlo(listOf(),listOf())}
    return f+x1
}


//calcula 4 danos possiveis se baseano em duas variaveis aleatorias:
@JsName("danoT")
fun danoT(ataq:ataque,pokeA:pokemon,pokeD:pokemon,fatores:modFlo):List<Int>{
    val w=fatores.contains("wonder")
    val pDef:pokemon=if(w){pokeD.wD()}else{pokeD}
    val r=calculos(ataq,pokeA,pDef,w)
    val m=fatores.mult1()
    val crit=1.5f
    val rf=m*r
    println(ataq.tipo+"-"+pokeA.t.nome+"-"+pokeD.t.nome+"-"+fatores.nome)
    return listOf((rf*0.85).toInt(),rf.toInt(),(rf*0.85*crit).toInt(),(rf*crit).toInt())
}

@JsName("calculos")
fun calculos(ataq:ataque,pokeA:pokemon,pokeD:pokemon,wonder:Boolean):Int{
    val a=if(ataq.special){pokeA.spAtk.toFloat()}else{pokeA.atk.toFloat()}
    val d=if(ataq.special){pokeD.spDef}else{pokeD.def}
    val l=pokeA.level*2f/5+2
    val power=ataq.power
    val p2=(power*l*a/d/50)+2
    val stab=if(pokeA.t.vTipo(ataq.tipo)){1.5f}else{1f}
    val m=pokeD.t[ataq.tipo]
    val fr=if(wonder && m<=1f){0f}else{pokeD.t[ataq.tipo]}
    val result=fr*stab*p2
    return result.toInt()
}

//amazena modificadores baseados em Float
@JsName("modFlo")
class modFlo(val nome: List<String>, val valor: List<Float>){
    operator fun times(n:Pair<String,Float>):modFlo{
        val (nT,mD)=n
        val i =this.indexOf(nT)
        val v=this[i]
        //para antes caso um tipo garanta imunidade
        if(v==0f){
            return this
        }
        val nM=mD*this[i]
        val novo=this-nT
        //retira o tipo da lista caso ele passe a causar dano neutro
        if(nM==1f){
            return novo
        }
        else{
            return novo+Pair(nT,nM)
        }
    }
    operator fun plus(other: Pair<String, Float>): modFlo {
        val (nT, nM) = other
        if (this.nome.contains(nT) || nM==1f) {
            return this
        }
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

    //quando for pegar o float use o operador get
    operator fun get(i: Int): Float {
        val x=this.size()
        if (x == 0){
            return 1f
        }
        else if(x<=i){
            return 1f
        }
        return this.valor[i]
    }

    //versão alternativa do get que usa string
    operator fun get(i: String): Float {
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
            val s=this.getS(i)
            val x=this[i]
            println("$x $s  WF")
            val novo=this-this.getS(i)
            return novo.wonderGuard(i)
        }
        else{
            val s=this.getS(i)
            val x=this[i]
            println("$x $s  WGr")
            return this.wonderGuard(i+1)
        }
    }
    fun contains(s: String):Boolean {
        return this.nome.contains(s)
    }

    //quando for pegar a string use getS()
    fun getS(i: Int):String{
        return this.nome[i]
    }

    //retorna um pair
    fun getP(i: Int):Pair<String,Float>{
        return Pair(this.getS(i),this[i])
    }
    fun size(): Int {
        return this.nome.size
    }
    fun mult1(): Float {
        if (this.size() == 0) {
            return 1.0f
        } else {
            return this.mult(0)
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

@JsName("pokemon")
class pokemon(val t:type,val atk:Int,val spAtk:Int,val def:Int,val spDef:Int,val level:Int){
    fun wD():pokemon{
        val nT=this.t.modifica.wonderGuard(0)
        return pokemon(type(t.nome,nT),atk,spAtk,def,spDef,level)
    }
}

//armazena as informacoes do tipo
@JsName("type")
class type(val nome: String, val modifica: modFlo){
    fun vTipo(s: String):Boolean{
        return s in this.nome
    }
    fun same(t:type):Boolean{
        return this.nome==t.nome
    }
    operator fun get(i:String):Float{
        return this.modifica[i]
    }
}

//armazena as informacoes do ataque
@JsName("ataque")
class ataque(val tipo: String, val power: Int ,val special: Boolean){
}

//combina os dois tipos para calcular o dano recebido por um pokemon com dois tipos
@JsName("duoType")
fun duoType(tp1: type,tp2: type):type{
    if(tp1==tp2){
        return tp1
    }
    val n1=tp1.nome
    val n2=tp2.nome
    return type("$n1$n2", combinar(tp1.modifica,tp2.modifica,0))
}

@JsName("combinar")
fun combinar(a1: modFlo,a2: modFlo,n :Int):modFlo{
    //todos os elementos foram analisados
    if(n>=a2.size()){
        return a1
    }
    // retorna alterando os tipos da lista
    else if(a1.contains(a2.getS(n))){
        return combinar((a1*a2.getP(n)),a2,n+1)
    }
    else{
        return combinar((a1+a2.getP(n)),a2,n+1)

    }
}