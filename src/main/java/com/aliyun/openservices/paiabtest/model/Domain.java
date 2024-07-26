package com.aliyun.openservices.paiabtest.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.aliyun.openservices.paiabtest.common.Constants;
import com.aliyun.tea.utils.StringUtils;
import com.google.gson.annotations.SerializedName;
/**
 * Domain
 */

public class Domain {
  @SerializedName("workspace_id")
  private String workspaceId = null;

  @SerializedName("exp_domain_id")
  private Integer expDomainId = null;

  @SerializedName("exp_project_id")
  private Integer expProjectId = null;

  @SerializedName("exp_layer_id")
  private Integer expLayerId = null;

  @SerializedName("is_default_domain")
  private Boolean isDefaultDomain = null;

  @SerializedName("exp_domain_name")
  private String expDomainName = null;

  @SerializedName("project_name")
  private String projectName = null;

  @SerializedName("layer_name")
  private String layerName = null;

  @SerializedName("exp_domain_info")
  private String expDomainInfo = null;

  @SerializedName("bucket_type")
  private Integer bucketType = null;

  @SerializedName("experiment_flow")
  private Integer experimentFlow = null;

  @SerializedName("debug_users")
  private String debugUsers = null;

  @SerializedName("debug_crowd_ids")
  private String debugCrowdIds = null;

  @SerializedName("filter")
  private String filter = null;

  @SerializedName("buckets")
  private String buckets = null;

  // debug users map
  private Set<String> debugUserMap = new HashSet<>();

  private List<Feature> features = new ArrayList<>();
  private DiversionBucket diversionBucket = null;

  private List<Layer> layers = new ArrayList<>();

  public Domain workspaceId(String workspaceId) {
    this.workspaceId = workspaceId;
    return this;
  }

   /**
   * 工作空间 ID
   * @return workspaceId
  **/
  public String getWorkspaceId() {
    return workspaceId;
  }

  public void setWorkspaceId(String workspaceId) {
    this.workspaceId = workspaceId;
  }

  public Domain expDomainId(Integer expDomainId) {
    this.expDomainId = expDomainId;
    return this;
  }

   /**
   * 实验域id
   * @return expDomainId
  **/
  public Integer getExpDomainId() {
    return expDomainId;
  }

  public void setExpDomainId(Integer expDomainId) {
    this.expDomainId = expDomainId;
  }

  public Domain expProjectId(Integer expProjectId) {
    this.expProjectId = expProjectId;
    return this;
  }

   /**
   * 实验项目id
   * @return expProjectId
  **/
  public Integer getExpProjectId() {
    return expProjectId;
  }

  public void setExpProjectId(Integer expProjectId) {
    this.expProjectId = expProjectId;
  }

  public Domain expLayerId(Integer expLayerId) {
    this.expLayerId = expLayerId;
    return this;
  }

   /**
   * 所属的实验层id
   * @return expLayerId
  **/
  public Integer getExpLayerId() {
    return expLayerId;
  }

  public void setExpLayerId(Integer expLayerId) {
    this.expLayerId = expLayerId;
  }

  public Domain isDefaultDomain(Boolean isDefaultDomain) {
    this.isDefaultDomain = isDefaultDomain;
    return this;
  }

   /**
   * 是否是默认的实验域
   * @return isDefaultDomain
  **/
  public Boolean isIsDefaultDomain() {
    return isDefaultDomain;
  }

  public void setIsDefaultDomain(Boolean isDefaultDomain) {
    this.isDefaultDomain = isDefaultDomain;
  }

  public Domain expDomainName(String expDomainName) {
    this.expDomainName = expDomainName;
    return this;
  }

   /**
   * 实验域名称
   * @return expDomainName
  **/
  public String getExpDomainName() {
    return expDomainName;
  }

  public void setExpDomainName(String expDomainName) {
    this.expDomainName = expDomainName;
  }

  public Domain projectName(String projectName) {
    this.projectName = projectName;
    return this;
  }

   /**
   * 项目名称
   * @return projectName
  **/
  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  public Domain layerName(String layerName) {
    this.layerName = layerName;
    return this;
  }

   /**
   * 层名称，校验规则：[a-zA-Z][a-zA-Z1-9-]+
   * @return layerName
  **/
  public String getLayerName() {
    return layerName;
  }

  public void setLayerName(String layerName) {
    this.layerName = layerName;
  }

  public Domain expDomainInfo(String expDomainInfo) {
    this.expDomainInfo = expDomainInfo;
    return this;
  }

   /**
   * 实验域介绍
   * @return expDomainInfo
  **/
  public String getExpDomainInfo() {
    return expDomainInfo;
  }

  public void setExpDomainInfo(String expDomainInfo) {
    this.expDomainInfo = expDomainInfo;
  }

  public Domain bucketType(Integer bucketType) {
    this.bucketType = bucketType;
    return this;
  }

   /**
   * 分流类型，1：随机流量，2：根据条件过滤，默认1
   * @return bucketType
  **/
  public Integer getBucketType() {
    return bucketType;
  }

  public void setBucketType(Integer bucketType) {
    this.bucketType = bucketType;
  }

  public Domain experimentFlow(Integer experimentFlow) {
    this.experimentFlow = experimentFlow;
    return this;
  }

   /**
   * 流量占比，取值范围为0~100，单位%
   * @return experimentFlow
  **/
  public Integer getExperimentFlow() {
    return experimentFlow;
  }

  public void setExperimentFlow(Integer experimentFlow) {
    this.experimentFlow = experimentFlow;
  }

