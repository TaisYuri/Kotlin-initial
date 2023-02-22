package ProgPortaria.control

import ProgPortaria.business.ConvidadoBusiness
import ProgPortaria.entity.Convidado

class Portaria {

    private val convidadoBusiness = ConvidadoBusiness()

    init{
        println("Portaria inicializada.")
        println(controle())
    }

    private fun controle(): String{
        val idade = Console.readInt("Qual sua idade? ")
        val convidado = Convidado(idade = idade)

        if(convidadoBusiness.maiorIdade(convidado.idade)){
            return "Negado! Menores de idade não são permitidos"
        }

        convidado.tipoConvite = Console.readString("Qual o tipo de convite? ")
        if(!convidadoBusiness.tipoValido(convidado.tipoConvite)){
            return "Negado! Convite inválido"
        }

        convidado.codigo = Console.readString("Qual o código do seu convite?")
        if(!convidadoBusiness.codigoValido(convidado)){
            return "Negado! Convite inválido"
        }

        return "Welcome ;)"

    }
}