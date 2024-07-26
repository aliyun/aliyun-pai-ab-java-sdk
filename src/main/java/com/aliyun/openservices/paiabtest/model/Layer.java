package com.aliyun.openservices.paiabtest.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Layer
 */


public class Layer {
  @SerializedName("workspace_id")
  private String workspaceId = null;

  @SerializedName("exp_layer_id")
  private Integer expLayerId = null;

  @SerializedName("exp_domain_id")
  private Integer expDomainId = null;

  @SerializedName("exp_project_id")
  private Integer expProjectId = null;

  @SerializedName("is_default_layer")
  private Boolean isDefaultLayer = null;

  @SerializedName("layer_name")
  private String layerName = null;

  @SerializedName("project_name")
  private String projectName = null;

  @SerializedName("exp_domain_name")
  private String expDomainName = null;

  @SerializedName("layer_info")
  private String layerInfo = null;

  private List<Experiment> experiments = new ArrayList<>();

  private List<Domain> domains = new ArrayList<>();

  public Layer workspaceId(String workspaceId) {
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

  public Layer expLayerId(Integer expLayerId) {
    this.expLayerId = expLayerId;
    return this;
  }

   /**
   * 实验层id
   * @return expLayerId
  **/
  public Integer getExpLayerId() {
    return expLayerId;
  }

  public void setExpLayerId(Integer expLayerId) {
    this.expLayerId = expLayerId;
  }

  public Layer expDomainId(Integer expDomainId) {
    this.expDomainId = expDomainId;
    return this;
  }

   /**
   * 所属实验域id
   * @return expDomainId
  **/
  public Integer getExpDomainId() {
    return expDomainId;
  }

  public void setExpDomainId(Integer expDomainId) {
    this.expDomainId = expDomainId;
  }

  public Layer expProjectId(Integer expProjectId) {
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

  public Layer isDefaultLayer(Boolean isDefaultLayer) {
    this.isDefaultLayer = isDefaultLayer;
    return this;
  }

   /**
   * 是否是默认层
   * @return isDefaultLayer
  **/
  public Boolean isIsDefaultLayer() {
    return isDefaultLayer;
  }

  public void setIsDefaultLayer(Boolean isDefaultLayer) {
    this.isDefaultLayer = isDefaultLayer;
  }

  public Layer layerName(String layerName) {
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

  public Layer projectName(String projectName) {
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

  public Layer expDomainName(String expDomainName) {
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

  public Layer layerInfo(String layerInfo) {
    this.layerInfo = layerInfo;
    return this;
  }

   /**
   * 层说明
   * @return layerInfo
  **/
  public String getLayerInfo() {
    return layerInfo;
  }

  public void setLayerInfo(String layerInfo) {
    this.layerInfo = layerInfo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Layer layer = (Layer) o;
    return Objects.equals(this.workspaceId, layer.workspaceId) &&
        Objects.equals(this.expLayerId, layer.expLayerId) &&
        Objects.equals(this.expDomainId, layer.expDomainId) &&
        Objects.equals(this.expProjectId, layer.expProjectId) &&
        Objects.equals(this.isDefaultLayer, layer.isDefaultLayer) &&
        Objects.equals(this.layerName, layer.layerName) &&
        Objects.equals(this.projectName, layer.projectName) &&
        Objects.equals(this.expDomainName, layer.expDomainName) &&
        Objects.equals(this.layerInfo, layer.layerInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(workspaceId, expLayerId, expDomainId, expProjectId, isDefaultLayer, layerName, projectName, expDomainName, layerInfo );
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Layer {\n");
    
    sb.append("    workspaceId: ").append(toIndentedString(workspaceId)).append("\n");
    sb.append("    expLayerId: ").append(toIndentedString(expLayerId)).append("\n");
    sb.append("    expDomainId: ").append(toIndentedString(expDomainId)).append("\n");
    sb.append("    expProjectId: ").append(toIndentedString(expProjectId)).append("\n");
    sb.append("    isDefaultLayer: ").append(toIndentedString(isDefaultLayer)).append("\n");
    sb.append("    layerName: ").append(toIndentedString(layerName)).append("\n");
    sb.append("    projectName: ").append(toIndentedString(projectName)).append("\n");
    sb.append("    expDomainName: ").append(toIndentedString(expDomainName)).append("\n");
    sb.append("    layerInfo: ").append(toIndentedString(layerInfo)).append("\n");
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

  public List<Experiment> getExperiments() {
    return experiments;
  }

  public void setExperiments(List<Experiment> experiments) {
    this.experiments = experiments;
  }

  public List<Domain> getDomains() {
    return domains;
  }

  public void setDomains(List<Domain> domains) {
    this.domains = domains;
  }

  public void addExperiment(Experiment experiment) {
    this.experiments.add(experiment);
  }

  public void addDomain(Domain domain) {
    this.domains.add(domain);
  }
}
