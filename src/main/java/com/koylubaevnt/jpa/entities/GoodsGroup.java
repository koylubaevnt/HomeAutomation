package com.koylubaevnt.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the goods_group database table.
 * 
 */
@Entity
@Table(name="goods_group")
@NamedQuery(name="GoodsGroup.findAll", query="SELECT g FROM GoodsGroup g")
public class GoodsGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	private String name;

	//bi-directional many-to-one association to GoodsDesc
	@OneToMany(mappedBy="goodsGroup")
	private List<GoodsDesc> goodsDescs;

	//bi-directional many-to-one association to GoodsHierarchy
	@ManyToOne
	@JoinColumn(name="goods_hierarchy_id")
	private GoodsHierarchy goodsHierarchy;

	//bi-directional many-to-one association to GoodsGroup
	@ManyToOne
	@JoinColumn(name="master_id")
	private GoodsGroup goodsGroup;

	//bi-directional many-to-one association to GoodsGroup
	@OneToMany(mappedBy="goodsGroup")
	private List<GoodsGroup> goodsGroups;

	public GoodsGroup() {
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

	public List<GoodsDesc> getGoodsDescs() {
		return this.goodsDescs;
	}

	public void setGoodsDescs(List<GoodsDesc> goodsDescs) {
		this.goodsDescs = goodsDescs;
	}

	public GoodsDesc addGoodsDesc(GoodsDesc goodsDesc) {
		getGoodsDescs().add(goodsDesc);
		goodsDesc.setGoodsGroup(this);

		return goodsDesc;
	}

	public GoodsDesc removeGoodsDesc(GoodsDesc goodsDesc) {
		getGoodsDescs().remove(goodsDesc);
		goodsDesc.setGoodsGroup(null);

		return goodsDesc;
	}

	public GoodsHierarchy getGoodsHierarchy() {
		return this.goodsHierarchy;
	}

	public void setGoodsHierarchy(GoodsHierarchy goodsHierarchy) {
		this.goodsHierarchy = goodsHierarchy;
	}

	public GoodsGroup getGoodsGroup() {
		return this.goodsGroup;
	}

	public void setGoodsGroup(GoodsGroup goodsGroup) {
		this.goodsGroup = goodsGroup;
	}

	public List<GoodsGroup> getGoodsGroups() {
		return this.goodsGroups;
	}

	public void setGoodsGroups(List<GoodsGroup> goodsGroups) {
		this.goodsGroups = goodsGroups;
	}

	public GoodsGroup addGoodsGroup(GoodsGroup goodsGroup) {
		getGoodsGroups().add(goodsGroup);
		goodsGroup.setGoodsGroup(this);

		return goodsGroup;
	}

	public GoodsGroup removeGoodsGroup(GoodsGroup goodsGroup) {
		getGoodsGroups().remove(goodsGroup);
		goodsGroup.setGoodsGroup(null);

		return goodsGroup;
	}

}