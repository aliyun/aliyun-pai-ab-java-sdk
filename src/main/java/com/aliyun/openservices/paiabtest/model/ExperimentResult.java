package com.aliyun.openservices.paiabtest.model;


import java.util.ArrayList;
import java.util.List;

public class ExperimentResult {
    private String expId = "";

    private  String projectName;

    private Project project;

    private ExperimentContext experimentContext = null;

    private List<ExperimentVersion> experimentVersionList = new ArrayList<>();

    private ExperimentParams experimentParams = new DefaultExperimentParams();

    public ExperimentResult(ExperimentContext experimentContext) {
        this(null, experimentContext);
    }
    public ExperimentResult(Project project,  ExperimentContext experimentContext) {
        this.experimentContext = experimentContext;
        if (null != project) {
            this.project = project;
            this.projectName = this.project.getProjectName();
        }
    }

    public ExperimentContext getExperimentContext() {
        return experimentContext;
    }

    public void addExperimentVersion(ExperimentVersion experimentVersion) {
        this.experimentVersionList.add(experimentVersion);
    }

    public String getExpId() {
        return expId;
    }

    public void init() {
        StringBuilder buf = new StringBuilder();
        if (null != this.project) {
            buf.append("ER").append(this.project.getExpProjectId());
        }

        if (this.experimentVersionList.size() > 0) {
            for (ExperimentVersion experimentVersion : this.experimentVersionList) {
                buf.append("_E").append(experimentVersion.getExperiment().getExpId());
                buf.append("#EV").append(experimentVersion.getExpVersionId());
            }

            this.expId = buf.toString();

            /**
            for (ExperimentVersion experimentVersion : this.experimentVersionList) {
                this.experimentParams.addParams(experimentVersion.getParams());
            }
             **/
        }

    }


    public String info() {
        StringBuilder buf = new StringBuilder();

        if (null != this.experimentContext) {
            buf.append(",requestId=").append(this.experimentContext.getRequestId());
            buf.append(",uid=").append(this.experimentContext.getUid());
        }

        buf.append(",project_name=").append(this.projectName);
        buf.append(",exp_id=").append(this.expId);

        buf.deleteCharAt(0);

        return buf.toString();
    }

    public ExperimentParams getExperimentParams() {
        return  this.experimentParams;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
