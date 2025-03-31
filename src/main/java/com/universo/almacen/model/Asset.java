package com.universo.almacen.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="asset")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Asset {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="code")
	private String code;
	@Column(name="description")
	private String description;
	@Column(name="type")
	private String type;
	@Column(name="sector")
	private String sector;
	@Column(name="market")
	private String market;
	@Column(name="code_alt")
	private String codeAlt;	

}
