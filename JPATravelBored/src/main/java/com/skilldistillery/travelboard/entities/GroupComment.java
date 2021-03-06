package com.skilldistillery.travelboard.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Table(name="group_comment")
public class GroupComment {

	// F I E L D S
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;


	@Column(name = "content")
	private String content;


	@Column(name = "create_date")
	private String createDate;


	@ManyToOne
	@JoinColumn(name = "group_id")
	private Group group;


	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;



	
	// C O N S T R U C T O R S
	public GroupComment() {
		super();
	}



	// G E T T E R S _ A N D _ S E T T E R S
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}



	// A D D E R S

	
}	

