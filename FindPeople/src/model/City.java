package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CITY database table.
 * 
 */
@Entity
@Table(name="City", schema="TESTDB")
@NamedQuery(name="City.findAll", query="SELECT c FROM City c")
public class City implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private double cityid;

	@Column(name="\"city\"")
	private String city;

	public City() {
	}

	public double getCityid() {
		return this.cityid;
	}

	public void setCityid(double cityid) {
		this.cityid = cityid;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}