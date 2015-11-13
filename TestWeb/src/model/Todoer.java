package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TODOER database table.
 * 
 */
@Entity
@Table(name="TODOER", schema="nelson")
@NamedQuery(name="Todoer.findAll", query="SELECT t FROM Todoer t")
public class Todoer implements Serializable {
	private static final long serialVersionUID = 1L;

	 @Id
	 @SequenceGenerator( name = "TODOER_SEQ", sequenceName = "TODOER_SEQ", allocationSize = 1, initialValue = 1 )
	 @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "TODOER_SEQ" )
	private long id;

	private BigDecimal adminrole;

	private String email;

	private String name;

	private String password;

	public Todoer() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getAdminrole() {
		return this.adminrole;
	}

	public void setAdminrole(BigDecimal adminrole) {
		this.adminrole = adminrole;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}