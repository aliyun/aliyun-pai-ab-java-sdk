package com.aliyun.openservices.paiabtest.model;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import com.aliyun.tea.utils.StringUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
/**
 * ExperimentVersion
 */

public class ExperimentVersion {
  @SerializedName("exp_version_id")
  private Integer expVersionId = null;

  @SerializedName("exp_project_id")
  private Integer expProjectId = null;

  @SerializedName("exp_id")
  private Integer expId = null;

  @SerializedName("exp_version_name")
  private String expVersionName = null;

  @SerializedName("project_name")
  private String projectName = null;

  @SerializedName("exp_version_info")
  private String expVersionInfo = null;

  @SerializedName("exp_version_type")
  private Integer expVersionType = null;

  @SerializedName("experiment_flow")
  private Integer experimentFlow = 0;

  @SerializedName("buckets")
  private String buckets = null;

  @SerializedName("debug_users")
  private String debugUsers = null;

  @SerializedName("debug_crowd_ids")
  private String debugCrowdIds = null;

  @SerializedName("exp_version_config")
  private String expVersionConfig = null;

  private Set<String> debugUserMap = new HashSet<>();

  private DiversionBucket diversionBucket = null;

  private Map<String, Object> params = new HashMap<>();

  private Experiment experiment;

  public ExperimentVersion expVersionId(Integer expVersionId) {
    this.expVersionId = expVersionId;
    return this;
  }

   /**
   * 实验版本id
   * @return expVersionId
  **/
  public Integer getExpVersionId() {
    return expVersionId;
  }

  public void setExpVersionId(Integer expVersionId) {
    this.expVersionId = expVersionId;
  }

