package com.training.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.training.formbean.GoodsOrderForm;
import com.training.model.Goods;
import com.training.service.FrontendService;
import com.training.vo.BuyGoodsRtn;

public class FrontendAction extends DispatchAction{
	private FrontendService frontendservice = FrontendService.getInstance();
	
	public ActionForward buyGoods(ActionMapping mapping, ActionForm form, 
            HttpServletRequest req, HttpServletResponse resp) throws IOException {
		GoodsOrderForm goodsorderform=(GoodsOrderForm)form;
		Map<String, Goods> queryBuyGoods = frontendservice.queryBuyGoods(goodsorderform);// 查詢購買品項資料庫資訊	
		BuyGoodsRtn buygoodsRtn = frontendservice.priceCalc(goodsorderform, queryBuyGoods);//檢查金額是否足夠		
		if (buygoodsRtn.getPayprice()>=buygoodsRtn.getTotalsprice()) {			
			Set<Goods> goodsOrders = frontendservice.createGoodsOrder(goodsorderform, queryBuyGoods); //建立訂單
			boolean updateresult = frontendservice.buyGoods(goodsOrders); //更新商品庫存
			System.out.println(buygoodsRtn.toString());
		} else {

			System.out.println(buygoodsRtn.toString());
		}
		// Redirect to view
		return mapping.findForward("vendingMachine");
	}
	public ActionForward searchGoods(ActionMapping mapping, ActionForm form, 
        HttpServletRequest req, HttpServletResponse resp) throws IOException {
		GoodsOrderForm goodsorderform=(GoodsOrderForm)form;
		String pageNo = goodsorderform.getPageNo();
		String searchKeyword = goodsorderform.getSearchKeyword();
		List<Goods> pagesearch = frontendservice.pageSearch(searchKeyword, Integer.parseInt(pageNo));
		pagesearch.stream().forEach(p -> System.out.println(p.toString()));	
		return mapping.findForward("vendingMachine");
	}
	
}
