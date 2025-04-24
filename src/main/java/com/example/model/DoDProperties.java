package com.example.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix="com.esrx.posservices")
public class DoDProperties {
    private List<String> restrictedgroups;

    public List<String> getRestrictedgroups() {
        return restrictedgroups;
    }

    public void setRestrictedgroups(List<String> restrictedgroups) {
        this.restrictedgroups = restrictedgroups;
    }
}
