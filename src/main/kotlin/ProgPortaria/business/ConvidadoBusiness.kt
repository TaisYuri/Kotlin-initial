package ProgPortaria.business

import ProgPortaria.entity.Convidado

class ConvidadoBusiness {
    fun tipoValido(tipoConvite: String) = (tipoConvite == "comum" || tipoConvite == "premium" || tipoConvite == "luxo")

    fun codigoValido(convidado: Convidado): Boolean {
        return when (convidado.tipoConvite) {
            "comum" -> convidado.codigo.startsWith("xt")
            "premium", "luxo" -> convidado.codigo.startsWith("xl")
            else -> false
        }
    }

    fun maiorIdade(idade: Int) = idade < 18
}