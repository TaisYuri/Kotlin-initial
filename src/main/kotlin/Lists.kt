fun main(args: Array<String>) {
    // ------------------- LIST  (IMUTABLE)
    val list = listOf("Banana", "Maça", "Abacaxi")

    println(list[2])
    println(list.subList(1, 3))  //retorna a lista de acordo com o index passado
    println(list.contains("Maça"))  //se contém
    println(list.isEmpty()) //se esstá vazia

    list.forEach {
        println(it)
    }

    // ------------------- MUTABLELIST
    val legumes = mutableListOf("Batata", "Cenoura", "Quiabo")

    legumes.add("Abobrinha")
    legumes.removeAt(1)
    legumes.addAll(listOf("berinjela", "Batata"))

    println(legumes)

    // ------------------- SET   [mesmo de list, porém, não deixa repetir valores.]
    var numeros = setOf(1, 2, 3, 3, 3)
    println(numeros)  //saida [1, 2, 3]


    // ------------------- MAP
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
    listFeira.add("verdura" to "rucula")

    println(listFeira)

}