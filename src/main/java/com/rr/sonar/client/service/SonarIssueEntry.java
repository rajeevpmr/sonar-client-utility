package com.rr.sonar.client.service;

public class SonarIssueEntry {

    private String severity;
    private String component;
    private String status;
    private String effort;
    private String debt;

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEffort() {
        return effort;
    }

    public void setEffort(String effort) {
        this.effort = effort;
    }

    public String getDebt() {
        return debt;
    }

    public void setDebt(String debt) {
        this.debt = debt;
    }
}
