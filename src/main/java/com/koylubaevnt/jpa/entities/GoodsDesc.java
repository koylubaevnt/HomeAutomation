package com.koylubaevnt.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the goods_desc database table.
 * 
 */
@Entity
@Table(name="goods_desc")
@NamedQuery(name="GoodsDesc.findAll", query="SELECT g FROM GoodsDesc g")
public class GoodsDesc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	@Temporal(TemporalType.DATE)
	@Column(name="begin_date")
	private Date beginDate;

	@Temporal(TemporalType.DATE)
	@Column(name="end_date")
	private Date endDate;

	//bi-directional many-to-one association to Good
	@ManyToOne
	@JoinColumn(name="goods_id")
	private Good good;

	//bi-directional many-to-one association to GoodsGroup
	@ManyToOne
	@JoinColumn(name="goods_group_id")
	private GoodsGroup goodsGroup;

	public GoodsDesc() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getBeginDate() {
		return this.beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Good getGood() {
		return this.good;
	}

	public void setGood(Good good) {
		this.good = good;
	}

	public GoodsGroup getGoodsGroup() {
		return this.goodsGroup;
	}

	public void setGoodsGroup(GoodsGroup goodsGroup) {
		this.goodsGroup = goodsGroup;
	}

}