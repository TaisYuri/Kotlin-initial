fun main(args: Array<String>) {
    // ------------------- LIST  (IMUTABLE)
    val list: List<String> = listOf("Banana", "Maça", "Abacaxi")

    println(list[2])
    println(list.subList(1, 3))  //retorna a lista de acordo com o index passado
    println(list.contains("Maça"))  //se contém
    println(list.isEmpty()) //se esstá vazia

    list.forEach {
        println(it)
    }

    // ------------------- MUTABLELIST
    val legumes: MutableList<String> = mutableListOf("Batata", "Cenoura", "Quiabo")

    legumes.add("Abobrinha")
    legumes.removeAt(1)
    legumes.addAll(listOf("berinjela", "Batata"))

    println(legumes)

    // ------------------- SET   [mesmo de list, porém, não deixa repetir valores.]
    var numeros = setOf(1, 2, 3, 3, 3)
    println(numeros)  //saida [1, 2, 3]


    // ------------------- MAP
    //chave não pode ser duplicada (retornará o ultimo adicionado)
    val mapNumeros = mapOf(
        "chave1" to 1,
        "chave2" to 22
    )

    println(mapNumeros.keys)
    println(mapNumeros.containsKey("chave1")) //retorna se existe a chave pesquisada
    println(mapNumeros["chave2"])

    // -------------------MUTABLELIST COM MAP
    val listFeira = mutableListOf("legume" to "Quiabo", "fruta" to "Abacaxi")
    listFeira.add("verdura" to "Alface")

    //também pode ser criado desta forma
    val paises = mutableMapOf<String, String>(Pair("Brasil", "Brasilia"), Pair("Alemanha", "Berlim"))

    println(listFeira)

    // ------------------- FUNÇÕES UTEIS
    // ------------------- ANY
    println("Tenho dados? ${if (paises.any()) "sim" else "não"}")

    // ------------------- COUNT
    println("Quantidade de elementos ${paises.count()}")

    // ------------------- FIRST & LAST
    println(list.first())
    println(list.firstOrNull()) //não ocorre erro caso a lista esteja vazia
}
