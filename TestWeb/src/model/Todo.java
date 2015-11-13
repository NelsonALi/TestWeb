package model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the TODOS database table.
 * 
 */
@Entity
@Table(name="TODOS", schema="testuserdb")
@NamedQuery(name="Todo.findAll", query="SELECT t FROM Todo t")
public class Todo implements Serializable {
	private static final long serialVersionUID = 1L;

	 @Id
	 @SequenceGenerator( name = "TODOS_SEQ", sequenceName = "TODOS_SEQ", allocationSize = 1, initialValue = 1 )
	 @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "TODOS_SEQ" )
	private long id;

	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name="DUE_DATE")
	private Date dueDate;

	@Column(name="INIT_TIME")
	private Timestamp initTime;

	@Column(name="TODOER_NAME")
	private String todoerName;

	private int urgency;

	//bi-directional many-to-one association to Status
	@ManyToOne
	private Status status;

	public Todo() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Timestamp getInitTime() {
		return this.initTime;
	}

	public void setInitTime(Timestamp initTime) {
		this.initTime = initTime;
	}

	public String getTodoerName() {
		return this.todoerName;
	}

	public void setTodoerName(String todoerName) {
		this.todoerName = todoerName;
	}

	public int getUrgency() {
		return this.urgency;
	}

	public void setUrgency(int urgency) {
		this.urgency = urgency;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}