package com.zte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zte.dto.ResultData;
import com.zte.enums.OrderEnums;
import com.zte.po.Cart;
import com.zte.service.CartService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 购物车业务控制层
 * 
 * @author 念阿郎
 *
 */
@Controller
@RequestMapping("/order")
@Api(value = "订单控制层", tags = "订单控制层")
public class OrderController {

	@Autowired
	private CartService cartService;

	/**
	 * 用户查询购物车并分页
	 */
	@RequestMapping(value = "/getCart", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(notes = "查询购物车", httpMethod = "POST", value = "查询购物车")
	public ResultData<List<Cart>> getCartByMemberID(
			@ApiParam(value = "当前页数", required = true) @RequestParam("pageNum") int pageNum,
			@ApiParam(value = "每页显示的记录数", required = true) @RequestParam("pageSize") int pageSize,
			@ApiParam(value = "用户ID", required = true) @RequestParam("member_id") int member_id) {
		List<Cart> carts = cartService.selectByMemberId(pageNum, pageSize, member_id);
		if (carts != null) {
			return new ResultData<List<Cart>>(true, carts);
		} else {
			return new ResultData<List<Cart>>(false, OrderEnums.QUERYFAIL.getStateInfo());
		}
	}

	/**
	 * 将购物车的商品结算，生成订单和日志
	 */
	@RequestMapping(value = "/payOffCart", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(notes = "结算购物车", httpMethod = "GET", value = "结算购物车")
	public ResultData<String> payOffCart(@ApiParam(value = "用户ID", required = true) @RequestParam("member_id") int member_id){
		
		return null;
	}
}
