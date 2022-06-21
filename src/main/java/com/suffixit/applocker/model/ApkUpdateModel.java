package com.suffixit.applocker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApkUpdateModel {
    private String latestVersion;
    private String latestVersionCode;
    private String url;
    private List<String> releaseNotes;


}
