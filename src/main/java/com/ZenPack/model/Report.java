package com.ZenPack.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.ZenPack.Dto.FeatureDto;
import com.ZenPack.Dto.MenuDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "report")
@JsonIgnoreProperties({"hibernateLazyInitializer"})

public class Report{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "report_id")
	private Long id;
	@Column(name = "feature")
	private String feature;
	@Column(name = "category")
	private String category;
	@Column(name = "os_type")
	private String osType;
	@Column(name = "discovery_type")
	private String discoveryType;
	@Column(name = "analytics_by")
	private String analyticsBy;

//	@ManyToMany(mappedBy = "reports")
//	private ZenPackReport zenPackReport;

//	@ManyToMany(mappedBy = "reports")
//	private List<ZenPackReport> zenPackReports = new ArrayList<>();

//	@OneToMany(targetEntity = ZenPackReport.class,cascade = CascadeType.ALL)
//	@JoinColumn(name ="report_id_fk",referencedColumnName = "report_id")
//	private List<Report> reports;

//	@OneToMany(targetEntity = ZenPackReport.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//	@JoinColumn(name = "report_id_fk", nullable = true,foreignKey = @ForeignKey(name="report_id_fk"))
//	private List<Report> reports;

//	@ManyToOne(fetch = FetchType.LAZY)
//	private ZenPackReport zenPackReport;

}
