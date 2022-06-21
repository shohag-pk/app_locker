package com.suffixit.applocker.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="APK_VERSION")
@NamedQuery(name="ApkVersion.findAll", query="SELECT a FROM ApkVersion a")
public class ApkVersion {

    @Id
    @SequenceGenerator(name="APK_VERSION_ID_GENERATOR", sequenceName="APK_VERSION_GENERATOR",  initialValue = 20, allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="APK_VERSION_ID_GENERATOR")
    private long id;

    @Column(name="VERSION")
    private String version;

    @Column(name="URL")
    private String url;

    @Temporal(TemporalType.DATE)
    private Date ed;

    @Temporal(TemporalType.DATE)
    private Date td;

    @Temporal(TemporalType.DATE)
    @Column(name = "ADD_DATE")
    private Date addDate;

}

