package com.suffixit.applocker.controller;

import com.suffixit.applocker.model.ApkUpdateModel;
import com.suffixit.applocker.service.ApkUpdateService;
import com.suffixit.applocker.service.implementation.ApkUpdateServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/apkUpdateManagement")
public class ApkUpdateController {

    private final ApkUpdateService apkUpdateService;

    public ApkUpdateController(ApkUpdateServiceImpl apkUpdateService) {
        this.apkUpdateService = apkUpdateService;
    }

    @GetMapping("/apk-update")
    public ResponseEntity<ApkUpdateModel> updateApk() {
        return ResponseEntity.ok(apkUpdateService.getUpdate());
    }
}
