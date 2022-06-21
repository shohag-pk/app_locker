package com.suffixit.applocker.service.implementation;

import com.suffixit.applocker.domain.ApkVersion;
import com.suffixit.applocker.exception.ResourceNotFoundException;
import com.suffixit.applocker.model.ApkUpdateModel;
import com.suffixit.applocker.repository.ApkVersionRepository;
import com.suffixit.applocker.service.ApkUpdateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApkUpdateServiceImpl implements ApkUpdateService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApkUpdateService.class);

    @Autowired
    private ApkVersionRepository apkVersionRepository;

    @Override
    public ApkUpdateModel getUpdate() {
        List<ApkVersion> apkVersions = getAll();
        ApkVersion apkVersion = null;
        if (apkVersions.size() > 0) {
            apkVersion = apkVersions.get(0);
            return new ApkUpdateModel(apkVersion.getVersion(),
                    String.valueOf(apkVersion.getId()),
                    apkVersion.getUrl(),
                    null);
        } else {
            throw new ResourceNotFoundException("No update is found.");
        }


    }

    @Override
    public List<ApkVersion> getAll() {
        return apkVersionRepository.findAll(Sort.by(Sort.Direction.DESC, "addDate"));
    }


}