package com.jdpaley;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Student {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
//    @NotNull
//    @Min(1)
    private Long id;

//    @NotNull
//    @Size(min=2, max=30)
    private String name;
    
//    @NotNull
//    @Size(min=2, max=30)
    private String food;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", food=" + food + "]";
	}
		
}
