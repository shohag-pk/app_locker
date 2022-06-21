package com.suffixit.applocker.service;

import com.suffixit.applocker.domain.AppConfiguration;

public interface AppConfigurationService {

    Boolean createAppConfiguration(String androidId);

    AppConfiguration getAppConfigurationDetails(String androidId);
}
