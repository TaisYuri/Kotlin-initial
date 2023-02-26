/** CLASSE ABSTRATA
 * função que terá sobrescrita( Override ) toda vez que for chamada, pois cada classe
 * que herdar, irá implementar de um jeito diferente
 * fun falar(){
 *      o cachorro ficará "au au", gato: "miau" e assim por diante
 * }
 **/

abstract class Mamifero(val nome: String){
    fun acordar(){}
    fun dormir(){}

    //tanto a classe quanto a função que será abstrata, precisam carregar a palavra "abstract"
     abstract fun falar()
}

class Cachorro(nome: String): Mamifero(nome){
    //obrigatório a implementação do override
    override fun falar() {
        println("au au")
    }
}


/** INTERFACE
 * cria um contrato que deverá ser implementada na classe que instancia-la (pode ser também através do override)
 * como principais diferenças com classe abstrata é que:
 * 1 - não pode inicializar valores de variaveis.
 * 2 - deixa implementar mais de uma interface na classe que chama-la (classes herdam apenas de uma outra classe)
 **/

interface Selvagem{
    fun atacar() //neste exemplo, terá sobrescrita pois cada animal ataca de uma forma
}

class Lobo(nome: String): Mamifero(nome), Selvagem{
    override fun falar() {
        println("auuuuuuuuuuu")
    }

    override fun atacar() {
        println("garra")
    }

}

fun main(){
    val doguinho = Cachorro("Rakan")
    doguinho.falar()
}
