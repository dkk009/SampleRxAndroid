package com.dkk.rxjava.samplerxjava.application;

import android.app.Application;
import android.util.Log;

import com.dkk.rxjava.samplerxjava.models.dbmodels.DBUser;

import io.realm.DynamicRealm;
import io.realm.DynamicRealmObject;
import io.realm.FieldAttribute;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
import io.realm.RealmObjectSchema;
import io.realm.RealmResults;
import io.realm.RealmSchema;

/**
 * Created by deepak on 24/2/17.
 */

public class RXJavaApplication extends Application {

    private static RXJavaApplication instance;
    public static final String TAG = RXJavaApplication.class.getSimpleName();

    private static String DB_NAME =  "sample_db";
    public static RXJavaApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initDB();
    }

    private void initDB() {
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name(DB_NAME).schemaVersion(1).migration(new MyMigration()).build();
        Realm.setDefaultConfiguration(realmConfiguration);


    }

    private static class MyMigration implements RealmMigration {

        @Override
        public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
            Log.d(TAG,"migrate,OldVersion:" + oldVersion +",NewVersion:" + newVersion);
            RealmSchema schema = realm.getSchema();
            if(newVersion == 2) {
                RealmObjectSchema realmSchema = schema.get(DBUser.class.getSimpleName());
                realmSchema.addField("userId",String.class)
                        .transform(new RealmObjectSchema.Function() {
                            @Override
                            public void apply(DynamicRealmObject obj) {
                                obj.set("userId",obj.getString("id"));
                            }
                        }).removeField("id");

                 realmSchema.addPrimaryKey("userId");
            }
        }
    }
}
