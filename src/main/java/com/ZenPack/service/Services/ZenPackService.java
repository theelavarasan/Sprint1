package com.ZenPack.service.Services;

import java.util.List;

import com.ZenPack.Dto.ZenPackReportDto;
import com.ZenPack.exception.ZenPackException;
import com.ZenPack.model.Report;
import com.ZenPack.model.ZenPackReport;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.ZenPack.Dto.ZenPackDto;
import com.ZenPack.Specification.SearchRequest;
import com.ZenPack.model.ZenPack;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface  ZenPackService {
    ResponseEntity<ZenPack> saveZenPack(ZenPack zenPack);

    ResponseEntity<ZenPackDto> createZenPack(ZenPackDto createDto) throws JsonProcessingException, ZenPackException;

    List<ZenPackDto> getAllZenPack() throws JsonProcessingException;

    String deleteByzenPackId(Long zenPackId);

    ZenPackDto getByZenPackId(Long zenPackId);
    
    boolean checkZenPackName(String name);
    
    Page<ZenPack> searchZenPack(SearchRequest request);

    String setActiveOrInActive(Long zenPackId);

    ResponseEntity<ZenPackReportDto> save(ZenPackReportDto zenPackReportDto);

    List<Report> getAllReports();
}
