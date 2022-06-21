package com.suffixit.applocker.repository;

import com.suffixit.applocker.domain.ApkVersion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApkVersionRepository extends JpaRepository<ApkVersion, Long> {

    @Query("from ApkVersion where sysdate between ed and td")
    Optional<ApkVersion> getUpdate();

    @Query(nativeQuery = true, value = "select * from apk_version apkVersion order by apkVersion.id desc FETCH NEXT 1 ROWS ONLY")
    Optional<ApkVersion> getFirstOrderById();


}
