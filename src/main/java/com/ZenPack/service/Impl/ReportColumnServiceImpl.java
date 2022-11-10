package com.ZenPack.service.Impl;

import com.ZenPack.Dto.ZenPackFilterDTO;
import com.ZenPack.Dto.ZenPackReportColumnDto;
import com.ZenPack.model.Report;
import com.ZenPack.model.ReportColumns;
import com.ZenPack.model.ZenPackReport;
import com.ZenPack.repository.ReportColumnsRepository;
import com.ZenPack.repository.ReportRepository;
import com.ZenPack.service.Services.ReportColumnService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReportColumnServiceImpl implements ReportColumnService {
    @Autowired
    private ReportColumnsRepository reportColumnsRepository;


    @Override
    public ReportColumns createReport(ReportColumns reportColumns) {
        return reportColumnsRepository.save(reportColumns);
    }



}
