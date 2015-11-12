package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the STATUS database table.
 * 
 */
@Entity
@Table(name="STATUS", schema="testuserdb")
@NamedQuery(name="Status.findAll", query="SELECT s FROM Status s")
public class Status implements Serializable {
	private static final long serialVersionUID = 1L;

	 @Id
	 @SequenceGenerator( name = "STATUS_SEQ", sequenceName = "STATUS_SEQ", allocationSize = 1, initialValue = 1 )
	 @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "STATUS_SEQ" )
	private long id;

	private String status;

	//bi-directional many-to-one association to Todo
	@OneToMany(mappedBy="status")
	private List<Todo> todos;

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

	public List<Todo> getTodos() {
		return this.todos;
	}

	public void setTodos(List<Todo> todos) {
		this.todos = todos;
	}

	public Todo addTodo(Todo todo) {
		getTodos().add(todo);
		todo.setStatus(this);

		return todo;
	}

	public Todo removeTodo(Todo todo) {
		getTodos().remove(todo);
		todo.setStatus(null);

		return todo;
	}

}