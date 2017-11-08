package br.com.beblue.fatec.livecoding.db

import io.realm.Realm
import io.realm.RealmObject

class DatabaseManager {

    public var instance : Realm? = null

    companion object {

        @JvmStatic fun insert(Abc : RealmObject){

            val defaultInstance = Realm.getDefaultInstance()


        }

    }
}

