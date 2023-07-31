/**
 * Para que a classe seja herdada, é necessário adicionar OPEN ao inicio da criação da classe
 * Override - Sobrescrever o comportamento da classe mãe.
 * Sempre que for referenciar um atributo ou metodo da classe mãe, necessita utilizar a palavra SUPER
*/
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

//------------------------ EXEMPLO COM UMA CLASSE PESSOA E UMA CLASSE PLAYER QUE HERDA DE PESSOA

open class Person{
    var name: String = ""
    var email: String = ""

    //override para toString necessário para exibição dos dados
    override fun toString() = "nome: ${name} - email: ${email}"

}

class Player: Person(){
    var number: Int = 0

    /** pode ser escrito desta forma, como também da outra que está ativa mais abaixo.
     * override fun toString():String{
     *    return "nome: ${super.name} - email: ${super.email} - number: ${this.number}"
     * }
     */

    override fun toString() = super.toString() + "- number: ${this.number}"

}
