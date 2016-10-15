package com.koylubaevnt.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the goods_hierarchy database table.
 * 
 */
@Entity
@Table(name="goods_hierarchy")
@NamedQuery(name="GoodsHierarchy.findAll", query="SELECT g FROM GoodsHierarchy g")
public class GoodsHierarchy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	private String name;

	//bi-directional many-to-one association to GoodsGroup
	@OneToMany(mappedBy="goodsHierarchy")
	private List<GoodsGroup> goodsGroups;

	public GoodsHierarchy() {
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

	public List<GoodsGroup> getGoodsGroups() {
		return this.goodsGroups;
	}

	public void setGoodsGroups(List<GoodsGroup> goodsGroups) {
		this.goodsGroups = goodsGroups;
	}

	public GoodsGroup addGoodsGroup(GoodsGroup goodsGroup) {
		getGoodsGroups().add(goodsGroup);
		goodsGroup.setGoodsHierarchy(this);

		return goodsGroup;
	}

	public GoodsGroup removeGoodsGroup(GoodsGroup goodsGroup) {
		getGoodsGroups().remove(goodsGroup);
		goodsGroup.setGoodsHierarchy(null);

		return goodsGroup;
	}

}