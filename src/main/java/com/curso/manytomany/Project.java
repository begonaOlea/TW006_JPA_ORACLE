package com.curso.manytomany;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name="PROJECTS")
public class Project implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	@Column(name= "DESCRIPTION")
	private String  description;
	
    @JoinTable(name = "WORKED_PROYECT", 
    		joinColumns = {
		        @JoinColumn(name = "PROJECT_ID", referencedColumnName = "ID")}, 
    		inverseJoinColumns = {
		        @JoinColumn(name = "WORKER_ID", referencedColumnName = "ID")})
	@ManyToMany
	private Collection<Worker> workers;
	
	public Project() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Collection<Worker> getWorkers() {
		return workers;
	}

	public void setWorkers(Collection<Worker> workers) {
		this.workers = workers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
