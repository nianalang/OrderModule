package com.zte.po;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 订单实体
 * 
 * @author 郎媛勤
 *
 */
public class Order implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 编号
	 */
	private Integer order_id;
	/**
	 * 订单号
	 */
	private String sn;
	/**
	 * 会员id
	 */
	private Integer member_id;
	/*
	 * status,订单状态 0：创建（待付款） 1：付款（待发货） 2：发货（待收货） 3：收货（完成） 4：取消
	 */
	private Integer status;
	/**
	 * 支付id
	 */
	private Integer payment_id;
	/**
	 * 物流id
	 */
	private Integer logi_id;
	/**
	 * 总金额
	 */
	private Double total_amount;
	/**
	 * 会员收获地址编号
	 */
	private Integer address_id;

	/**
	 * 创建时间
	 */
	private Timestamp creatime;
	/**
	 * 修改时间
	 */
	private Timestamp modifytime;

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public Integer getMember_id() {
		return member_id;
	}

	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(Integer payment_id) {
		this.payment_id = payment_id;
	}

	public Integer getLogi_id() {
		return logi_id;
	}

	public void setLogi_id(Integer logi_id) {
		this.logi_id = logi_id;
	}

	public Double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(Double total_amount) {
		this.total_amount = total_amount;
	}

	public Integer getAddress_id() {
		return address_id;
	}

	public void setAddress_id(Integer address_id) {
		this.address_id = address_id;
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

}