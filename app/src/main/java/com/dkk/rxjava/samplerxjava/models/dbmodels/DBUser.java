package com.dkk.rxjava.samplerxjava.models.dbmodels;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by deepak on 27/2/17.
 */

public class DBUser extends RealmObject {


    private String name;
    @PrimaryKey
    private String userId;
    private long lastLoginTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