  public ExperimentVersion expProjectId(Integer expProjectId) {
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

  public ExperimentVersion expId(Integer expId) {
    this.expId = expId;
    return this;
  }

   /**
   * 所属实验id
   * @return expId
  **/
  public Integer getExpId() {
    return expId;
  }

  public void setExpId(Integer expId) {
    this.expId = expId;
  }

  public ExperimentVersion expVersionName(String expVersionName) {
    this.expVersionName = expVersionName;
    return this;
  }

   /**
   * 实验版本名称
   * @return expVersionName
  **/
  public String getExpVersionName() {
    return expVersionName;
  }

  public void setExpVersionName(String expVersionName) {
    this.expVersionName = expVersionName;
  }

  public ExperimentVersion projectName(String projectName) {
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

  public ExperimentVersion expVersionInfo(String expVersionInfo) {
    this.expVersionInfo = expVersionInfo;
    return this;
  }

   /**
   * 实验版本介绍
   * @return expVersionInfo
  **/
  public String getExpVersionInfo() {
    return expVersionInfo;
  }

  public void setExpVersionInfo(String expVersionInfo) {
    this.expVersionInfo = expVersionInfo;
  }

  public ExperimentVersion expVersionType(Integer expVersionType) {
    this.expVersionType = expVersionType;
    return this;
  }

   /**
   * 实验类型：1 对照组 2 实验组
   * @return expVersionType
  **/
  public Integer getExpVersionType() {
    return expVersionType;
  }

  public void setExpVersionType(Integer expVersionType) {
    this.expVersionType = expVersionType;
  }

  public ExperimentVersion experimentFlow(Integer experimentFlow) {
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

  public ExperimentVersion buckets(String buckets) {
    this.buckets = buckets;
    return this;
  }

   /**
   * 桶号,从实验分配而来
   * @return buckets
  **/
  public String getBuckets() {
    return buckets;
  }

  public void setBuckets(String buckets) {
    this.buckets = buckets;
  }

  public ExperimentVersion debugUsers(String debugUsers) {
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

  public ExperimentVersion debugCrowdIds(String debugCrowdIds) {
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

  public ExperimentVersion expVersionConfig(String expVersionConfig) {
    this.expVersionConfig = expVersionConfig;
    return this;
  }

   /**
   * 实验配置参数 json array 格式
   * @return expVersionConfig
  **/
  public String getExpVersionConfig() {
    return expVersionConfig;
  }

  public void setExpVersionConfig(String expVersionConfig) {
    this.expVersionConfig = expVersionConfig;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExperimentVersion experimentVersion = (ExperimentVersion) o;
    return Objects.equals(this.expVersionId, experimentVersion.expVersionId) &&
        Objects.equals(this.expProjectId, experimentVersion.expProjectId) &&
        Objects.equals(this.expId, experimentVersion.expId) &&
        Objects.equals(this.expVersionName, experimentVersion.expVersionName) &&
        Objects.equals(this.projectName, experimentVersion.projectName) &&
        Objects.equals(this.expVersionInfo, experimentVersion.expVersionInfo) &&
        Objects.equals(this.expVersionType, experimentVersion.expVersionType) &&
        Objects.equals(this.experimentFlow, experimentVersion.experimentFlow) &&
        Objects.equals(this.buckets, experimentVersion.buckets) &&
        Objects.equals(this.debugUsers, experimentVersion.debugUsers) &&
        Objects.equals(this.debugCrowdIds, experimentVersion.debugCrowdIds) &&
        Objects.equals(this.expVersionConfig, experimentVersion.expVersionConfig);
  }

  @Override
  public int hashCode() {
    return Objects.hash(expVersionId, expProjectId, expId, expVersionName, projectName, expVersionInfo, expVersionType, experimentFlow, buckets, debugUsers, debugCrowdIds, expVersionConfig );
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExperimentVersion {\n");
    
    sb.append("    expVersionId: ").append(toIndentedString(expVersionId)).append("\n");
    sb.append("    expProjectId: ").append(toIndentedString(expProjectId)).append("\n");
    sb.append("    expId: ").append(toIndentedString(expId)).append("\n");
    sb.append("    expVersionName: ").append(toIndentedString(expVersionName)).append("\n");
    sb.append("    projectName: ").append(toIndentedString(projectName)).append("\n");
    sb.append("    expVersionInfo: ").append(toIndentedString(expVersionInfo)).append("\n");
    sb.append("    expVersionType: ").append(toIndentedString(expVersionType)).append("\n");
    sb.append("    experimentFlow: ").append(toIndentedString(experimentFlow)).append("\n");
    sb.append("    buckets: ").append(toIndentedString(buckets)).append("\n");
    sb.append("    debugUsers: ").append(toIndentedString(debugUsers)).append("\n");
    sb.append("    debugCrowdIds: ").append(toIndentedString(debugCrowdIds)).append("\n");
    sb.append("    expVersionConfig: ").append(toIndentedString(expVersionConfig)).append("\n");
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

  public Experiment getExperiment() {
    return experiment;
  }

  public void setExperiment(Experiment experiment) {
    this.experiment = experiment;
  }

  public Map<String, Object> getParams() {
    return params;
  }

  public void addDebugUsers(List<String> crowdUsers) {
    this.debugUserMap.addAll(crowdUsers);
  }

  public void init() {
    if (!StringUtils.isEmpty(this.debugUsers)) {
      String[] users = this.debugUsers.split(",");
      for (String user : users) {
        this.debugUserMap.add(user);
      }
    }
    this.diversionBucket = new UidDiversionBucket(100, this.buckets);

    Type listType = new TypeToken<List<ExpParameter>>(){}.getType();
    Gson gson =new Gson();
    List<ExpParameter>  expParameters = gson.fromJson(this.expVersionConfig, listType);

    for (ExpParameter parameter : expParameters) {
      this.params.put(parameter.getKey(), parameter.getValue());
    }
  }

  public boolean matchDebugUsers(ExperimentContext experimentContext) {
    return this.debugUserMap.contains(experimentContext.getUid());
  }

  public boolean match(ExperimentContext experimentContext) {
    if (this.experimentFlow == 0) {
      return false;
    } else if (this.experimentFlow == 100) {
      return true;
    }

    return this.diversionBucket.match(experimentContext);
  }
}
