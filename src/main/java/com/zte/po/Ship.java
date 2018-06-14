package com.zte.po;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 货运公司实体
 * 
 * @author 念阿郎
 *
 */
public class Ship implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 编号
	 */
	private Integer ship_id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 代码
	 */
	private String code;
	/**
	 * 创建时间
	 */
	private Timestamp creatime;
	/**
	 * 修改时间
	 */
	private Timestamp modifytime;

	public Integer getShip_id() {
		return ship_id;
	}

	public void setShip_id(Integer ship_id) {
		this.ship_id = ship_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String toString() {
		return "Ship [ship_id=" + ship_id + ", name=" + name + ", code=" + code + ", creatime=" + creatime
				+ ", modifytime=" + modifytime + "]";
	}
}
