fun main(args: Array<String>) {
    saudar { it.uppercase() }

    //------------------------High-Order Functions [função de alta prioridade]
    //(funçãoQualquer) => retornoDaFunção
    //Neste exemplo, a função instancia uma classe USER
    val printUser:(User) -> String = {
        it.name
    }
    println( printUser(User("Tais", 30)))


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

    //------------------------ EXTENSION FUNCTIONS
    val idadeDog = 10
    idadeDog.multPorQuinze()

    //utilizando uma classe para extender umas função
    val usuario = User("Maria", 47)
    usuario.apresentacao()


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