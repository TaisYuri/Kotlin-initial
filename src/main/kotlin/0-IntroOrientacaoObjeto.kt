import kotlin.random.Random

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

class Team(){
    var players: MutableList<Humano> = mutableListOf()

    fun getAllPlayersWithBiggerThan( size: Int): List<Humano>{
        return this.players.filter { it -> it.nome.length > size }
    }

    fun printAllPlayer(){
        this.players.forEach{ player -> println("name: ${player.nome}")}
    }
}


fun main(args: Array<String>) {
    val pessoa = Humano("Mellow", "Brasil", 2020)
    pessoa.idadeAtual()

    //Caso seja necessário apenas instanciar a classe para executar funções, não há necessidade de atribuição e criação de novas variaveis.
    Humano("Irineu", "Brasil").linguagem()

    var animal = Animal("Gato")
    animal.name = "Tom"

    val timeBrasil = Team()
    timeBrasil.players.add(pessoa)
    timeBrasil.printAllPlayer()
}


//------------------------------------------- EXEMPLO DE CLASSE CONTA BANCARIA COM SAQUE E DEPOSITO


class Account(name: String){
    private var id: Int
    private var balance: Double
    var name: String
    var address: String

    init {
        this.name = name
        this.balance = 0.0
        this.address = ""
        this.id = Random.nextInt(0, 99999)
    }

    fun print(){
        println("saldo: ${this.balance}, conta: ${this.id} - nome: ${this.name}")
    }

    fun deposit( amount: Double){
        balance = balance + amount
    }

    fun withdraw (amount: Double): Double{
        balance = balance - amount
        return balance
    }
}