/** POLIMORFISMO
 *  os mesmos atributos e objetos podem ser utilizados em objetos distintos, porém, com implementações e lógicas diferentes
 */

interface Funcionario{
    val salario: Float
    fun bonus(): Float
}

class Gerente(override val salario: Float): Funcionario {
    override fun bonus(): Float {
        return salario * 0.5f
    }
}

class Analista(override val salario: Float): Funcionario{
    override fun bonus(): Float {
        return salario * 0.2f
    }
}

/* Ao inves de criar 2 funções para mostrarBonus (gerente e outra para analista), cria-se apenas uma função do tipo deles.
* Pois cada classe possui os mesmos atributos definidos na interface ou classe abstrata (mesmo que com implementações diferentes, o retorno é do mesmo tipo)
* */
fun mostraBonus(func: Funcionario){
    println(func.bonus())
}


fun main(){
    mostraBonus(Gerente(4000f))
    mostraBonus(Analista(3000f))
}
