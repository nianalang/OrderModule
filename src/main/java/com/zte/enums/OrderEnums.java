package com.zte.enums;

/**
 * 状态设置
 * @author 郎媛勤
 *
 */
public enum OrderEnums {
	QUERY_ERROR(-2, "系统异常"),
	QUERYSUCCESS (1,"查询成功"),
	QUERYFAIL(-1,"查询失败");
	
	private int state;//状态

    private String stateInfo;//信息

	private OrderEnums(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}
  
}
