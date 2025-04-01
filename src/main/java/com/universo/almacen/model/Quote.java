package com.universo.almacen.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Dragonete
 * 
 * CREATE TABLE `investment_total`.`quote` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(45) NOT NULL,
  `date` DATE NOT NULL,
  `open` FLOAT NULL,
  `maximum` FLOAT NULL,
  `minimum` FLOAT NULL,
  `price` FLOAT NOT NULL,
  `volume` INT NULL,
  `capitalization` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `codigo_UNIQUE` (`code` ASC) VISIBLE);
 *
 */
@Entity(name="quote")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quote {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	//@Column(name="code")
	// Code of the Asset 
	//private String code;
	@ManyToOne
	@JoinColumn(name = "asset_id", referencedColumnName = "id")
	private Asset asset;
	//
	@Column(name="date")
	private Date    date;
	@Column(name="open")
	private Float   open;
	@Column(name="maximum")
	private Float   maximum;
	@Column(name="minimum")
	private Float   minimum;
	@Column(name="price")
	private Float   price;
	@Column(name="volume")
	private Integer volume;
	@Column(name="capitalization")
	private Integer capitalization;
	
}
