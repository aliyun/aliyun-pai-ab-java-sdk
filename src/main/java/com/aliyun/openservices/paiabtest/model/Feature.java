package com.aliyun.openservices.paiabtest.model;

import com.aliyun.tea.utils.StringUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Feature
 */


public class Feature {
  @SerializedName("workspace_id")
  private String workspaceId = null;

  @SerializedName("feature_id")
  private Integer featureId = null;

  @SerializedName("exp_project_id")
  private Integer expProjectId = null;

  @SerializedName("exp_domain_id")
  private Integer expDomainId = null;

  @SerializedName("exp_id")
  private Integer expId = null;

  @SerializedName("exp_version_id")
  private Integer expVersionId = null;

  @SerializedName("feature_name")
  private String featureName = null;

  @SerializedName("project_name")
  private String projectName = null;

  @SerializedName("exp_domain_name")
  private String expDomainName = null;

  @SerializedName("exp_owner")
  private String expOwner = null;

  @SerializedName("filter")
  private String filter = null;

  @SerializedName("config")
  private String config = null;

  @SerializedName("status")
  private Integer status = null;

  private DiversionBucket diversionBucket = null;

  private Map<String, Object> params = new HashMap<>();


  public Feature workspaceId(String workspaceId) {
    this.workspaceId = workspaceId;
    return this;
  }

  public Map<String, Object> getParams() {
    return params;
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

  public Feature featureId(Integer featureId) {
    this.featureId = featureId;
    return this;
  }

   /**
   * 功能 id
   * @return featureId
  **/
  public Integer getFeatureId() {
    return featureId;
  }

  public void setFeatureId(Integer featureId) {
    this.featureId = featureId;
  }

  public Feature expProjectId(Integer expProjectId) {
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

  public Feature expDomainId(Integer expDomainId) {
    this.expDomainId = expDomainId;
    return this;
  }

   /**
   * 所在的生效域 ID
   * @return expDomainId
  **/
  public Integer getExpDomainId() {
    return expDomainId;
  }

  public void setExpDomainId(Integer expDomainId) {
    this.expDomainId = expDomainId;
  }

  public Feature expId(Integer expId) {
    this.expId = expId;
    return this;
  }

   /**
   * 来源实验 id
   * @return expId
  **/
  public Integer getExpId() {
    return expId;
  }

  public void setExpId(Integer expId) {
    this.expId = expId;
  }

  public Feature expVersionId(Integer expVersionId) {
    this.expVersionId = expVersionId;
    return this;
  }

   /**
   * 来源版本 id
   * @return expVersionId
  **/
  public Integer getExpVersionId() {
    return expVersionId;
  }

  public void setExpVersionId(Integer expVersionId) {
    this.expVersionId = expVersionId;
  }

  public Feature featureName(String featureName) {
    this.featureName = featureName;
    return this;
  }

   /**
   * 功能名称
   * @return featureName
  **/
  public String getFeatureName() {
    return featureName;
  }

  public void setFeatureName(String featureName) {
    this.featureName = featureName;
  }

  public Feature projectName(String projectName) {
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

  public Feature expDomainName(String expDomainName) {
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

  public Feature expOwner(String expOwner) {
    this.expOwner = expOwner;
    return this;
  }

   /**
   * 相关实验负责人
   * @return expOwner
  **/
  public String getExpOwner() {
    return expOwner;
  }

  public void setExpOwner(String expOwner) {
    this.expOwner = expOwner;
  }

  public Feature filter(String filter) {
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

  public Feature config(String config) {
    this.config = config;
    return this;
  }

   /**
   * 实验配置参数 json array 格式
   * @return config
  **/
  public String getConfig() {
    return config;
  }

  public void setConfig(String config) {
    this.config = config;
  }

  public Feature status(Integer status) {
    this.status = status;
    return this;
  }

   /**
   * 状态 1: 未发布，2：已发布
   * @return status
  **/
  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Feature feature = (Feature) o;
    return Objects.equals(this.workspaceId, feature.workspaceId) &&
        Objects.equals(this.featureId, feature.featureId) &&
        Objects.equals(this.expProjectId, feature.expProjectId) &&
        Objects.equals(this.expDomainId, feature.expDomainId) &&
        Objects.equals(this.expId, feature.expId) &&
        Objects.equals(this.expVersionId, feature.expVersionId) &&
        Objects.equals(this.featureName, feature.featureName) &&
        Objects.equals(this.projectName, feature.projectName) &&
        Objects.equals(this.expDomainName, feature.expDomainName) &&
        Objects.equals(this.expOwner, feature.expOwner) &&
        Objects.equals(this.filter, feature.filter) &&
        Objects.equals(this.config, feature.config) &&
        Objects.equals(this.status, feature.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(workspaceId, featureId, expProjectId, expDomainId, expId, expVersionId, featureName, projectName, expDomainName, expOwner, filter, config, status );
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Feature {\n");
    
    sb.append("    workspaceId: ").append(toIndentedString(workspaceId)).append("\n");
    sb.append("    featureId: ").append(toIndentedString(featureId)).append("\n");
    sb.append("    expProjectId: ").append(toIndentedString(expProjectId)).append("\n");
    sb.append("    expDomainId: ").append(toIndentedString(expDomainId)).append("\n");
    sb.append("    expId: ").append(toIndentedString(expId)).append("\n");
    sb.append("    expVersionId: ").append(toIndentedString(expVersionId)).append("\n");
    sb.append("    featureName: ").append(toIndentedString(featureName)).append("\n");
    sb.append("    projectName: ").append(toIndentedString(projectName)).append("\n");
    sb.append("    expDomainName: ").append(toIndentedString(expDomainName)).append("\n");
    sb.append("    expOwner: ").append(toIndentedString(expOwner)).append("\n");
    sb.append("    filter: ").append(toIndentedString(filter)).append("\n");
    sb.append("    config: ").append(toIndentedString(config)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

    public void init() {
      Type listType = new TypeToken<List<ExpParameter>>(){}.getType();
      Gson gson =new Gson();
      List<ExpParameter>  expParameters = gson.fromJson(this.config, listType);

      for (ExpParameter parameter : expParameters) {
        this.params.put(parameter.getKey(), parameter.getValue());
      }

      if (!StringUtils.isEmpty(this.filter)) {
        this.diversionBucket =  new FilterDiversionBucket(this.filter);
      }
    }

  // Match
  public boolean match(ExperimentContext experimentContext ) {
    if (this.diversionBucket == null) {
      return true;
    }
    return this.diversionBucket.match(experimentContext);
  }
}
