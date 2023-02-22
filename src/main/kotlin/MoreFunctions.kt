fun main(args: Array<String>) {

    // -------------------NULL SAFETY
    var str: String? = null
    println(str ?: "str está nulo" )   //Operador ELVIS

    // -------------------LET  ->> executa caso a str não seja nula
    /* seria igual a realizar o if abaixo:
        if(str != null){ str.length}
    */
    str?.let {
        it.length
    }

    // -------------------chamada VARARG
    val notas = media(10f, 2.5f, 5f, 8.3f)
    println("Media ${notas}")

    // ------------------- GENERICS
    val notas2 = mediaGenerics("Teste do tipo J (qualquer tipo)", 2.5f, 5, true, "teste", 8.3f)
    println("Media ${notas2}")


    // ------------------- chamada Nothing
    save()
}

// ------------------- VARARG
// precisa sempre ser a ultima prop passada na função.
fun media(vararg notas: Float): Float{
    var soma = 0f
    for (n in notas){
        soma += n
    }
    return (soma / notas.size)
}

// ------------------- GENERICS
// Aceita todos os tipos.
fun <T, J> mediaGenerics(abc: J, vararg notas: T): Float{
    var soma = 0f
    for(n in notas){
        if(n is Float){
            soma += n
        }
    }
    println("Valor de abc sem saber o tipo de J até sua instancia ${abc}")
    return (soma / notas.size)
}

// ------------------- Nothing
// Tipo que apenas retorna uma exception
fun save(): Nothing{
    TODO("Aguardando backend para implementação")
}