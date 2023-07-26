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

    val listNumbers = listOf(2,4,5,6,8)
    val divider = listNumbers.map{ it/ 2 }   //[1, 2, 2, 3, 4]

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

    // ------------------- FILTER
    val listNumber = listOf(1,2,3,4,5,6,7,8,9)

    val filtered = listNumber.filter{ it % 2 == 0} // [2, 4, 6, 8]
    val filteredNot = listNumber.filterNot{ it % 2 == 0} // [1, 3, 5, 7, 9]
    val biggerThan4 = listNumber.filter{ it > 4} // [5, 6, 7, 8, 9]

    // ------------------- ZIP  [junta duas listas (se tiver tamanhos diferentes, será apresentado até seu par combinar, os demais são desprezados)]
    val cities = listOf("São Paulo", "Rio de Janeiro", "Porto Alegre")
    val codCities = listOf(300, 2390, 510)

    val citiesBycode = cities.zip(codCities){ city, cod -> "codigo: $cod - $city"}

    // ------------------- ASSOCIATE
    //retorna algo associado a cada elemento da lista. No exemplo, o tamanho
    val mapCities = cities.associateWith{ it.length }
    //{São Paulo=9, Rio de Janeiro=14, Porto Alegre=12}

    val multipli = listNumber.associateBy{ it * 2}
    //também faz a mesma coisa, porém o resultado vem antes
    //{4=2, 8=4, 10=5, 12=6, 16=8}

    // ------------------- FOR EACH
    cities.forEach{ println(it) }

    cities.filter{ it.length > 10}.forEach{ println(it)}
}
