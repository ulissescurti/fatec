package br.com.beblue.fatec.livecoding.db;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;

public class DBManager {

    private static Realm instance;

    public static void insert(RealmObject obj){
        getInstance();
        instance.beginTransaction();
        instance.insert(obj);
        instance.commitTransaction();
    }

    public static List<RealmObject> listAll(Class clz) {
        return getInstance().where(clz).findAll();
    }

    private static Realm getInstance() {
        if(instance == null)
            instance = Realm.getDefaultInstance();
        return instance;
    }
}