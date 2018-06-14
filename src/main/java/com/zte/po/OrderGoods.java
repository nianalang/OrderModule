package com.zte.po;

import java.io.Serializable;

/**
 * 订单商品实体
 * 
 * @author 郎媛勤
 *
 */
public class OrderGoods implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 编号
	 */
	private Integer id;
	/**
	 * 订单编号
	 */
	private Integer order_id;
	/**
	 * 商品编号
	 */
	private Integer goods_id;
	/**
	 * 商品数量
	 */
	private Integer goods_num;
	/**
	 * 商品单价
	 */
	private Double price;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public Integer getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}

	public Integer getGoods_num() {
		return goods_num;
	}

	public void setGoods_num(Integer goods_num) {
		this.goods_num = goods_num;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
