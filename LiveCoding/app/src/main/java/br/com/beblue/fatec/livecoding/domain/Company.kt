package br.com.beblue.fatec.livecoding.domain

import com.google.gson.annotations.SerializedName

/**
 * Created by viking on 07/11/17.
 */
class Company {

    var nome : String? = null
    var situacao : String? = null
    var telefone : String? = null
    @SerializedName("atividade_principal") var atividadePrincipal : List<AtividadePrincipal>? = null

    class AtividadePrincipal {
        @SerializedName("text") var descricao : String? = null
    }
}