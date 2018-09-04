package com.rr.sonar.client.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SonarIssues implements Serializable{

    @JsonSetter("list")
    public void setIssues(List<SonarIssueEntry> issues) {
        this.issues = issues;
    }

    private List<SonarIssueEntry> issues = new ArrayList<>();

    @JsonProperty("issues")
    public List<SonarIssueEntry> getIssues() {
        return issues;
    }

    private int total;
    private double effortTotal;
    private double debtTotal;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public double getEffortTotal() {
        return effortTotal;
    }

    public void setEffortTotal(double effortTotal) {
        this.effortTotal = effortTotal;
    }

    public double getDebtTotal() {
        return debtTotal;
    }

    public void setDebtTotal(double debtTotal) {
        this.debtTotal = debtTotal;
    }
}
