package com.suffixit.applocker.service;

import com.suffixit.applocker.domain.ApkVersion;
import com.suffixit.applocker.model.ApkUpdateModel;

import java.util.List;

public interface ApkUpdateService {

    ApkUpdateModel getUpdate();

    List<ApkVersion> getAll();

}
