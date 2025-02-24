package com.example.products.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.GitProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AppInfoController {

    @Autowired
    private GitProperties gitProperties;

    @GetMapping("/app-info")
    public Map<String, String> getAppInfo() {
        Map<String, String> appInfo = new HashMap<>();

        appInfo.put("Git Commit ID", gitProperties.getCommitId());
        appInfo.put("Git Branch", gitProperties.getBranch());
        appInfo.put("Git Tags", gitProperties.get("tags")); 

        appInfo.put("Build Version", gitProperties.get("build.version"));
        appInfo.put("Build Time", gitProperties.get("build.time"));

        return appInfo;
    }
}