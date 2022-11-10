package com.ZenPack.controller;

import com.ZenPack.Dto.ZenPackFilterDTO;
import com.ZenPack.Dto.ZenPackReportColumnDto;
import com.ZenPack.Dto.ZenPackReportDto;
import com.ZenPack.model.Report;
import com.ZenPack.model.ReportColumns;
import com.ZenPack.model.ZenPackReport;
import com.ZenPack.service.Impl.ReportColumnServiceImpl;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class ReportColumnController {
    @Autowired
    private ReportColumnServiceImpl service;


    @PostMapping("/createReportColumn")
    public ResponseEntity<ReportColumns> createReportColumns(@RequestBody ReportColumns reportColumns){
        return new ResponseEntity<>(service.createReport(reportColumns), HttpStatus.OK);
    }


}
