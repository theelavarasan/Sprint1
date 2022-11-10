package com.ZenPack.Dto;

import com.ZenPack.model.Report;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ZenPackReportDto {
    private long zenpackReportId;

    private boolean isAnalytics;

    private boolean isQuickAccess;

    private boolean isDashboard;

    private boolean addToFavorite;

    private String favoriteViewName;

    private long reportId;
//    private List<Report> report;

    private long zenPackId;

    private int chartCount =0;

    private String reportDataId;

    private int validationRuleCount=0;

}
