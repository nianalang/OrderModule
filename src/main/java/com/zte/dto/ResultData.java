package com.zte.dto;

import java.io.Serializable;

/**
 * 返回的结果
 * @author 郎媛勤
 *
 */
public class ResultData<T> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5018310230762521176L;

	/**
	 * 成功的标志
	 */
	private boolean success;

	/**
	 * 数据
	 */
	private T data;

	/**
	 * 错误的原因
	 */
	private String error;


	/**
	 * 正确的数据
	 * 
	 * @param success
	 * @param data
	 */
	public ResultData(boolean success, T data) {
		super();
		this.success = success;
		this.data = data;
	}

	/**
	 * 错误的标志和原因
	 * 
	 * @param success
	 * @param error
	 */
	public ResultData(boolean success, String error) {
		super();
		this.success = success;
		this.error = error;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}

