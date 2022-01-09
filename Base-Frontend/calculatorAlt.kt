//class que armazena os dados dos Pokemon
open class Pokemon(val tipoPrim: String, val tipoSec: String?, val level:Int, val atk:Int , val spatk: Int, val def:Int, val spdef:Int)

//class que armazena as informações dos ataques
open class Ataque(val tipo:String, val power:Int, val special: Boolean)

fun ineffect(tipoAtk:String, primtypePkm:String, sectypePkm:String?):Double{

    // retorna 0 se o ataque for ineficaz contra um dos tipos do Pokémon defendendo

    if(tipoAtk=="NORMAL" && primtypePkm=="GHOST"||tipoAtk=="NORMAL" && sectypePkm=="GHOST") return 0.0
    if(tipoAtk=="FIGHT" && primtypePkm=="GHOST"||tipoAtk=="FIGHT" && sectypePkm=="GHOST") return 0.0
    if(tipoAtk=="POISON" && primtypePkm=="STEEL"||tipoAtk=="POISON" && sectypePkm=="STEEL") return 0.0
    if(tipoAtk=="GROUND" && primtypePkm=="FLYING"||tipoAtk=="GROUND" && sectypePkm=="FLYING") return 0.0
    if(tipoAtk=="GHOST" && primtypePkm=="NORMAL"||tipoAtk=="GHOST" && sectypePkm=="NORMAL") return 0.0
    if(tipoAtk=="ELETRIC" && primtypePkm=="GROUND"||tipoAtk=="ELETRIC" && sectypePkm=="GROUND") return 0.0
    if(tipoAtk=="PSYCHC" && primtypePkm=="DARK"||tipoAtk=="PSYCHC" && sectypePkm=="DARK") return 0.0
    if(tipoAtk=="DRAGON" && primtypePkm=="FAIRY"||tipoAtk=="DRAGON" && sectypePkm=="FAIRY") return 0.0
    return 1

}
fun notveryEffect(tipoAtk:String, primtypePkm:String, sectypePkm:String?):Double{
    var effect:Double = 1.0
    if(tipoAtk=="NORMAL" && primtypePkm=="ROCK"||tipoAtk=="NORMAL" && sectypePkm=="ROCK") effect = effect*0.5
    if(tipoAtk=="NORMAL" && primtypePkm=="STEEL"||tipoAtk=="NORMAL" && sectypePkm=="STEEL") effect = effect*0.5
    if(tipoAtk=="FIGHT" && primtypePkm=="FLYING"||tipoAtk=="FIGHT" && sectypePkm=="FLYING") effect = effect*0.5
    if(tipoAtk=="FIGHT" && primtypePkm=="POISON"||tipoAtk=="FIGHT" && sectypePkm=="POISON") effect = effect*0.5
    if(tipoAtk=="FIGHT" && primtypePkm=="BUG"||tipoAtk=="FIGHT" && sectypePkm=="BUG") effect = effect*0.5
    if(tipoAtk=="FIGHT" && primtypePkm=="PSYCHC"||tipoAtk=="FIGHT" && sectypePkm=="PSYCHC") effect = effect*0.5
    if(tipoAtk=="FIGHT" && primtypePkm=="FAIRY"||tipoAtk=="FIGHT" && sectypePkm=="FAIRY") effect = effect*0.5
    if(tipoAtk=="FLYING" && primtypePkm=="ROCK"||tipoAtk=="FLYING" && sectypePkm=="ROCK") effect = effect*0.5
    if(tipoAtk=="FLYING" && primtypePkm=="STEEL"||tipoAtk=="FLYING" && sectypePkm=="STEEL") effect = effect*0.5
    if(tipoAtk=="FLYING" && primtypePkm=="ELETRIC"||tipoAtk=="FLYING" && sectypePkm=="ELETRIC") effect = effect*0.5
    if(tipoAtk=="POISON" && primtypePkm=="POISON"||tipoAtk=="POISON" && sectypePkm=="POISON") effect = effect*0.5
    if(tipoAtk=="POISON" && primtypePkm=="GROUND"||tipoAtk=="POISON" && sectypePkm=="GROUND") effect = effect*0.5
    if(tipoAtk=="POISON" && primtypePkm=="ROCK"||tipoAtk=="POISON" && sectypePkm=="ROCK") effect = effect*0.5
    if(tipoAtk=="POISON" && primtypePkm=="GHOST"||tipoAtk=="POISON" && sectypePkm=="GHOST") effect = effect*0.5
    if(tipoAtk=="GROUND" && primtypePkm=="BUG"||tipoAtk=="GROUND" && sectypePkm=="BUG") effect = effect*0.5
    if(tipoAtk=="GROUND" && primtypePkm=="GRASS"||tipoAtk=="GROUND" && sectypePkm=="GRASS") effect = effect*0.5
    if(tipoAtk=="ROCK" && primtypePkm=="FIGHTING"||tipoAtk=="ROCK" && sectypePkm=="FIGHTING") effect = effect*0.5
    if(tipoAtk=="ROCK" && primtypePkm=="GROUND"||tipoAtk=="ROCK" && sectypePkm=="GROUND") effect = effect*0.5
    if(tipoAtk=="ROCK" && primtypePkm=="STEEL"||tipoAtk=="ROCK" && sectypePkm=="STEEL") effect = effect*0.5
    if(tipoAtk=="BUG" && primtypePkm=="FIGHTING"||tipoAtk=="BUG" && sectypePkm=="FIGHTING") effect = effect*0.5
    if(tipoAtk=="BUG" && primtypePkm=="FLYING"||tipoAtk=="BUG" && sectypePkm=="FLYING") effect = effect*0.5
    if(tipoAtk=="BUG" && primtypePkm=="POISON"||tipoAtk=="BUG" && sectypePkm=="POISON") effect = effect*0.5
    if(tipoAtk=="BUG" && primtypePkm=="GHOST"||tipoAtk=="BUG" && sectypePkm=="GHOST") effect = effect*0.5
    if(tipoAtk=="BUG" && primtypePkm=="STEEL"||tipoAtk=="BUG" && sectypePkm=="STEEL") effect = effect*0.5
    if(tipoAtk=="BUG" && primtypePkm=="FIRE"||tipoAtk=="BUG" && sectypePkm=="FIRE") effect = effect*0.5
    if(tipoAtk=="BUG" && primtypePkm=="FAIRY"||tipoAtk=="BUG" && sectypePkm=="FAIRY") effect = effect*0.5
    if(tipoAtk=="GHOST" && primtypePkm=="DARK"||tipoAtk=="GHOST" && sectypePkm=="DARK") effect = effect*0.5
    if(tipoAtk=="STEEL" && primtypePkm=="STEEL"||tipoAtk=="STEEL" && sectypePkm=="STEEL") effect = effect*0.5
    if(tipoAtk=="STEEL" && primtypePkm=="FIRE"||tipoAtk=="STEEL" && sectypePkm=="FIRE") effect = effect*0.5
    if(tipoAtk=="STEEL" && primtypePkm=="WATER"||tipoAtk=="STEEL" && sectypePkm=="WATER") effect = effect*0.5
    if(tipoAtk=="STEEL" && primtypePkm=="ELETRIC"||tipoAtk=="STEEL" && sectypePkm=="ELETRIC") effect = effect*0.5
    if(tipoAtk=="FIRE" && primtypePkm=="ROCK"||tipoAtk=="FIRE" && sectypePkm=="ROCK") effect = effect*0.5
    if(tipoAtk=="FIRE" && primtypePkm=="FIRE"||tipoAtk=="FIRE" && sectypePkm=="FIRE") effect = effect*0.5
    if(tipoAtk=="FIRE" && primtypePkm=="WATER"||tipoAtk=="FIRE" && sectypePkm=="WATER") effect = effect*0.5
    if(tipoAtk=="FIRE" && primtypePkm=="DRAGON"||tipoAtk=="FIRE" && sectypePkm=="DRAGON") effect = effect*0.5
    if(tipoAtk=="WATER" && primtypePkm=="WATER"||tipoAtk=="WATER" && sectypePkm=="WATER") effect = effect*0.5
    if(tipoAtk=="WATER" && primtypePkm=="GRASS"||tipoAtk=="WATER" && sectypePkm=="GRASS") effect = effect*0.5
    if(tipoAtk=="WATER" && primtypePkm=="DRAGON"||tipoAtk=="WATER" && sectypePkm=="DRAGON") effect = effect*0.5
    if(tipoAtk=="GRASS" && primtypePkm=="FLYING"||tipoAtk=="GRASS" && sectypePkm=="FLYING") effect = effect*0.5
    if(tipoAtk=="GRASS" && primtypePkm=="POISON"||tipoAtk=="GRASS" && sectypePkm=="POISON") effect = effect*0.5
    if(tipoAtk=="GRASS" && primtypePkm=="BUG"||tipoAtk=="GRASS" && sectypePkm=="BUG") effect = effect*0.5
    if(tipoAtk=="GRASS" && primtypePkm=="STEEL"||tipoAtk=="GRASS" && sectypePkm=="STEEL") effect = effect*0.5
    if(tipoAtk=="GRASS" && primtypePkm=="FIRE"||tipoAtk=="GRASS" && sectypePkm=="FIRE") effect = effect*0.5
    if(tipoAtk=="GRASS" && primtypePkm=="GRASS"||tipoAtk=="GRASS" && sectypePkm=="GRASS") effect = effect*0.5
    if(tipoAtk=="GRASS" && primtypePkm=="DRAGON"||tipoAtk=="GRASS" && sectypePkm=="DRAGON") effect = effect*0.5
    if(tipoAtk=="ELETRIC" && primtypePkm=="GRASS"||tipoAtk=="ELETRIC" && sectypePkm=="GRASS") effect = effect*0.5
    if(tipoAtk=="ELETRIC" && primtypePkm=="ELETRIC"||tipoAtk=="ELETRIC" && sectypePkm=="ELETRIC") effect = effect*0.5
    if(tipoAtk=="ELETRIC" && primtypePkm=="DRAGON"||tipoAtk=="ELETRIC" && sectypePkm=="DRAGON") effect = effect*0.5
    if(tipoAtk=="PSYCHC" && primtypePkm=="STEEL"||tipoAtk=="PSYCHC" && sectypePkm=="STEEL") effect = effect*0.5
    if(tipoAtk=="PSYCHC" && primtypePkm=="PSYCHC"||tipoAtk=="PSYCHC" && sectypePkm=="PSYCHC") effect = effect*0.5
    if(tipoAtk=="ICE" && primtypePkm=="STEEL"||tipoAtk=="ICE" && sectypePkm=="STEEL") effect = effect*0.5
    if(tipoAtk=="ICE" && primtypePkm=="FIRE"||tipoAtk=="ICE" && sectypePkm=="FIRE") effect = effect*0.5
    if(tipoAtk=="ICE" && primtypePkm=="WATER"||tipoAtk=="ICE" && sectypePkm=="WATER") effect = effect*0.5
    if(tipoAtk=="ICE" && primtypePkm=="ICE"||tipoAtk=="ICE" && sectypePkm=="ICE") effect = effect*0.5
    if(tipoAtk=="DRAGON" && primtypePkm=="STEEL"||tipoAtk=="DRAGON" && sectypePkm=="STEEL") effect = effect*0.5
    if(tipoAtk=="DARK" && primtypePkm=="DARK"||tipoAtk=="DARK" && sectypePkm=="DARK") effect = effect*0.5
    if(tipoAtk=="DARK" && primtypePkm=="FAIRY"||tipoAtk=="DARK" && sectypePkm=="FAIRY") effect = effect*0.5
    if(tipoAtk=="FAIRY" && primtypePkm=="POISON"||tipoAtk=="FAIRY" && sectypePkm=="POISON") effect = effect*0.5
    if(tipoAtk=="FAIRY" && primtypePkm=="STEEL"||tipoAtk=="FAIRY" && sectypePkm=="STEEL") effect = effect*0.5
    if(tipoAtk=="FAIRY" && primtypePkm=="FIRE"||tipoAtk=="FAIRY" && sectypePkm=="FIRE") effect = effect*0.5
    return effect
}

