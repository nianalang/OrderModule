package com.zte.po;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 订单日志实体
 * 
 * @author 郎媛勤
 *
 */
public class OrderLog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 编号
	 */
	private Integer log_id;
	/**
	 * 订单编号
	 */
	private Integer order_id;
	/**
	 * 订单状态
	 */
	private Integer status;
	/**
	 * 时间
	 */
	private Timestamp time;

	public Integer getLog_id() {
		return log_id;
	}

	public void setLog_id(Integer log_id) {
		this.log_id = log_id;
	}

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String toString() {
		return "OrderLog [log_id=" + log_id + ", order_id=" + order_id + ", status=" + status + ", time=" + time + "]";
	}

}