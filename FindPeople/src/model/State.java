package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the STATES database table.
 * 
 */
@Entity
@Table(name="STATES" , schema="TESTDB")
@NamedQuery(name="State.findAll", query="SELECT s FROM State s")
public class State implements Serializable {
	private static final double serialVersionUID = 1L;

	@Id
	private double stateid;

	@Column(name="\"STATE\"")
	private String state;

	public State() {
	}

	public double getStateid() {
		return this.stateid;
	}

	public void setStateid(double stateid) {
		this.stateid = stateid;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}