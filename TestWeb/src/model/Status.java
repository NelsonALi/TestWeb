package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the STATUS database table.
 * 
 */
@Entity
@Table(name="STATUS", schema="nelson")
@NamedQuery(name="Status.findAll", query="SELECT s FROM Status s")
public class Status implements Serializable {
	private static final long serialVersionUID = 1L;

	 @Id
	 @SequenceGenerator( name = "STATUS_SEQ", sequenceName = "STATUS_SEQ", allocationSize = 1, initialValue = 1 )
	 @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "STATUS_SEQ" )
	private long id;

	private String status;

	//bi-directional one-to-one association to Todo
	@OneToOne(mappedBy="status")
	private Todo todo;

	public Status() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Todo getTodo() {
		return this.todo;
	}

	public void setTodo(Todo todo) {
		this.todo = todo;
	}

}