
class Humano(val nome: String, val paisNacimento: String){

    var nascimento: Int? = null
    private var linguaNativa = ""

    //construtor secundário
    constructor(nome: String, paisNacimento: String, anoNascimento: Int): this(nome, paisNacimento){
        this.nascimento = anoNascimento
    }

    //Init ->> executado sempre que instanciado a classe
    init {
        linguaNativa = if(paisNacimento == "Brasil"){
            "PT-BR"
        }else {
            "EN"
        }
    }

    fun linguagem(){
        println(linguaNativa)
    }


    fun idadeAtual(){
        this.nascimento?.let {
            println(2023 - it)
        }
    }
}


class Animal(var especie: String){
    var name = ""
        //Metodo Get
        //->> deve ser declarado apenas quando há mais do que apenas o retorno da variavel. Pois implicitamente, já está implementado no kotlin
        // utilizar a palavra field para retorno da variavel
        get(){
            println("Acesso get")
            return field
        }

        //Metodo Set
        set(value){
            println("Acesso set")
            field = value
        }
}


fun main(args: Array<String>) {
    val pessoa = Humano("Mellow", "Brasil", 2020)
    pessoa.idadeAtual()

    //Caso seja necessário apenas instanciar a classe para executar funções, não há necessidade de atribuição e criação de novas variaveis.
    Humano("Irineu", "Brasil").linguagem()

    var animal = Animal("Gato")
    animal.name = "Tom"
}


