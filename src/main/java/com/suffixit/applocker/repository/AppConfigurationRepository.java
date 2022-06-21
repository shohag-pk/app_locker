package com.suffixit.applocker.repository;

import com.suffixit.applocker.domain.AppConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppConfigurationRepository extends JpaRepository<AppConfiguration, Long> {
    Optional<AppConfiguration> findByAndroidId(String androidId);

    AppConfiguration findByAndroidIdContaining(String androidId);
}
