
package com.aliyun.openservices.paiabtest.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
/**
 * Crowd
 */

public class Crowd {
  @SerializedName("workspace_id")
  private String workspaceId = null;

  @SerializedName("crowd_id")
  private Integer crowdId = null;

  @SerializedName("crowd_name")
  private String crowdName = null;

  @SerializedName("crowd_info")
  private String crowdInfo = null;

  @SerializedName("quantity")
  private Integer quantity = null;

  @SerializedName("label")
  private String label = null;

  @SerializedName("users")
  private String users = null;

  public Crowd workspaceId(String workspaceId) {
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

  public Crowd crowdId(Integer crowdId) {
    this.crowdId = crowdId;
    return this;
  }

   /**
   * 人群id
   * @return crowdId
  **/
  public Integer getCrowdId() {
    return crowdId;
  }

  public void setCrowdId(Integer crowdId) {
    this.crowdId = crowdId;
  }

  public Crowd crowdName(String crowdName) {
    this.crowdName = crowdName;
    return this;
  }

   /**
   * 人群名称
   * @return crowdName
  **/
  public String getCrowdName() {
    return crowdName;
  }

  public void setCrowdName(String crowdName) {
    this.crowdName = crowdName;
  }

  public Crowd crowdInfo(String crowdInfo) {
    this.crowdInfo = crowdInfo;
    return this;
  }

   /**
   * 人群描述
   * @return crowdInfo
  **/
  public String getCrowdInfo() {
    return crowdInfo;
  }

  public void setCrowdInfo(String crowdInfo) {
    this.crowdInfo = crowdInfo;
  }

  public Crowd quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

   /**
   * 人员数量
   * @return quantity
  **/
  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Crowd label(String label) {
    this.label = label;
    return this;
  }

   /**
   * 标签
   * @return label
  **/
  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public Crowd users(String users) {
    this.users = users;
    return this;
  }

   /**
   * 用户id列表
   * @return users
  **/
  public String getUsers() {
    return users;
  }

  public void setUsers(String users) {
    this.users = users;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Crowd crowd = (Crowd) o;
    return Objects.equals(this.workspaceId, crowd.workspaceId) &&
        Objects.equals(this.crowdId, crowd.crowdId) &&
        Objects.equals(this.crowdName, crowd.crowdName) &&
        Objects.equals(this.crowdInfo, crowd.crowdInfo) &&
        Objects.equals(this.quantity, crowd.quantity) &&
        Objects.equals(this.label, crowd.label) &&
        Objects.equals(this.users, crowd.users);
  }

  @Override
  public int hashCode() {
    return Objects.hash(workspaceId, crowdId, crowdName, crowdInfo, quantity, label, users );
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Crowd {\n");
    
    sb.append("    workspaceId: ").append(toIndentedString(workspaceId)).append("\n");
    sb.append("    crowdId: ").append(toIndentedString(crowdId)).append("\n");
    sb.append("    crowdName: ").append(toIndentedString(crowdName)).append("\n");
    sb.append("    crowdInfo: ").append(toIndentedString(crowdInfo)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    users: ").append(toIndentedString(users)).append("\n");
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

}
