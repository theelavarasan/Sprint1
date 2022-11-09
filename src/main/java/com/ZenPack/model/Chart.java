package com.ZenPack.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.json.JSONObject;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "chart")
@JsonInclude(JsonInclude.Include.NON_NULL)
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Chart {
    @Id
    private int chartId;
    @Type(type = "jsonb") // See (2)
    @Column(name = "chart_configuration", columnDefinition = "jsonb")
    private JSONObject chartConfiguration;
    @Column(name = "is_dashboard")
    private boolean isDashboard = false;
    @Column(name = "site_key")
    private String siteKey;
    @Column(name = "report_name")
    private String reportName;
    @Column(name = "chart_name")
    private String chartName;
    @Column(name = "filter_property")
    private String filterProperty;
    @Column(name = "chart_type")
    private String chartType;
    @Column(name = "created_time")
    private String createdTime;
    @Column(name = "updated_time")
    private String updatedTime;
    @Column(name = "is_active")
    private boolean isActive;
    @Column(name = "user_id")
    private String userId = "";
    @Column(name = "user_access_list")
    private String userAccessList;
    @Column(name = "site_access_list")
    private String siteAccessList;
    @Column(name = "chart_desc")
    private String chartDesc;
    @Column(name = "is_visible")
    private boolean isVisible;
    @Column(name = "is_default")
    private boolean isDefault;
    @Column(name = "analytics_for")
    private String analyticsFor = "";
    @Column(name = "analytics_type")
    private String analyticsType = "";
    @Column(name = "category_list")
    private String categoryList;
    @Type(type = "jsonb") // See (2)
    @Column(name = "chart_details", columnDefinition = "jsonb")
    private JSONObject chartDetails;
    @Column(name = "report_table")
    private String reportTable;
}
