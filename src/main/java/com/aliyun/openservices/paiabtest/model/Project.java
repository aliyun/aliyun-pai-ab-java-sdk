package com.aliyun.openservices.paiabtest.model;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Project
 */


public class Project {
  @SerializedName("workspace_id")
  private String workspaceId = null;

  @SerializedName("exp_project_id")
  private Integer expProjectId = null;

  @SerializedName("project_name")
  private String projectName = null;

  @SerializedName("project_info")
  private String projectInfo = null;

  private Domain defaultDomain = null;

  private Map<Integer, Domain> domainMap = new HashMap<>();

  private Map<Integer, Layer> layerMap = new HashMap<>();

  public Domain getDefaultDomain() {
    return defaultDomain;
  }

  public void setDefaultDomain(Domain defaultDomain) {
    this.defaultDomain = defaultDomain;
  }

  public Project workspaceId(String workspaceId) {
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

  public Project expProjectId(Integer expProjectId) {
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

  public Project projectName(String projectName) {
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

  public Project projectInfo(String projectInfo) {
    this.projectInfo = projectInfo;
    return this;
  }

   /**
   * 项目介绍
   * @return projectInfo
  **/
  public String getProjectInfo() {
    return projectInfo;
  }

  public void setProjectInfo(String projectInfo) {
    this.projectInfo = projectInfo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Project project = (Project) o;
    return Objects.equals(this.workspaceId, project.workspaceId) &&
        Objects.equals(this.expProjectId, project.expProjectId) &&
        Objects.equals(this.projectName, project.projectName) &&
        Objects.equals(this.projectInfo, project.projectInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(workspaceId, expProjectId, projectName, projectInfo );
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Project {\n");
    
    sb.append("    workspaceId: ").append(toIndentedString(workspaceId)).append("\n");
    sb.append("    expProjectId: ").append(toIndentedString(expProjectId)).append("\n");
    sb.append("    projectName: ").append(toIndentedString(projectName)).append("\n");
    sb.append("    projectInfo: ").append(toIndentedString(projectInfo)).append("\n");
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

  public void addDomain(Domain domain) {
    this.domainMap.put(domain.getExpDomainId(), domain);
  }

  public void addLayer(Layer layer) {
    this.layerMap.put(layer.getExpLayerId(), layer);
  }

  public Map<Integer, Domain> getDomainMap() {
    return domainMap;
  }

  public Map<Integer, Layer> getLayerMap() {
    return layerMap;
  }
}
