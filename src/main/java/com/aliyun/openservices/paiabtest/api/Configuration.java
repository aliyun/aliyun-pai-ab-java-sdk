package com.aliyun.openservices.paiabtest.api;


import com.aliyun.teaopenapi.models.Config;

public class Configuration {
    private String instanceId;

    private String domain = null;

    private Config config;

    public boolean isVpc() {
        return vpc;
    }

    public void setVpc(boolean vpc) {
        this.vpc = vpc;
    }

    private boolean vpc = false;

    public Configuration(String regionId, String accessKeyId, String accessKeySecret ) {
        this.config = new Config();
        this.config.setAccessKeyId(accessKeyId);
        this.config.setAccessKeySecret(accessKeySecret);
        this.config.setType("access_key");
        this.config.setRegionId(regionId);
        //this.instanceId = instanceId;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getDomain() {
        if (this.domain == null) {
            if (this.vpc) {
                this.domain = "paiabtest-vpc." +this.config.getRegionId() + ".aliyuncs.com";
            } else {
                this.domain = "paiabtest." +this.config.getRegionId() + ".aliyuncs.com";
            }
        }
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Config getConfig() {
        this.config.setEndpoint(this.getDomain());
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

}