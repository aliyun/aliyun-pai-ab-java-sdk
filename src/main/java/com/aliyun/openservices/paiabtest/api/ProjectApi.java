package com.aliyun.openservices.paiabtest.api;


import com.aliyun.openservices.paiabtest.model.Project;
import com.aliyun.paiabtest20240119.models.ListProjectsRequest;
import com.aliyun.paiabtest20240119.models.ListProjectsResponse;
import com.aliyun.paiabtest20240119.models.ListProjectsResponseBody;

import java.util.ArrayList;
import java.util.List;

public class ProjectApi extends BaseApi{
    public ProjectApi(ApiClient apiClient) {
        super(apiClient);
    }

    public List<Project> listAllProjects() throws Exception {
        List<Project> projectList = new ArrayList<>();
        ListProjectsRequest listProjectsRequest = new ListProjectsRequest();
        listProjectsRequest.setAll(true);

        ListProjectsResponse listProjectsResponse =  this.apiClient.getClient().listProjects(listProjectsRequest);
        for (ListProjectsResponseBody.ListProjectsResponseBodyProjects item : listProjectsResponse.getBody().getProjects()) {
            Project project = new Project();
            project.setExpProjectId(Integer.valueOf(item.getProjectId()));
            project.setWorkspaceId(item.getWorkspaceId());
            project.setProjectInfo(item.getDescription());
            project.setProjectName(item.getName());
            projectList.add(project);
        }
        return projectList;
    }
}
