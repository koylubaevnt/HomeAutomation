package com.koylubaevnt.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the barcode database table.
 * 
 */
@Entity
@NamedQuery(name="Barcode.findAll", query="SELECT b FROM Barcode b")
public class Barcode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	private String barcode;

	//bi-directional many-to-one association to Good
	@ManyToOne
	@JoinColumn(name="goods_id")
	private Good good;

	public Barcode() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Good getGood() {
		return this.good;
	}

	public void setGood(Good good) {
		this.good = good;
	}

}