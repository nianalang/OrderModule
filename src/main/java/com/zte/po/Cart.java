package com.zte.po;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 购物车实体
 * 
 * @author 郎媛勤
 *
 */
public class Cart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 编号
	 */
	private Integer cart_id;
	/**
	 * 会员编号
	 */
	private Integer member_id;
	/**
	 * 商品编号
	 */
	private Integer goods_id;
	/**
	 * 数量
	 */
	private Integer goods_num;
	/**
	 * 是否选中 0:选择，1：不选择
	 */
	private Integer choose;
	/**
	 * 金额
	 */
	private float amount;
	/**
	 * 创建时间
	 */
	private Timestamp creatime;
	/**
	 * 修改时间
	 */
	private Timestamp modifytime;

	public Integer getCart_id() {
		return cart_id;
	}

	public void setCart_id(Integer cart_id) {
		this.cart_id = cart_id;
	}

	public Integer getMember_id() {
		return member_id;
	}

	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
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

	public Integer getChoose() {
		return choose;
	}

	public void setChoose(Integer choose) {
		this.choose = choose;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Timestamp getCreatime() {
		return creatime;
	}

	public void setCreatime(Timestamp creatime) {
		this.creatime = creatime;
	}

	public Timestamp getModifytime() {
		return modifytime;
	}

	public void setModifytime(Timestamp modifytime) {
		this.modifytime = modifytime;
	}

	@Override
	public String toString() {
		return "Cart [cart_id=" + cart_id + ", member_id=" + member_id + ", goods_id=" + goods_id + ", goods_num="
				+ goods_num + ", choose=" + choose + ", amount=" + amount + ", creatime=" + creatime + ", modifytime="
				+ modifytime + "]";
	}
}
