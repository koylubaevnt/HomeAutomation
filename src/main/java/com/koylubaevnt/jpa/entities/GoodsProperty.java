package com.koylubaevnt.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the goods_property database table.
 * 
 */
@Entity
@Table(name="goods_property")
@NamedQuery(name="GoodsProperty.findAll", query="SELECT g FROM GoodsProperty g")
public class GoodsProperty implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="begin_date")
	private Date beginDate;

	private String value;

	//bi-directional many-to-one association to Good
	@ManyToOne
	@JoinColumn(name="goods_id")
	private Good good;

	//bi-directional many-to-one association to GoodsParameter
	@ManyToOne
	@JoinColumn(name="parameter_id")
	private GoodsParameter goodsParameter;

	public GoodsProperty() {
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

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Good getGood() {
		return this.good;
	}

	public void setGood(Good good) {
		this.good = good;
	}

	public GoodsParameter getGoodsParameter() {
		return this.goodsParameter;
	}

	public void setGoodsParameter(GoodsParameter goodsParameter) {
		this.goodsParameter = goodsParameter;
	}

}