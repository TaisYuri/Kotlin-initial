fun main(args: Array<String>) {
    saudar { it.uppercase() }

    //------------------------High-Order Functions [função de alta prioridade]
    //(funçãoQualquer) => retornoDaFunção
    //Neste exemplo, a função instancia uma classe USER
    val printUser:(User) -> String = {
        it.name
    }
    println( printUser(User("Tais", 30)))

    //No exemplo abaixo, recebemos uma função (chamada operation) como parametro da função, e esta por sua vez não precisa saber o que será executado, apenas seu tipo certo.
    fun firstHighOrderFunction(text1: String, text2: String, operation: (String, String) -> Unit){
        operation(text1, text2)
    }

    //chamada
    //criação de uma função qualquer
    fun concatString(val1:String, val2: String) = println(val1 + val2)
    firstHighOrderFunction("Hello ","world", ::concatString)  //colocamos :: para não executar a função e precisar passar os parametros.


    //------------------------Lambda (Funções anonimas)
    // {parametros -> corpo}
    val multiplicacao = { x: Int, y: Int -> x * y}

    val contemQtdCaracteres: (String) ->  Boolean = {nome -> nome.length > 5}
    println(contemQtdCaracteres("Teste de string"))

    val soma: (Int, Int) -> Int = { x, y -> x + y}
    println(soma(13, 21))

    fun receiveABC( lamb: (a: Int, b: Int, c: Int) -> Int){}
    receiveABC{x: Int, y: Int, z: Int ->
        println("executando função lambda")
        x + y + z
    }

    //Outro exemplo utilizando dentro de High order function
    val printStringOfLetter = {val1: String, val2: String ->
        println("$val1 has ${val1.length} letters and $val2 has ${val2.length} letter")
    }
    firstHighOrderFunction("Tais", "Yuri", printStringOfLetter) //funcção criada mais acima em High-Order Functions

    //outro exemplo
    val divisao: (Int) -> Int = {it/2}
    println(divisao(6))

    //outro exemplo
    val operation = {numero1: Int, numero2: Int ->
        var result = numero1 * 2
        result = result / numero2
        result
    }

    //chamada do infix
    val numberDouble = 5.0 mySum 15.0
    println(numberDouble)


    //------------------------ EXTENSION FUNCTIONS
    val idadeDog = 10
    idadeDog.multPorQuinze()

    //utilizando uma classe para extender umas função
    val usuario = User("Maria", 47)
    usuario.apresentacao()

    val number = 30
    println(number.multPorDois())
}

fun saudar(modificador: (String) -> String) {
    println(modificador("Hello World"))
}

data class User(val name: String, val idade: Int)

fun User.apresentacao(){
    println("Meu nome é ${this.name} e tenho ${this.idade} anos")
}

fun Int.multPorQuinze(){
    println("Idade do Dogueneo: ${this.times(15)}")
}

fun Int.multPorDois(): Boolean{
    return this % 2 === 0
}

//------------------------ EXTENSION FUNCTIONS COM INFIX (OUTRA FORMA DE DECLARAÇÃO)

infix fun Double.mySum(number2: Double): Double{
    return this + number2
}
// chamada do infix
// val numberDouble = 5.0 mySum 15.0
