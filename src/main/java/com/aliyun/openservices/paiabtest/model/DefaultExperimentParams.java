package com.aliyun.openservices.paiabtest.model;

import java.util.HashMap;
import java.util.Map;

public class DefaultExperimentParams implements ExperimentParams{
    Map<String, Object> parameters = new HashMap<>(8);

    @Override
    public void addParam(String key, Object value) {
        this.parameters.put(key, value);
    }

    @Override
    public void addParams(Map<String, Object> params) {
        this.parameters.putAll(params);
    }

    @Override
    public Object get(String key, Object defaultValue) {
        return this.parameters.getOrDefault(key, defaultValue);
    }

    @Override
    public String getString(String key, String defaultValue) {
        if (this.parameters.containsKey(key)) {
            Object val = this.parameters.get(key);
            if (val instanceof String) {
                return (String)val;
            } else {
                return String.valueOf(val);
            }
        } else {
            return defaultValue;
        }
    }

    @Override
    public int getInt(String key, int defaultValue) {
        if (this.parameters.containsKey(key)) {
            Object val = this.parameters.get(key);
            if (val instanceof Integer) {
                return (Integer) val;
            } else if (val instanceof String) {
                return Integer.valueOf((String) val);
            } else if (val instanceof Double) {
                return ((Double) val).intValue();
            } else {
                return defaultValue;
            }
        } else {
            return defaultValue;
        }
    }

    @Override
    public long getLong(String key, long defaultValue) {
        if (this.parameters.containsKey(key)) {
            Object val = this.parameters.get(key);
            if (val instanceof Long) {
                return (Long) val;
            } else if (val instanceof String) {
                return Long.valueOf((String) val);
            }else if (val instanceof Double ) {
                return ((Double) val).longValue();
            } else {
                return defaultValue;
            }
        } else {
            return defaultValue;
        }
    }

    @Override
    public float getFloat(String key, float defaultValue) {
        if (this.parameters.containsKey(key)) {
            Object val = this.parameters.get(key);
            if (val instanceof Float) {
                return (Float) val;
            } else if (val instanceof String) {
                return Float.valueOf((String) val);
            } else if (val instanceof Double) {
                return ((Double) val).floatValue();
            } else {
                return defaultValue;
            }
        } else {
            return defaultValue;
        }
    }

    @Override
    public double getDouble(String key, double defaultValue) {
        if (this.parameters.containsKey(key)) {
            Object val = this.parameters.get(key);
            if (val instanceof Double) {
                return (Double) val;
            } else if (val instanceof String){
                return Double.valueOf((String) val);
            } else {
                return defaultValue;
            }
        } else {
            return defaultValue;
        }
    }

    @Override
    public Map<String, Object> getAllParams() {
        return this.parameters;
    }
}