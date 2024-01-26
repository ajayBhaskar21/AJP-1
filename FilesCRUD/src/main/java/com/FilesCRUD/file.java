package com.FilesCRUD;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class file {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increments id in database
	public int id;
	private String fileName;
	private String fileType;
	private String lastModified;

	public file() {

	}

	public file(int id, String fileName, String fileType, String lastModified) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileType = fileType;
		this.lastModified = lastModified;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getLastModified() {
		return lastModified;
	}

	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}

	@Override
	public String toString() {
		return "\nfile [id=" + id + ", fileName=" + fileName + ", fileType=" + fileType + ", lastModified="
				+ lastModified + "]";
	}

}
