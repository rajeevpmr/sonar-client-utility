package com.rr.sonar.client;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("app.sonar.client")
public class AppProperties {

    public Credentials getCredentials() {
        return this.credentials;
    }

    private final Credentials credentials = new Credentials();

    private String sonarUrl;

    public String getSonarUrl() {
        return sonarUrl;
    }

    public void setSonarUrl(String sonarUrl) {
        this.sonarUrl = sonarUrl;
    }

    public static class Credentials {

        private String userName;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        private String password;


    }
}
