package com.aliyun.openservices.paiabtest.model;

import com.aliyun.openservices.paiabtest.common.Constants;
import com.aliyun.tea.utils.StringUtils;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
/**
 * Experiment
 */


public class Experiment {
  @SerializedName("workspace_id")
  private String workspaceId = null;

  @SerializedName("exp_id")
  private Integer expId = null;

  @SerializedName("exp_project_id")
  private Integer expProjectId = null;

  @SerializedName("exp_domain_id")
  private Integer expDomainId = null;

  @SerializedName("exp_layer_id")
  private Integer expLayerId = null;

  @SerializedName("exp_name")
  private String expName = null;

  @SerializedName("project_name")
  private String projectName = null;

  @SerializedName("exp_domain_name")
  private String expDomainName = null;

  @SerializedName("layer_name")
  private String layerName = null;

  @SerializedName("exp_info")
  private String expInfo = null;

  @SerializedName("owner")
  private String owner = null;

  @SerializedName("debug_users")
  private String debugUsers = null;

  @SerializedName("debug_crowd_ids")
  private String debugCrowdIds = null;

  @SerializedName("bucket_type")
  private Integer bucketType = null;

  @SerializedName("experiment_flow")
  private Integer experimentFlow = null;

  @SerializedName("buckets")
  private String buckets = null;

  @SerializedName("filter")
  private String filter = null;

  @SerializedName("start_time")
  private String startTime = null;

  @SerializedName("end_time")
  private String endTime = null;

  @SerializedName("status")
  private Integer status = null;

  private Set<String> debugUserMap = new HashSet<>();

  private DiversionBucket diversionBucket = null;

  private List<ExperimentVersion> experimentVersions = new ArrayList<>();

