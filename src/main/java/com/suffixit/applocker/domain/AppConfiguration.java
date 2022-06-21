package com.suffixit.applocker.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"android_id"})})
public class AppConfiguration {
    @Id
    @SequenceGenerator(name="APP_CONFIGURATION_ID_GENERATOR", sequenceName="APP_CONFIG_GEN",  initialValue = 10, allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="APP_CONFIGURATION_ID_GENERATOR")
    private long id;
    @Column(name = "android_id")
    private String androidId;
    @Column(name = "lock_status")
    private boolean lockStatus;

    private int intervalTime;
}
