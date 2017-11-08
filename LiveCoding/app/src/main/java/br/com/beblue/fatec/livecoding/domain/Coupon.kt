package br.com.beblue.fatec.livecoding.domain

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

// TODO - Remind to add OPEN - Open is the opposite of a final java class
open class Coupon : RealmObject() {

    @PrimaryKey
    var uuid : String  = UUID.randomUUID().toString()

    var key : String? = null

    var date : String? = null

    var amount : Float? = null

    var cpf : String? = null

    var company : Company? = null

}