package com.ZenPack.repository;


import com.ZenPack.model.ReportColumns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ReportColumnsRepository extends JpaRepository<ReportColumns, Long>, JpaSpecificationExecutor<ReportColumns>{

}
