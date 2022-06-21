package com.suffixit.applocker.service.implementation;

import com.suffixit.applocker.domain.AppConfiguration;
import com.suffixit.applocker.repository.AppConfigurationRepository;
import com.suffixit.applocker.service.AppConfigurationService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class AppConfigurationServiceImpl implements AppConfigurationService {

    private final AppConfigurationRepository appConfigurationRepository;

    public AppConfigurationServiceImpl(AppConfigurationRepository appConfigurationRepository) {
        this.appConfigurationRepository = appConfigurationRepository;
    }

    @Override
    public Boolean createAppConfiguration(String androidId) {
        Optional<AppConfiguration> androidIdContaining = appConfigurationRepository.findByAndroidId(androidId);
        AppConfiguration appConfiguration = new AppConfiguration();
        if(androidIdContaining.isPresent()){
           return true;
        }
        appConfiguration.setAndroidId(androidId);
        appConfiguration.setLockStatus(true);
        appConfiguration.setIntervalTime(30);
        appConfigurationRepository.save(appConfiguration);
        return true;
    }

    @Override
    public AppConfiguration getAppConfigurationDetails(String androidId) {
        AppConfiguration androidIdContaining = appConfigurationRepository.findByAndroidIdContaining(androidId);
        return androidIdContaining;
    }
}
