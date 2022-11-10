package com.ZenPack.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "report_columns")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class ReportColumns implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "report_data_id")
	private long reportDataId;
	
	@Column(name = "device_type")
	private String deviceType;
	
	@Column(name = "report_name")
	private String reportName;
	
	@Column(name = "data_type")
	private String dataType;
	
	@Column(name = "is_size_matrics")
	private String isSizeMatrics;
	
	@Column(name = "seq")
	private String seq;
	
	@Column(name = "report_columns")
	private String reportColumns;
	
	@Column(name = "report_by")
	private String reportBy;
	
	@Column(name = "db_field_name")
	private String dbFieldName;
	
	@Column(name = "is_pinned")
	private boolean isPinned;
	
	@Column(name = "tasklist_sub_category")
	private String tasklistSubCategory;
	
	@Column(name = "alias_name")
	private String aliasName;
	
	@Column(name = "devices")
	private String devices;
	
	@Column(name = "tasklist_category")
	private String tasklistCategory;
	
	@Column(name = "rcategory_seq")
	private String categorySeq;
	
	@Column(name = "sub_category_seq")
	private String subCategorySeq;
	
	@Column(name = "hide")
	private boolean hide;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "zen_pack_report_id", referencedColumnName = "zen_pack_report_id")
	private ZenPackReport zenPackReport;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "zen_pack_id", referencedColumnName = "zen_pack_id")
	private ZenPack zenPackId;
	

	

}
