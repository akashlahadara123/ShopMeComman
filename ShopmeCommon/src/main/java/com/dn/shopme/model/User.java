package com.dn.shopme.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User 
{
	
	public User(String firstName, String lastName, String email, String password) 
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="first_name",length = 64,nullable = false)
	private String firstName;
	@Column(name="last_name",length = 64,nullable = false)
	private String lastName;
	@Column(length = 128,nullable = false,unique = true)
	private String email;
	@Column(length =64,nullable = false)
	private String password;
	@Column(length = 64)
	private String photos;
	private boolean enabled;
	@ManyToMany
	@JoinTable(
				name = "user_roles",
				joinColumns =@JoinColumn(name="user_id"),
				inverseJoinColumns=@JoinColumn(name="role_id")
			)
	private Set<Role> roles=new HashSet<>(); //
	public void addRole(Role role)
	{
		this.roles.add(role);
	}
	
}
