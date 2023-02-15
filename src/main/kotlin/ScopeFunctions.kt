data class Produto(
    var titulo: String,
    var preco: Double,
    var ativado: Boolean = true,
    var descricao: String? = null
) {
    fun desativar() {
        ativado = false
    }
}


fun main() {
    val produto = Produto("Celular Xiaomi",1700.00)

    // -------------------LET  ->> executa caso a str não seja nula
    produto.descricao?.let {
        println("Produto sem descrição")
    }

    // -------------------RUN  ->> executa o bloco de informações sem retorno.
    produto.run {
        titulo = "microondas"
        preco = 4500.00
    }

    // -------------------WITH  ->> da mesmas forma do RUN, executa o bloco de informações sem retorno.
    with(produto){
        titulo = "Televisão 60 polegadas"
        desativar()
    }

    println(produto)

    // -------------------APPLY  ->> da mesmas forma do RUN, executa o bloco de informações, PORÉM, RETORNANDO O PROPRIO OBJETO.
    var newProduto = produto.apply {
        titulo = "carro 0km"
        descricao = "0km rodado"
    }

    println(newProduto)

    // -------------------ALSO  ->> "e também faça algo" depois do apply, retornando o proprio objeto
    produto.apply {
        titulo = "carro 0km"
        descricao = "0km rodado"
    }.also {
        println(it.titulo)
    }

/*
 * Let      -Unit       -it     ->> Encadear chamadas ou funções e/ou verificar nulos.
 * Run      -Unit       -this   ->> Inicializar objetos e calculo de retorno, ou qualquer função ao fim de uma operação.
 * With     -Unit       -this   ->> Executar funções, dentro de um contexto especifico ou bloco
 * Apply    -Objeto     -this   ->> Inicializar ou modificiar um objeto
 * Also     -Objeto     -it     ->> Ações adicionais que não alteram o objeto
 */


}