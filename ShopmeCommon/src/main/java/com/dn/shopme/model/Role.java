package com.dn.shopme.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="roles")
@Data
@AllArgsConstructor()
@NoArgsConstructor
public class Role
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 50,nullable = false, unique = true)
	private String name;
	@Column(length = 150,nullable = false)
	private String description;
	public Role(String name, String description)
	{
		super();
		this.name = name;
		this.description = description;
	}
	public Role(Long id) 
	{
		super();
		this.id = id;
	}
	
	public String toString()
	{
		return this.name;
	}
}

