package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the COMPANIES database table.
 * 
 */
@Entity
@Table(name="COMPANIES", schema="TESTDB")
@NamedQuery(name="Company.findAll", query="SELECT c FROM Company c")
public class Company implements Serializable {
	private static final double serialVersionUID = 1L;

	@Id
	private double comapnyid;

	private String company;

	public Company() {
	}

	public double getComapnyid() {
		return this.comapnyid;
	}

	public void setComapnyid(double comapnyid) {
		this.comapnyid = comapnyid;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

}