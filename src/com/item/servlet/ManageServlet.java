package com.item.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.item.beans.Gclass;
import com.item.beans.GclassGood;
import com.item.beans.Goods;
import com.item.dao.GclassDao;
import com.item.dao.GoodsDao;
import com.item.dao.impl.GclassDaoimpl;
import com.item.dao.impl.GoodsDaoimpl;
import com.item.upload.Upload;
import com.item.utils.PageUtils;
import com.item.utils.Simple;
/**
 * 物品管理页面
 * @author wangqun
 *
 */
public class ManageServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = req.getParameter("method");
		try {
			Method method2 = this.getClass().getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
			method2.invoke(this, req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 利用反射添加物品，需要上传下载。
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("添加");
		GoodsDao dao = new GoodsDaoimpl();
		Map<?, ?> maps=null;
		try {
			maps = Upload.getItemMaps(req,true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Goods good = new Goods();
		Set<?> keySet = maps.keySet();
		
		for (Object key : keySet) {
			try {
				Field field = good.getClass().getDeclaredField((String) key);
				field.setAccessible(true);
				field.set(good, maps.get(key));
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		dao.addGoods(good);
		resp.sendRedirect(req.getContextPath()+"/manageServlet?method=showKind");

	}
	/**
	 * 通过物品名字查找，应该用id合理一些
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("查找");
		String goodName = req.getParameter("goodName");
		GoodsDaoimpl dao = new GoodsDaoimpl();
		List<Goods> goods = dao.getGoods(goodName);
		ObjectMapper om =new ObjectMapper();
		String json_goods = om.writeValueAsString(goods);
		resp.getWriter().print(json_goods);
	}
	/**
	 * 佛了
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void searchInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("详细信息查找");
		String goodName = req.getParameter("goodName");
		GoodsDaoimpl dao = new GoodsDaoimpl();
		GclassDao dao2 = new GclassDaoimpl();
		//GclassGood gclassGood = new GclassGood();
		List<Goods> goods = dao.getGoods(goodName);
		int index=0;
		List<GclassGood> likeGoods = new ArrayList<>();
		for (Goods goods2 : goods) {
			GclassGood gclassGood = new GclassGood();
			String gclassId = goods2.getGclassId();
			String name = dao2.getName(Integer.parseInt(gclassId));
			gclassGood.setGclassId(goods2.getGclassId());
			gclassGood.setGclassName(name);
			gclassGood.setGoodId(goods2.getGoodId());
			gclassGood.setMiaoshu(goods2.getMiaoshu());
			gclassGood.setGoodName(goods2.getGoodName());
			gclassGood.setPrice(goods2.getPrice());
			if (goods2.getImage()!=null) {
				String get_image=req.getContextPath()+"/image/"+goods2.getImage().substring(goods2.getImage().lastIndexOf("\\")+1);
				gclassGood.setImage(get_image);
			}
			likeGoods.add(index,gclassGood);
			index++;
		}
		System.out.println(likeGoods);
		PageUtils.paging(11,5, req, resp);
		req.setAttribute("list", likeGoods);
		req.getRequestDispatcher("/admin/page/page/goods/list.jsp").forward(req, resp);
	}
	/**
	 * 通过物品id删除物品信息
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GoodsDao dao = new GoodsDaoimpl();
		String id = req.getParameter("goodID");
		dao.deleteGood(Integer.parseInt(id));
		System.out.println("删除成功");
	}
	/**
	 * 添加物品的时候展现物品种类以便提供选择
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showKind(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("显示种类");
		GclassDao dao = new GclassDaoimpl();
		List<Gclass> list = dao.getList();
		req.setAttribute("list", list);
		req.getRequestDispatcher("/admin/page/page/goods/add.jsp").forward(req, resp);
	}
	/**
	 * 修改的中间跳转页面
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void forwordModify(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String goodId = req.getParameter("goodId");
		GoodsDao dao = new GoodsDaoimpl();
		Goods good = dao.getGood(Integer.parseInt(goodId));
		req.setAttribute("goods", good);
		req.getRequestDispatcher("/admin/page/page/goods/modify.jsp").forward(req, resp);
	}
	/**
	 * 通过id修改价格
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void modifyPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String price = req.getParameter("price");
		GoodsDao dao = new GoodsDaoimpl();
		dao.updatePrice(Integer.parseInt(id), price);
		resp.sendRedirect(req.getContextPath()+"/admin/page/page/goods/table.jsp");
	}
	/**
	 * 物品详细信息页面，显示所有物品，后来做的 ，之前没给list页面
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GoodsDaoimpl dao = new GoodsDaoimpl();
		GclassDao dao2 = new GclassDaoimpl();
		//GclassGood gclassGood = new GclassGood();
		List<Goods> goods = dao.getGoods("");
		int index=0;
		List<GclassGood> likeGoods = new ArrayList<>();
		for (Goods goods2 : goods) {
			GclassGood gclassGood = new GclassGood();
			String gclassId = goods2.getGclassId();
			String name = dao2.getName(Integer.parseInt(gclassId));
			gclassGood.setGclassId(goods2.getGclassId());
			gclassGood.setGclassName(name);
			gclassGood.setGoodId(goods2.getGoodId());
			gclassGood.setMiaoshu(goods2.getMiaoshu());
			gclassGood.setGoodName(goods2.getGoodName());
			gclassGood.setPrice(goods2.getPrice());
			if (goods2.getImage()!=null) {
				String get_image=req.getContextPath()+"/image/"+goods2.getImage().substring(goods2.getImage().lastIndexOf("\\")+1);
				gclassGood.setImage(get_image);
			}
			likeGoods.add(index,gclassGood);
			index++;
		}
		req.setAttribute("list", likeGoods);
		req.getRequestDispatcher("/admin/page/page/goods/list.jsp").forward(req, resp);
	}
	/**
	 * 展现火的商品信息，用在用户交互的时候，应该修改，随便写写
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showHot(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GoodsDaoimpl dao = new GoodsDaoimpl();
		GclassDao dao2 = new GclassDaoimpl();
		List<Goods> goods = dao.getGoods("");
		int index=0;
		List<GclassGood> likeGoods = new ArrayList<>();
		for (Goods goods2 : goods) {
			GclassGood gclassGood = new GclassGood();
			String gclassId = goods2.getGclassId();
			String name = dao2.getName(Integer.parseInt(gclassId));
			gclassGood.setGclassId(goods2.getGclassId());
			gclassGood.setGclassName(name);
			gclassGood.setGoodId(goods2.getGoodId());
			gclassGood.setMiaoshu(goods2.getMiaoshu());
			gclassGood.setGoodName(goods2.getGoodName());
			gclassGood.setPrice(goods2.getPrice());
			if (goods2.getImage()!=null) {
				String get_image=req.getContextPath()+"/image/"+goods2.getImage().substring(goods2.getImage().lastIndexOf("\\")+1);
				gclassGood.setImage(get_image);
			}
			likeGoods.add(index,gclassGood);
			index++;
		}
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(likeGoods);
		resp.getWriter().print(json);
	}
	/**
	 * 跳转到物品信息的页面，通过id，缺少一个物品详细信息的数据表，随便写写
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void forwardToInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GoodsDao dao = new GoodsDaoimpl();
		String id = req.getParameter("id");
		Goods good = dao.getGood(Integer.parseInt(id));
		if (good.getImage()!=null) {
			String get_image=req.getContextPath()+"/image/"+good.getImage().substring(good.getImage().lastIndexOf("\\")+1);
			good.setImage(get_image);
		}
		req.setAttribute("good", good);
		req.getRequestDispatcher("/user/goodsInfo.jsp").forward(req, resp);
	}
	/**
	 * 通过id往购物车中添加商品，放入session
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addToCar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		GoodsDao dao = new GoodsDaoimpl();
		HttpSession session = req.getSession();
		List<Goods> shoppingCar = (List<Goods>) session.getAttribute("shoppingCar");
		Map<Integer,Integer> sumPrice = (Map<Integer,Integer>) session.getAttribute("sumPrice");
		if (shoppingCar==null) {
			shoppingCar = new ArrayList<>();
			sumPrice=new HashMap<>();
		}
		Integer gId=Integer.parseInt(id);
		System.out.println(gId);
		Goods good = dao.getGood(gId);
		if (good.getImage()!=null) {
			String get_image=req.getContextPath()+"/image/"+good.getImage().substring(good.getImage().lastIndexOf("\\")+1);
			good.setImage(get_image);
		} 
		if (sumPrice.containsKey(gId)) {
			sumPrice.replace(gId, sumPrice.get(gId)+1);
		}
		else {
			sumPrice.put(Integer.parseInt(id),1);
			shoppingCar.add(good);
		}
		System.out.println(shoppingCar);
		System.out.println(sumPrice);
		session.setAttribute("sumPrice", sumPrice);
		session.setAttribute("shoppingCar", shoppingCar);
		int totalPrice=0;
		for (Goods goods : shoppingCar) {
			totalPrice+=Integer.parseInt(goods.getPrice())*sumPrice.get(goods.getGoodId());
		}
		session.setAttribute("totalPrice", totalPrice);
		resp.sendRedirect(req.getContextPath()+"/user/shoppingcar.jsp");
	}
	/**
	 * 从购物车中移除物品，移除session，并且通过ajax返回商品总价格
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void removeFromCar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		List<Goods> shoppingCar  = (List<Goods>) session.getAttribute("shoppingCar");
		Map<Integer,Integer> sumPrice = (Map<Integer,Integer>) session.getAttribute("sumPrice");
		String id = req.getParameter("id");
		System.out.println(shoppingCar);
		Goods good =null;
		for (Goods goods : shoppingCar) {
			if (goods.getGoodId()==Integer.parseInt(id)) {
				good=goods;
			}
		}
		shoppingCar.remove(good);
		sumPrice.remove(Integer.parseInt(id));
		int totalPrice=0;
		for (Goods goods : shoppingCar) {
			totalPrice+=Integer.parseInt(goods.getPrice())*sumPrice.get(goods.getGoodId());
		}
		resp.getWriter().print("{\"totalPrice\":\""+totalPrice+"\"}");
	}
	/**
	 * 返回Json的价格对象，物品的增加和删除，session中物品的移除
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void changePrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sum = req.getParameter("sum");
		String id = req.getParameter("id");
		Integer gId=Integer.parseInt(id);
		Integer gSum=Integer.parseInt(sum);
		HttpSession session = req.getSession();
		List<Goods> shoppingCar = (List<Goods>) session.getAttribute("shoppingCar");
		Map<Integer,Integer> sumMap = (Map<Integer,Integer>) session.getAttribute("sumPrice");
		Goods good = null;
		for (Goods goods : shoppingCar) {
			if (goods.getGoodId()==gId) {
				good=goods;
			}
		}
		int totalPrice=0;
		if (gSum!=0) {
			sumMap.replace(gId, gSum);
		}
		else {
			shoppingCar.remove(good);
			sumMap.remove(gId);
		}
		for (Goods goods : shoppingCar) {
			totalPrice+=Integer.parseInt(goods.getPrice())*sumMap.get(goods.getGoodId());
		}
		session.setAttribute("shoppingCar", shoppingCar);
		session.setAttribute("sumPrice", sumMap);
		session.setAttribute("totalPrice", totalPrice);
		resp.getWriter().print("{\"totalPrice\":\""+totalPrice+"\"}");
	}
}
