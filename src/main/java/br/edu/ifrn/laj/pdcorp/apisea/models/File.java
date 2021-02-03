package br.edu.ifrn.laj.pdcorp.apisea.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "file")
public class File {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String fileName;
	@Column(nullable = false)
	private String fileType;
	@Column(nullable = false)
	private long fileSize;
	@Column(name = "idActivity")
	private long idActivity;
	@Column(name = "urlFile")
	private String fileAdress;

	public File() {
		
	}
	
	public File(String fileName, String fileType, long fileSize, long idActivity, String fileAdress) {
		this.fileName = fileName;
		this.fileType = fileType;
		this.fileSize = fileSize;
		this.idActivity = idActivity;
		this.fileAdress = fileAdress;
	}

	public File(Long id, String fileName, String fileType, long fileSize, long idActivity) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileType = fileType;
		this.fileSize = fileSize;
		this.idActivity = idActivity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public long getIdActivity() {
		return idActivity;
	}

	public void setIdActivity(long idActivity) {
		this.idActivity = idActivity;
	}

	public String getFileAdress() {
		return fileAdress;
	}

	public void setFileAdress(String fileAdress) {
		this.fileAdress = fileAdress;
	}

}