//Para que a classe seja herdada, é necessário adicionar OPEN
open class Eletronico(var marca: String){

    private fun corrente(ativo: Boolean){}  //Não é acessivel por nenhuma outra classe

    open fun ligar(){
        corrente(true)
    }

    fun desligar(){
        corrente(false)
    }
}

class Computador(marca: String): Eletronico(marca){
    fun instalarSoftware(){}

    //Override - Sobrescrever o comportamento da classe mãe.
    //obs: a classe que será sobrescrita, deve ter o comportamento de OPEN.
    override fun ligar(){
        instalarSoftware()
        super.ligar() //classe de origem da mãe deve ter SUPER
    }


    //Overload - Sobreescrita de parametros.
    //Mesmo nome de classe, porém com tipos e quantidade de parametros diferentes
    fun save(){}
    fun save(a: Int, b: Int){}
    fun save(a: Float){}

}

fun main(){
    var eletronic1 = Computador("Dell")
    eletronic1.ligar()
}