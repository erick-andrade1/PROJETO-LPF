//Programa que roda no navegador
import kotlinx.browser.*


@JsName("botaoLimpar")
fun limpar() {
    val elem = document.getElementById("p1")
    if (elem!=null) {
        elem.innerHTML = ""
    }
}

@JsName("botaoClicado")
fun botaoClicado(nome:String) {
    val elem = document.getElementById("p1")
    if (elem!=null) {
        elem.innerHTML += """
            <br> <font color="$nome">Este texto foi inserido pelo programa Kotlin 
            ao pressionar o botao $nome</font>
            <button onclick="frontend.botaoClicado('yellow')">Nao aperte esse botao</button>
            """
    }
}

fun main() {
    for (c in 1..100)
    window.setInterval({
        val elem = document.getElementById("p1")
        if (elem!=null) {
            elem.innerHTML += "<br> Tick\n"
        }
    },1000)
}