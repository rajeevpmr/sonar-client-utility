package com.rr.sonar.client;

import com.rr.sonar.client.service.SonarIntegration;
import com.rr.sonar.client.service.SonarIssues;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sonar")
public class SonarClientController {


    private AppProperties props;
    private SonarIntegration service;

    public SonarClientController(AppProperties props, SonarIntegration integration) {
        this.props = props;
        this.service = integration;
    }

    @RequestMapping("/issues/{projectKey}")
    public SonarIssues getIssues(@PathVariable String projectKey) {

        return this.service.getIssues(projectKey);
    }

}