fun superEffect(tipoAtk:String, primtypePkm:String, sectypePkm:String?):Int{
    var effect = 1
    if(tipoAtk=="FIGHT" && primtypePkm=="NORMAL"||tipoAtk=="FIGHT" && sectypePkm=="NORMAL") effect = effect*2
    if(tipoAtk=="FIGHT" && primtypePkm=="ROCK"||tipoAtk=="FIGHT" && sectypePkm=="ROCK") effect = effect*2
    if(tipoAtk=="FIGHT" && primtypePkm=="STEEL"||tipoAtk=="FIGHT" && sectypePkm=="STEEL") effect = effect*2
    if(tipoAtk=="FIGHT" && primtypePkm=="ICE"||tipoAtk=="FIGHT" && sectypePkm=="DARK") effect = effect*2
    if(tipoAtk=="FIGHT" && primtypePkm=="DARK"||tipoAtk=="FIGHT" && sectypePkm=="DARK") effect = effect*2
    if(tipoAtk=="FLYING" && primtypePkm=="FIGHT"||tipoAtk=="FLYING" && sectypePkm=="FIGHT") effect = effect*2
    if(tipoAtk=="FLYING" && primtypePkm=="BUG"||tipoAtk=="FLYING" && sectypePkm=="BUG") effect = effect*2
    if(tipoAtk=="FLYING" && primtypePkm=="GRASS"||tipoAtk=="FLYING" && sectypePkm=="GRASS") effect = effect*2
    if(tipoAtk=="POISON" && primtypePkm=="GRASS"||tipoAtk=="POISON" && sectypePkm=="GRASS") effect = effect*2
    if(tipoAtk=="POISON" && primtypePkm=="FAIRY"||tipoAtk=="POISON" && sectypePkm=="FAIRY") effect = effect*2
    if(tipoAtk=="GROUND" && primtypePkm=="POISON"||tipoAtk=="GROUND" && sectypePkm=="POISON") effect = effect*2
    if(tipoAtk=="GROUND" && primtypePkm=="ROCK"||tipoAtk=="GROUND" && sectypePkm=="ROCK") effect = effect*2
    if(tipoAtk=="GROUND" && primtypePkm=="STEEL"||tipoAtk=="GROUND" && sectypePkm=="STEEL") effect = effect*2
    if(tipoAtk=="GROUND" && primtypePkm=="FIRE"||tipoAtk=="GROUND" && sectypePkm=="FIRE") effect = effect*2
    if(tipoAtk=="GROUND" && primtypePkm=="ELETRIC"||tipoAtk=="GROUND" && sectypePkm=="ELETRIC") effect = effect*2
    if(tipoAtk=="ROCK" && primtypePkm=="FLYING"||tipoAtk=="ROCK" && sectypePkm=="FLYING") effect = effect*2
    if(tipoAtk=="ROCK" && primtypePkm=="BUG"||tipoAtk=="ROCK" && sectypePkm=="BUG") effect = effect*2
    if(tipoAtk=="ROCK" && primtypePkm=="FIRE"||tipoAtk=="ROCK" && sectypePkm=="FIRE") effect = effect*2
    if(tipoAtk=="ROCK" && primtypePkm=="ICE"||tipoAtk=="ROCK" && sectypePkm=="ICE") effect = effect*2
    if(tipoAtk=="BUG" && primtypePkm=="GRASS"||tipoAtk=="BUG" && sectypePkm=="GRASS") effect = effect*2
    if(tipoAtk=="BUG" && primtypePkm=="PSYCHC"||tipoAtk=="BUG" && sectypePkm=="PSYCHC") effect = effect*2
    if(tipoAtk=="BUG" && primtypePkm=="DARK"||tipoAtk=="BUG" && sectypePkm=="DARK") effect = effect*2
    if(tipoAtk=="GHOST" && primtypePkm=="GHOST"||tipoAtk=="GHOST" && sectypePkm=="GHOST") effect = effect*2
    if(tipoAtk=="GHOST" && primtypePkm=="PSYCHC"||tipoAtk=="GHOST" && sectypePkm=="PSYCHC") effect = effect*2
    if(tipoAtk=="STEEL" && primtypePkm=="ROCK"||tipoAtk=="STEEL" && sectypePkm=="ROCK") effect = effect*2
    if(tipoAtk=="STEEL" && primtypePkm=="ICE"||tipoAtk=="STEEL" && sectypePkm=="ICE") effect = effect*2
    if(tipoAtk=="STEEL" && primtypePkm=="FAIRY"||tipoAtk=="STEEL" && sectypePkm=="FAIRY") effect = effect*2
    if(tipoAtk=="FIRE" && primtypePkm=="BUG"||tipoAtk=="FIRE" && sectypePkm=="BUG") effect = effect*2
    if(tipoAtk=="FIRE" && primtypePkm=="STEEL"||tipoAtk=="FIRE" && sectypePkm=="STEEL") effect = effect*2
    if(tipoAtk=="FIRE" && primtypePkm=="GRASS"||tipoAtk=="FIRE" && sectypePkm=="GRASS") effect = effect*2
    if(tipoAtk=="FIRE" && primtypePkm=="ICE"||tipoAtk=="FIRE" && sectypePkm=="ICE") effect = effect*2
    if(tipoAtk=="WATER" && primtypePkm=="GROUND"||tipoAtk=="WATER" && sectypePkm=="GROUND") effect = effect*2
    if(tipoAtk=="WATER" && primtypePkm=="ROCK"||tipoAtk=="WATER" && sectypePkm=="ROCK") effect = effect*2
    if(tipoAtk=="WATER" && primtypePkm=="FIRE"||tipoAtk=="WATER" && sectypePkm=="FIRE") effect = effect*2
    if(tipoAtk=="GRASS" && primtypePkm=="GROUND"||tipoAtk=="GRASS" && sectypePkm=="GROUND") effect = effect*2
    if(tipoAtk=="GRASS" && primtypePkm=="ROCK"||tipoAtk=="GRASS" && sectypePkm=="ROCK") effect = effect*2
    if(tipoAtk=="GRASS" && primtypePkm=="WATER"||tipoAtk=="GRASS" && sectypePkm=="WATER") effect = effect*2
    if(tipoAtk=="ELETRIC" && primtypePkm=="FLYING"||tipoAtk=="ELETRIC" && sectypePkm=="FLYING") effect = effect*2
    if(tipoAtk=="ELETRIC" && primtypePkm=="WATER"||tipoAtk=="ELETRIC" && sectypePkm=="WATER") effect = effect*2
    if(tipoAtk=="PSYCHC" && primtypePkm=="FIGHTING"||tipoAtk=="PSYCHC" && sectypePkm=="FIGHTING") effect = effect*2
    if(tipoAtk=="PSYCHC" && primtypePkm=="POISON"||tipoAtk=="PSYCHC" && sectypePkm=="POISON") effect = effect*2
    if(tipoAtk=="ICE" && primtypePkm=="FLYING"||tipoAtk=="ICE" && sectypePkm=="FLYING") effect = effect*2
    if(tipoAtk=="ICE" && primtypePkm=="GROUND"||tipoAtk=="ICE" && sectypePkm=="GROUND") effect = effect*2
    if(tipoAtk=="ICE" && primtypePkm=="GRASS"||tipoAtk=="ICE" && sectypePkm=="GRASS") effect = effect*2
    if(tipoAtk=="ICE" && primtypePkm=="DRAGON"||tipoAtk=="ICE" && sectypePkm=="DRAGON") effect = effect*2
    if(tipoAtk=="DRAGON" && primtypePkm=="DRAGON"||tipoAtk=="DRAGON" && sectypePkm=="DRAGON") effect = effect*2
    if(tipoAtk=="DARK" && primtypePkm=="GHOST"||tipoAtk=="DARK" && sectypePkm=="GHOST") effect = effect*2
    if(tipoAtk=="DARK" && primtypePkm=="PSYCHC"||tipoAtk=="DARK" && sectypePkm=="PSYCHC") effect = effect*2
    if(tipoAtk=="FAIRY" && primtypePkm=="FIGHTING"||tipoAtk=="FAIRY" && sectypePkm=="FIGHTING") effect = effect*2
    if(tipoAtk=="FAIRY" && primtypePkm=="DRAGON"||tipoAtk=="FAIRY" && sectypePkm=="DRAGON") effect = effect*2
    if(tipoAtk=="FAIRY" && primtypePkm=="DARK"||tipoAtk=="FAIRY" && sectypePkm=="DARK") effect = effect*2
    return effect
}

