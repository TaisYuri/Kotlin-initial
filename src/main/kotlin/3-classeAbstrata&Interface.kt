/** CLASSE ABSTRATA
 * Não podem ser inicializadas; podem ter atributos não inializados e podem ter métodos sem corpo.
 * Servem para compartilhar código comum entre classes, forçando as classes filhas a implementarem partes especificas da classe pai.
 * Tanto a classe quanto o método e atributo que será abstrata, precisam carregar a palavra "abstract".
 **/

abstract class Mamifero(val nome: String){
    fun acordar(){}
    fun dormir(){}

    abstract fun falar()
}

class Cachorro(nome: String): Mamifero(nome){

    //obrigatório a implementação do override
    override fun falar() {
        println("au au")
    }
}

//----------------- EXEMPLO COM PLAYER E GOLEIRO QUE IRÁ HERDAR DE PLAYER
abstract class PlayerSoocer{
    abstract var name: String
    abstract var email: String

    abstract fun rating(): Int

    fun isAGoodPlayer(): Boolean{
        return rating() > 5
    }
}

class GoalKeeper: PlayerSoocer(){
    override var name = ""
    override var email = ""
    var golsConced = 0

    override fun rating(): Int{
        return when{
            golsConced < 15 -> 10
            golsConced < 30 -> 5
            else -> 0
        }
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
// ----------------------- Outro exemplo utulizando como base o playerSoccer da classe abstrata com suas diferenças de implementação para interface
interface Player1{
    var name: String
    var email: String

    fun rating(): Int
    fun isAGoodPlayer(): Boolean{
        return rating() > 5
    }
}

class GoalKeeper1: Player1{
    override var name = ""
    override var email = ""
    var golsConced = 0

    override fun rating(): Int{
        return when{
            golsConced < 15 -> 10
            golsConced < 30 -> 5
            else -> 0
        }
    }
}

fun main(){
    val doguinho = Cachorro("Rakan")
    doguinho.falar()

    var jogador1= GoalKeeper()
    jogador1.name = "jogador1"
    jogador1.email = "jogador1@teste.com"
    jogador1.golsConced = 5
    println(jogador1.rating())
    println(jogador1.isAGoodPlayer())
}
