package com.sml.springcloudconfig.lock;

public interface Lock {

    Boolean lock(String key);

    Boolean unlock(String key);

}