// função que calcula a damage de um ataque

fun damageCalc(tipoAtk:String, primtypePkm1:String, sectypePkm1:String?, primtypePkm2:String, sectypePkm2:String?, power:Int, level:Int, atk: Int, def: Int) : Double{
    var stab: Double = 1.0 //Guardará o valor do stab (Bônus se o ataque for do mesmo tipo que o Pokémon)
    if(tipoAtk==primtypePkm1||tipoAtk==sectypePkm1){
        println("Tem STAB")
        stab = 1.5
    }
    val effect : Double = 1*ineffect(tipoAtk,primtypePkm2,sectypePkm2)*superEffect(tipoAtk,primtypePkm2,sectypePkm2)*notveryEffect(tipoAtk,primtypePkm2,sectypePkm2) //Guardará o valor efetividade (Se é Ineffective, not, normal ou super effective).falta checkar a fraqueza.
    if (effect==0.0) println("Esse ataque não é eficaz contra o Pokemon defendendo")
    if (effect==0.5||effect==0.25) println("It's not very effective...")
    if (effect==1.0) println("Normal damage")
    if ((effect==2.0||effect==4.0)&&(notveryEffect(tipoAtk,primtypePkm2,sectypePkm2))!=0.5) println("It's Super Effective!!")
    val damage = ((((((2*level)/5)+2)*power*(atk/def))/50)+2)*stab*effect // calculo básico do dano
    return damage
}


fun main() {
    val pkm1:Pokemon = Pokemon("WATER","GROUND",100,236,135,125,222) //iniciando pkm1
    val pkm2:Pokemon = Pokemon("FIRE","WATER",100,216,115,195,202) // iniciando pkm2
    val atq:Ataque = Ataque("STEEL",120,false) //iniciando o ataque
    if(atq.special){ //Verifica se é special ou physical attack
        val dano = damageCalc(atq.tipo, pkm1.tipoPrim, pkm1.tipoSec, pkm2.tipoPrim, pkm2.tipoSec,atq.power, pkm1.level, pkm1.spatk, pkm2.spdef)
        println("Special Damage: $dano")
    }else{
        val dano = damageCalc(atq.tipo, pkm1.tipoPrim, pkm1.tipoSec, pkm2.tipoPrim, pkm2.tipoSec,atq.power, pkm1.level, pkm1.atk, pkm2.def)
        println("Physical Damage: $dano")
    }
}