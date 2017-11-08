package br.com.beblue.fatec.livecoding.domain

import io.realm.RealmObject

/**
 * Created by viking on 07/11/17.
 */
open class Company : RealmObject() {

    var nome : String? = null
    var situacao : String? = null
    var telefone : String? = null
//    @SerializedName("atividade_principal") var atividadePrincipal : List<AtividadePrincipal>? = null
//
//    class AtividadePrincipal : RealmObject() {
//        @SerializedName("text") var descricao : String? = null
//    }
}