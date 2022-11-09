package com.ZenPack.repository;

import com.ZenPack.Dto.ReportZenPackDto;
import com.ZenPack.model.ZenPackReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZenPackReportRepository extends JpaRepository<ZenPackReport,Integer>, JpaSpecificationExecutor<ZenPackReport> {
    @Query("SELECT new com.ZenPack.Dto.ReportZenPackDto(r.id,r.feature,r.category,r.osType,r.discoveryType,r.analyticsBy,z.isAnalytics,z.isQuickAccess,z.isDashboard,z.addToFavorite,z.favoriteViewName) from Report r JOIN com.ZenPack.model.ZenPackReport z ON r.id =z.zenpackReportId where r.id =:zenpackReportId")
    List<ReportZenPackDto> findAll(@Param("zenpackReportId") int zenpackReportId);

}
