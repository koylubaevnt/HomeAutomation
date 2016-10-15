package com.koylubaevnt.jpa.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the goods database table.
 * 
 */
@Entity
@Table(name = "goods")
@NamedQuery(name = "Good.findAll", query = "SELECT g FROM Good g")
public class Good implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;

	private String description;

	@Lob
	private byte[] image;

	private String name;

	// bi-directional many-to-one association to Barcode
	@OneToMany(mappedBy = "good")
	private List<Barcode> barcodes;

	// bi-directional many-to-one association to GoodsDesc
	@OneToMany(mappedBy = "good")
	private List<GoodsDesc> goodsDescs;

	// bi-directional many-to-one association to GoodsProperty
	@OneToMany(mappedBy = "good")
	private List<GoodsProperty> goodsProperties;

	public Good() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Barcode> getBarcodes() {
		return this.barcodes;
	}

	public void setBarcodes(List<Barcode> barcodes) {
		this.barcodes = barcodes;
	}

	public Barcode addBarcode(Barcode barcode) {
		getBarcodes().add(barcode);
		barcode.setGood(this);

		return barcode;
	}

	public Barcode removeBarcode(Barcode barcode) {
		getBarcodes().remove(barcode);
		barcode.setGood(null);

		return barcode;
	}

	public List<GoodsDesc> getGoodsDescs() {
		return this.goodsDescs;
	}

	public void setGoodsDescs(List<GoodsDesc> goodsDescs) {
		this.goodsDescs = goodsDescs;
	}

	public GoodsDesc addGoodsDesc(GoodsDesc goodsDesc) {
		getGoodsDescs().add(goodsDesc);
		goodsDesc.setGood(this);

		return goodsDesc;
	}

	public GoodsDesc removeGoodsDesc(GoodsDesc goodsDesc) {
		getGoodsDescs().remove(goodsDesc);
		goodsDesc.setGood(null);

		return goodsDesc;
	}

	public List<GoodsProperty> getGoodsProperties() {
		return this.goodsProperties;
	}

	public void setGoodsProperties(List<GoodsProperty> goodsProperties) {
		this.goodsProperties = goodsProperties;
	}

	public GoodsProperty addGoodsProperty(GoodsProperty goodsProperty) {
		getGoodsProperties().add(goodsProperty);
		goodsProperty.setGood(this);

		return goodsProperty;
	}

	public GoodsProperty removeGoodsProperty(GoodsProperty goodsProperty) {
		getGoodsProperties().remove(goodsProperty);
		goodsProperty.setGood(null);

		return goodsProperty;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getName()).append("[").append("id: ").append(id).append(", name: ").append(name)
				.append(", description: ").append(description).append("]");
		return sb.toString();
	}

}