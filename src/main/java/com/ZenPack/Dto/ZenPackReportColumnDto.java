package com.ZenPack.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ZenPackReportColumnDto {
    private long reportDataId;
    private String deviceType;
    private String reportName;
    private String dataType;
    private String isSizeMatrics;
    private String seq;
    private String reportColumns;
    private String reportBy;
    private String dbFieldName;
    private boolean isPinned;
    private String tasklistSubCategory;
    private String aliasName;
    private String devices;
    private String tasklistCategory;
    private String categorySeq;
    private String subCategorySeq;
    private boolean hide;

    private long zen_pack_report_id;


}
