package com.dkk.rxjava.samplerxjava.manager;

import io.realm.Realm;

/**
 * Created by deepak on 27/2/17.
 */

public class DBManager {


    public static Object getRealmObject(Class cls) {
        Realm realm = Realm.getDefaultInstance();
        if(null != realm) {
            return  realm.where(cls).findFirst();
        }
        return null;
    }
}
