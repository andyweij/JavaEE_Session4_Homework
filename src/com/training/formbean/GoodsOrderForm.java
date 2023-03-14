package com.training.formbean;

import org.apache.struts.action.ActionForm;

public class GoodsOrderForm extends ActionForm{
	private String[] goodsIDs;
	private int inputMoney;
	private int[] buyQuantitys;
	private String customerID;
	private String pageNo;
	private String searchKeyword;
	public String getPageNo() {
		return pageNo;
	}
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	public String[] getGoodsIDs() {
		return goodsIDs;
	}
	public void setGoodsIDs(String[] goodsIDs) {
		this.goodsIDs = goodsIDs;
	}
	public int getInputMoney() {
		return inputMoney;
	}
	public void setInputMoney(int inputMoney) {
		this.inputMoney = inputMoney;
	}
	public int[] getBuyQuantitys() {
		return buyQuantitys;
	}
	public void setBuyQuantitys(int[] buyQuantitys) {
		this.buyQuantitys = buyQuantitys;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	
	
	
	
	
	
}
