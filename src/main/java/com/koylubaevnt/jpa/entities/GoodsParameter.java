package com.koylubaevnt.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the goods_parameter database table.
 * 
 */
@Entity
@Table(name="goods_parameter")
@NamedQuery(name="GoodsParameter.findAll", query="SELECT g FROM GoodsParameter g")
public class GoodsParameter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	private String name;

	private String tag;

	//bi-directional many-to-one association to GoodsProperty
	@OneToMany(mappedBy="goodsParameter")
	private List<GoodsProperty> goodsProperties;

	public GoodsParameter() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public List<GoodsProperty> getGoodsProperties() {
		return this.goodsProperties;
	}

	public void setGoodsProperties(List<GoodsProperty> goodsProperties) {
		this.goodsProperties = goodsProperties;
	}

	public GoodsProperty addGoodsProperty(GoodsProperty goodsProperty) {
		getGoodsProperties().add(goodsProperty);
		goodsProperty.setGoodsParameter(this);

		return goodsProperty;
	}

	public GoodsProperty removeGoodsProperty(GoodsProperty goodsProperty) {
		getGoodsProperties().remove(goodsProperty);
		goodsProperty.setGoodsParameter(null);

		return goodsProperty;
	}

}