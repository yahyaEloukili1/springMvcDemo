package org.ensas.springMvcDemo.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Patient {
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)           
	private Long id;
	private String name;
	private Date Naissance;
	private boolean malade;

}
