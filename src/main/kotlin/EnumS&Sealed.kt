fun main(args: Array<String>) {
    //-------------------DATA CLASS
    val pessoa1 = Pessoa("Tais", 30)
    pessoa1.sobrenome = "Silva Sauro"

    if (pessoa1.idade >= 30) {
        println("${pessoa1.nome} ${pessoa1.sobrenome} é muito idosa ;(")
    }

//-------------------ENUM SEM PARAMETRO
    val direcao = Direcao.LESTE
    when (direcao) {
        Direcao.NORTE -> println("rotacionar 90 graus ao norte")
        Direcao.LESTE -> println("rotacionar 90 graus ao leste")
        Direcao.OESTE -> println("rotacionar 90 graus ao oeste")
        else -> println("rotacionar 90 graus ao sul")
    }

//-------------------ENUM COM PARAMETRO
    println("ENUM de pessoa ${PessoaEnum.LUCAS.nome}")

//-------------------SEALED (FUNÇÃO DE CHAMADA CRIADA MAIS ABAIXO)
    verificaConta(ContaBancaria.Padrao)
    verificaConta(ContaBancaria.Black(3000))
}


data class Pessoa(val nome: String, val idade: Int) {
    var sobrenome = "Souza"
}

enum class Direcao {
    NORTE, SUL, LESTE, OESTE
}

//ENUM com parametros
enum class PessoaEnum(val nome: String, val idade: Int) {
    LUCAS("Lucas", 10),
    MARIA("Maria", 52)
}

//SEALED Class
sealed class ContaBancaria {
    object Padrao : ContaBancaria()  //Sem parametro -> cria-se como OBJECT
    class Black(val pontos: Int) : ContaBancaria() //Com parametro -> cria-se como CLASS
}

fun verificaConta(conta: ContaBancaria) {
    when (conta) {
        is ContaBancaria.Padrao -> println("Ir para sessão de cliente Padrão")
        is ContaBancaria.Black -> println("Ir para sessão de cliente Black que possui ${conta.pontos} pontos")
    }
}