  public Domain debugUsers(String debugUsers) {
    this.debugUsers = debugUsers;
    return this;
  }

   /**
   * 灰度测试用户列表
   * @return debugUsers
  **/
  public String getDebugUsers() {
    return debugUsers;
  }

  public void setDebugUsers(String debugUsers) {
    this.debugUsers = debugUsers;
  }

  public Domain debugCrowdIds(String debugCrowdIds) {
    this.debugCrowdIds = debugCrowdIds;
    return this;
  }

   /**
   * 灰度测试用户人群列表
   * @return debugCrowdIds
  **/
  public String getDebugCrowdIds() {
    return debugCrowdIds;
  }

  public void setDebugCrowdIds(String debugCrowdIds) {
    this.debugCrowdIds = debugCrowdIds;
  }

  public Domain filter(String filter) {
    this.filter = filter;
    return this;
  }

   /**
   * 过滤条件
   * @return filter
  **/
  public String getFilter() {
    return filter;
  }

  public void setFilter(String filter) {
    this.filter = filter;
  }

  public Domain buckets(String buckets) {
    this.buckets = buckets;
    return this;
  }

   /**
   * 桶号,从实验层分配而来
   * @return buckets
  **/
  public String getBuckets() {
    return buckets;
  }

  public void setBuckets(String buckets) {
    this.buckets = buckets;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Domain domain = (Domain) o;
    return Objects.equals(this.workspaceId, domain.workspaceId) &&
        Objects.equals(this.expDomainId, domain.expDomainId) &&
        Objects.equals(this.expProjectId, domain.expProjectId) &&
        Objects.equals(this.expLayerId, domain.expLayerId) &&
        Objects.equals(this.isDefaultDomain, domain.isDefaultDomain) &&
        Objects.equals(this.expDomainName, domain.expDomainName) &&
        Objects.equals(this.projectName, domain.projectName) &&
        Objects.equals(this.layerName, domain.layerName) &&
        Objects.equals(this.expDomainInfo, domain.expDomainInfo) &&
        Objects.equals(this.bucketType, domain.bucketType) &&
        Objects.equals(this.experimentFlow, domain.experimentFlow) &&
        Objects.equals(this.debugUsers, domain.debugUsers) &&
        Objects.equals(this.debugCrowdIds, domain.debugCrowdIds) &&
        Objects.equals(this.filter, domain.filter) &&
        Objects.equals(this.buckets, domain.buckets);
  }

  @Override
  public int hashCode() {
    return Objects.hash(workspaceId, expDomainId, expProjectId, expLayerId, isDefaultDomain, expDomainName, projectName, layerName, expDomainInfo, bucketType, experimentFlow, debugUsers, debugCrowdIds, filter, buckets );
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Domain {\n");
    
    sb.append("    workspaceId: ").append(toIndentedString(workspaceId)).append("\n");
    sb.append("    expDomainId: ").append(toIndentedString(expDomainId)).append("\n");
    sb.append("    expProjectId: ").append(toIndentedString(expProjectId)).append("\n");
    sb.append("    expLayerId: ").append(toIndentedString(expLayerId)).append("\n");
    sb.append("    isDefaultDomain: ").append(toIndentedString(isDefaultDomain)).append("\n");
    sb.append("    expDomainName: ").append(toIndentedString(expDomainName)).append("\n");
    sb.append("    projectName: ").append(toIndentedString(projectName)).append("\n");
    sb.append("    layerName: ").append(toIndentedString(layerName)).append("\n");
    sb.append("    expDomainInfo: ").append(toIndentedString(expDomainInfo)).append("\n");
    sb.append("    bucketType: ").append(toIndentedString(bucketType)).append("\n");
    sb.append("    experimentFlow: ").append(toIndentedString(experimentFlow)).append("\n");
    sb.append("    debugUsers: ").append(toIndentedString(debugUsers)).append("\n");
    sb.append("    debugCrowdIds: ").append(toIndentedString(debugCrowdIds)).append("\n");
    sb.append("    filter: ").append(toIndentedString(filter)).append("\n");
    sb.append("    buckets: ").append(toIndentedString(buckets)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  public List<Feature> getFeatures() {
    return features;
  }

  public void init() {
    if (!StringUtils.isEmpty(this.debugUsers)) {
      String[] users = this.debugUsers.split(",");
      for (String user : users) {
        this.debugUserMap.add(user);
      }
    }

    if (this.diversionBucket == null) {
      if (this.bucketType == Constants.DomainBucketTypeCond) {
        this.diversionBucket = new FilterDiversionBucket(this.filter);
      } else if (this.bucketType == Constants.DomainBucketTypeRand) {
        this.diversionBucket = new UidDiversionBucket(100, this.buckets);
      }
    }
  }

  public void addDebugUsers(List<String> crowdUsers) {
    this.debugUserMap.addAll(crowdUsers);
  }

  public void addFeature(Feature feature) {
    this.features.add(feature);
  }

  public List<Layer> getLayers() {
    return layers;
  }

  public void addLayer(Layer layer) {
    this.layers.add(layer);
  }

  public boolean matchDebugUsers(ExperimentContext experimentContext) {
    return this.debugUserMap.contains(experimentContext.getUid());
  }

  public boolean match(ExperimentContext experimentContext) {
    if (null != this.experimentFlow) {
      if (this.experimentFlow == 0) {
        return false;
      } else if (this.experimentFlow == 100) {
        return true;
      }
    }

    if (null != this.diversionBucket) {
      return this.diversionBucket.match(experimentContext);
    }
    return false;
  }

}
