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
    private Integer zenpackReportId;
    private boolean isAnalytics;
    private boolean isQuickAccess;
    private boolean isDashBoard;
    private boolean addToFavorite;
    private String favoriteViewName;
    private List<Report> reports= new ArrayList<>();
    private int chartCount =0;
    private int validationRuleCount=0;

}
