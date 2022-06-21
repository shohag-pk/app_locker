package com.suffixit.applocker.controller;

import com.suffixit.applocker.domain.AppConfiguration;
import com.suffixit.applocker.service.AppConfigurationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/appConfigurationController")
public class AppConfigurationController {
    private final AppConfigurationService appConfigurationService;

    public AppConfigurationController(AppConfigurationService appConfigurationService) {
        this.appConfigurationService = appConfigurationService;
    }

    @PostMapping("/createConfigurationForApp")
    public ResponseEntity<Boolean> createConfigurationForApp(@RequestHeader(name = "androidId") String androidId){
        return ResponseEntity.ok(appConfigurationService.createAppConfiguration(androidId));
    }

    @GetMapping("/getAppConfigInformation")
    public ResponseEntity<AppConfiguration> getAppConfigInformation(@RequestParam String androidId){
        return ResponseEntity.ok(appConfigurationService.getAppConfigurationDetails(androidId));
    }
}
