package com.example.controller;

import com.example.model.DoDProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/testConfigProps")
public class TestConfigurationPropertiesController {
    private final DoDProperties doDProperties;

    public TestConfigurationPropertiesController(DoDProperties doDProperties) {
        this.doDProperties = doDProperties;
    }

    @GetMapping("/testing")
    public void testConfig() {
        List<String> listRestrictedGroups = doDProperties.getRestrictedgroups();
        System.out.println("listRestrictedGroups=" + listRestrictedGroups);
        for (String str : listRestrictedGroups) {
            if (str.contains("ABCD")) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
