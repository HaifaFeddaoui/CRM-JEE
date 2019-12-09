package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the FileUploads database table.
 * 
 */
@Entity
@Table(name="FileUploads")
@NamedQuery(name="FileUpload.findAll", query="SELECT f FROM FileUpload f")
public class FileUpload implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String path;

	private int type;

	public FileUpload() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

}