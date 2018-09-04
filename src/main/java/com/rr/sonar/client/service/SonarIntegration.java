package com.rr.sonar.client.service;

import com.rr.sonar.client.AppProperties;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@Service
public class SonarIntegration {

    private static final Logger logger = LoggerFactory.getLogger(SonarIntegration.class);

    private final RestTemplate restTemplate;

    private final String conUrl;
    private final String userName;
    private final String passowrd;

    public SonarIntegration(RestTemplateBuilder builder, AppProperties props) {
        this.restTemplate = builder.build();
        this.conUrl = props.getSonarUrl();
        this.userName = props.getCredentials().getUserName();
        this.passowrd = props.getCredentials().getPassword();
    }

    public SonarIssues getIssues(String projectKey){

        logger.info("Requesting issues for {}", projectKey);
        Map params = new HashMap<String, String>();
        params.put("componentRoots", projectKey);
        URI url = new UriTemplate(conUrl).expand(params);
        return invoke(url, SonarIssues.class);

    }

    private <T> T invoke(URI url, Class<T> responseType) {

        logger.info("Using url {}", url);

        RequestEntity<?> request = RequestEntity.get(url)
                .accept(MediaType.APPLICATION_JSON)
                .header("Authorisation", "Basic "+new String(createAuthHeader()))
                .build();

        ResponseEntity<T> exchange = this.restTemplate
                .exchange(request, responseType);
        return exchange.getBody();

    }

    private byte[] createAuthHeader() {
        String auth = this.userName + ":" + this.passowrd;
        byte[] encodedAuth = Base64.encodeBase64(
                auth.getBytes(Charset.forName("US-ASCII")));
        return encodedAuth;
    }

}
