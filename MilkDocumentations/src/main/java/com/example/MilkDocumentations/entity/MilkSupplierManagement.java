package com.example.MilkDocumentations.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "milksupplierdocument")
public class MilkSupplierManagement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "supplier_id")
	private MilkSupplier milkSupplier;

	@ManyToOne
	@JoinColumn(name = "document_type_id")
	private DocumentType documentType;

	@Column
	private String documentUrl;

	@Column
	private String photoName;

	//change the data types to Long for dates
	@Column
	private long startDate;
	@Column
	private long endDate;

	@Column
	private String documentNumber;

	@Column(columnDefinition = "boolean default false")
	private boolean deleted;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public MilkSupplier getMilkSupplier() {
		return milkSupplier;
	}

	public void setMilkSupplier(MilkSupplier milkSupplier) {
		this.milkSupplier = milkSupplier;
	}

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	public String getDocumentUrl() {
		return documentUrl;
	}

	public void setDocumentUrl(String documentUrl) {
		this.documentUrl = documentUrl;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	

	public long getStartDate() {
		return startDate;
	}

	public void setStartDate(long startDate) {
		this.startDate = startDate;
	}

	public long getEndDate() {
		return endDate;
	}

	public void setEndDate(long endDate) {
		this.endDate = endDate;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

}
