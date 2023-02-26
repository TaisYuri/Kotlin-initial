/**
 * companion object - Sempre somente 1 por classe. Pode ou não ser nomeado.
 * object - Quantos desejar por classe. Deve ter nome.
 * --
 * Ambos companion object e object são inicializados a primeira vez que são acessados.
 * Nas demais vezes, o valor já está disponível na execução do programa.
 */
fun main() {
    // Init disparado
    Matematica.Inscricao.PI

    // Init não é mais chamado
    Matematica.Inscricao.PI
    Matematica.Inscricao.PI
}

class Matematica {
    object Inscricao {
        val PI = 3.145
        fun teste() {}

        init {
            print("Init disparado!")
        }
    }

    companion object NOME {
        val PI = 3.145

        init {
            print("Init disparado!")
        }
    }
}