package com.ZenPack.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "zen_pack_report")
@JsonIgnoreProperties({"hibernateLazyInitializer"})

public class ZenPackReport implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "zen_pack_report_id")
    private Long zenpackReportId;

    @Column(name = "is_analytics")
    private boolean isAnalytics;

    @Column(name = "is_quick_access")
    private boolean isQuickAccess;

    @Column(name = "is_dashboard")
    private boolean isDashboard;

    @Column(name = "add_to_favorite")
    private boolean addToFavorite;

    @Column(name = "favorite_view_name")
    private String favoriteViewName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "report_id", referencedColumnName = "report_id")
    private Report report;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "zen_pack_id", referencedColumnName = "zen_pack_id")
    private ZenPack zenPackId;



//    @OneToMany(targetEntity = ZenPackReport.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    @JoinColumn(name = "report_id", nullable = true,foreignKey = @ForeignKey(name="report_id_fk"))
//    private List<Report> reports;

//    @OneToMany(targetEntity = Report.class,cascade = CascadeType.ALL)
//    @JoinColumn(name ="zen_pack_report_id_fk",referencedColumnName = "zen_pack_report_id")
//    private List<Report> reports;


}
