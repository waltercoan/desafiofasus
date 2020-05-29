package br.univille.testeselecao.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Game {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(length=1000)
	private String name;
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date dateCreated;
	@Column(length=1000)
	private String studio;
	
	@ManyToMany(cascade= {CascadeType.MERGE,CascadeType.REFRESH})
	private List<Platform> platformEnable = new ArrayList<Platform>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getStudio() {
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public List<Platform> getPlatformEnable() {
		return platformEnable;
	}

	public void setPlatformEnable(List<Platform> platformEnable) {
		this.platformEnable = platformEnable;
	}
}
