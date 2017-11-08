package br.com.beblue.fatec.livecoding

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration


class OurApplication : Application() {

    //TODO - Remind to add application name on AndroidManifest.xml

    val DB_NAME = "mydb.realm"

    override fun onCreate() {
        super.onCreate()

        Realm.init(this)
        Realm.setDefaultConfiguration(RealmConfiguration.Builder().name(DB_NAME).deleteRealmIfMigrationNeeded().build())
    }

}