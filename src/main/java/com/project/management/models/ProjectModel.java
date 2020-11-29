package com.project.management.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "project")
public class ProjectModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	@Column(name = "PROJECT_NAME")
	@NotBlank(message="pName is required")
	private String pName;
	@NotBlank(message = "pId is required")
	@Size(min=4, max=5, message = "Allow only 4 to 5 characters")
	@Column(name = "PROJECT_IDENTIFIER",updatable = false, unique = true)
	private String pId;
	@Column(name = "DESCRIPTION")
	@NotBlank(message = "desc is required")
	private String desc;
	@Column(name = "START_DATE")
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date sDate;
	@Column(name = "END_DATE")
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date eDate;
	@Column(name = "CREATED_AT")
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date createdAt;
	@Column(name = "UPDATED_DATE")
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date updatedAt;

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	public Long getId() {
		return ID;
	}

	public void setId(Long id) {
		this.ID = id;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getsDate() {
		return sDate;
	}

	public void setsDate(Date sDate) {
		this.sDate = sDate;
	}

	public Date geteDate() {
		return eDate;
	}

	public void seteDate(Date eDate) {
		this.eDate = eDate;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "ProjectModel [id=" + ID + ", pName=" + pName + ", pId=" + pId + ", desc=" + desc + ", sDate=" + sDate
				+ ", eDate=" + eDate + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

}