  public Experiment workspaceId(String workspaceId) {
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

  public Experiment expId(Integer expId) {
    this.expId = expId;
    return this;
  }

   /**
   * 实验id
   * @return expId
  **/
  public Integer getExpId() {
    return expId;
  }

  public void setExpId(Integer expId) {
    this.expId = expId;
  }

  public Experiment expProjectId(Integer expProjectId) {
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

  public Experiment expDomainId(Integer expDomainId) {
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

  public Experiment expLayerId(Integer expLayerId) {
    this.expLayerId = expLayerId;
    return this;
  }

   /**
   * 所在实验层id
   * @return expLayerId
  **/
  public Integer getExpLayerId() {
    return expLayerId;
  }

  public void setExpLayerId(Integer expLayerId) {
    this.expLayerId = expLayerId;
  }

  public Experiment expName(String expName) {
    this.expName = expName;
    return this;
  }

   /**
   * 实验名称
   * @return expName
  **/
  public String getExpName() {
    return expName;
  }

  public void setExpName(String expName) {
    this.expName = expName;
  }

  public Experiment projectName(String projectName) {
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

  public Experiment expDomainName(String expDomainName) {
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

  public Experiment layerName(String layerName) {
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

  public Experiment expInfo(String expInfo) {
    this.expInfo = expInfo;
    return this;
  }

   /**
   * 实验介绍
   * @return expInfo
  **/
  public String getExpInfo() {
    return expInfo;
  }

  public void setExpInfo(String expInfo) {
    this.expInfo = expInfo;
  }

  public Experiment owner(String owner) {
    this.owner = owner;
    return this;
  }

   /**
   * 实验负责人
   * @return owner
  **/
  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public Experiment debugUsers(String debugUsers) {
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

  public Experiment debugCrowdIds(String debugCrowdIds) {
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

  public Experiment bucketType(Integer bucketType) {
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

  public Experiment experimentFlow(Integer experimentFlow) {
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

  public Experiment buckets(String buckets) {
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

  public Experiment filter(String filter) {
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

  public Experiment startTime(String startTime) {
    this.startTime = startTime;
    return this;
  }

   /**
   * 启动时间
   * @return startTime
  **/
  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public Experiment endTime(String endTime) {
    this.endTime = endTime;
    return this;
  }

   /**
   * 结束时间
   * @return endTime
  **/
  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public Experiment status(Integer status) {
    this.status = status;
    return this;
  }

   /**
   * 状态 1: 未运行，2 ：运行中， 3： 已推全，4：待运行，5：已停止（已完成）
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
    Experiment experiment = (Experiment) o;
    return Objects.equals(this.workspaceId, experiment.workspaceId) &&
        Objects.equals(this.expId, experiment.expId) &&
        Objects.equals(this.expProjectId, experiment.expProjectId) &&
        Objects.equals(this.expDomainId, experiment.expDomainId) &&
        Objects.equals(this.expLayerId, experiment.expLayerId) &&
        Objects.equals(this.expName, experiment.expName) &&
        Objects.equals(this.projectName, experiment.projectName) &&
        Objects.equals(this.expDomainName, experiment.expDomainName) &&
        Objects.equals(this.layerName, experiment.layerName) &&
        Objects.equals(this.expInfo, experiment.expInfo) &&
        Objects.equals(this.owner, experiment.owner) &&
        Objects.equals(this.debugUsers, experiment.debugUsers) &&
        Objects.equals(this.debugCrowdIds, experiment.debugCrowdIds) &&
        Objects.equals(this.bucketType, experiment.bucketType) &&
        Objects.equals(this.experimentFlow, experiment.experimentFlow) &&
        Objects.equals(this.buckets, experiment.buckets) &&
        Objects.equals(this.filter, experiment.filter) &&
        Objects.equals(this.startTime, experiment.startTime) &&
        Objects.equals(this.endTime, experiment.endTime) &&
        Objects.equals(this.status, experiment.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(workspaceId, expId, expProjectId, expDomainId, expLayerId, expName, projectName, expDomainName, layerName, expInfo, owner, debugUsers, debugCrowdIds, bucketType, experimentFlow, buckets, filter, startTime, endTime, status);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Experiment {\n");
    
    sb.append("    workspaceId: ").append(toIndentedString(workspaceId)).append("\n");
    sb.append("    expId: ").append(toIndentedString(expId)).append("\n");
    sb.append("    expProjectId: ").append(toIndentedString(expProjectId)).append("\n");
    sb.append("    expDomainId: ").append(toIndentedString(expDomainId)).append("\n");
    sb.append("    expLayerId: ").append(toIndentedString(expLayerId)).append("\n");
    sb.append("    expName: ").append(toIndentedString(expName)).append("\n");
    sb.append("    projectName: ").append(toIndentedString(projectName)).append("\n");
    sb.append("    expDomainName: ").append(toIndentedString(expDomainName)).append("\n");
    sb.append("    layerName: ").append(toIndentedString(layerName)).append("\n");
    sb.append("    expInfo: ").append(toIndentedString(expInfo)).append("\n");
    sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
    sb.append("    debugUsers: ").append(toIndentedString(debugUsers)).append("\n");
    sb.append("    debugCrowdIds: ").append(toIndentedString(debugCrowdIds)).append("\n");
    sb.append("    bucketType: ").append(toIndentedString(bucketType)).append("\n");
    sb.append("    experimentFlow: ").append(toIndentedString(experimentFlow)).append("\n");
    sb.append("    buckets: ").append(toIndentedString(buckets)).append("\n");
    sb.append("    filter: ").append(toIndentedString(filter)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
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

    if (this.bucketType == Constants.ExpBucketTypeRand) {
      this.diversionBucket = new UidDiversionBucket(100, this.buckets);
    } else if ((this.bucketType == Constants.ExpBucketTypeCond) && !StringUtils.isEmpty(this.filter)) {
      this.diversionBucket = new FilterDiversionBucket(this.filter);
    }

  }

  public List<ExperimentVersion> getExperimentVersions() {
    return experimentVersions;
  }

  public void addExperimentVersion(ExperimentVersion experimentVersion) {
    this.experimentVersions.add(experimentVersion);
  }

  public boolean matchDebugUsers(ExperimentContext experimentContext) {
    return this.debugUserMap.contains(experimentContext.getUid());
  }


  public boolean match(ExperimentContext experimentContext) {
    if (this.bucketType == Constants.ExpBucketTypeRand) {
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
