package com.aliyun.openservices.paiabtest.model;

import com.google.gson.annotations.SerializedName;

public class ExpParameter {
    @SerializedName("key")
    private String key = null;

    @SerializedName("type")
    private String type = null;

    @SerializedName("value")
    private Object value = null;


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
