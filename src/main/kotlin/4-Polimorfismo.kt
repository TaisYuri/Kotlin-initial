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

    //---------------------- exemplo Animalzinho
    val ant = Ant(1)
    val lion = Lion(2)

    val animalList: List<Animalzinho> = listOf(ant, lion)

    animalList.forEach{
        animal ->
            animal.feed()
            println("teste ${ animal }")
            animal.feed()
            animal.feed()
            println(lion)

            if(animal is Lion){
                lion.roar()
            }
    }

    //--------------------- exemplo Factory
    val animalList2 : MutableList<Animalzinho> = mutableListOf()
    val factory = AnimalFactory()

    for (i in 1..10){
       val animal = factory.createAnimal(i % 2, i) //divide ant e lion entre impar e par
        animalList2.add(animal)
    }

    animalList2.forEach {
        animal -> println(animal)
    }
}

/*

 */
abstract class Animalzinho(val id: Int){
    var energy: Int = 0
    abstract var minEnergy: Int

    abstract fun feed()

    fun isHungry(): Boolean = energy < minEnergy

    override fun toString(): String {
        return "id: $id - Energia: ${this.energy} - isHungry ${isHungry()}"
    }
}

class Ant(id: Int): Animalzinho(id){
    override var minEnergy = 2

    override fun feed(){
        this.energy++
    }
}

class Lion(id: Int): Animalzinho(id){
    override var minEnergy = 100

    override fun feed(){
        this.energy = energy + 70
    }

    fun roar(){
        return println("ROARRRRRRR")
    }
}

/*
* ----------------------------- FACTORY
* Uma forma elegante de implementar polimorfismo (utilizado como padrão de design)
* exempl: utilizando como base a classe animal acima
 */

class AnimalFactory{

    fun createAnimal(type: Int, id: Int): Animalzinho{
        return when(type){
            1 -> Ant(id)
            else -> Lion(id)
        }
    }
}