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
 * ��Ʒ����ҳ��
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
	 * ���÷��������Ʒ����Ҫ�ϴ����ء�
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("���");
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
	 * ͨ����Ʒ���ֲ��ң�Ӧ����id����һЩ
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("����");
		String goodName = req.getParameter("goodName");
		GoodsDaoimpl dao = new GoodsDaoimpl();
		List<Goods> goods = dao.getGoods(goodName);
		ObjectMapper om =new ObjectMapper();
		String json_goods = om.writeValueAsString(goods);
		resp.getWriter().print(json_goods);
	}
	/**
	 * ����
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void searchInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("��ϸ��Ϣ����");
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
	 * ͨ����Ʒidɾ����Ʒ��Ϣ
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GoodsDao dao = new GoodsDaoimpl();
		String id = req.getParameter("goodID");
		dao.deleteGood(Integer.parseInt(id));
		System.out.println("ɾ���ɹ�");
	}
	/**
	 * �����Ʒ��ʱ��չ����Ʒ�����Ա��ṩѡ��
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showKind(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("��ʾ����");
		GclassDao dao = new GclassDaoimpl();
		List<Gclass> list = dao.getList();
		req.setAttribute("list", list);
		req.getRequestDispatcher("/admin/page/page/goods/add.jsp").forward(req, resp);
	}
	/**
	 * �޸ĵ��м���תҳ��
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
	 * ͨ��id�޸ļ۸�
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
	 * ��Ʒ��ϸ��Ϣҳ�棬��ʾ������Ʒ���������� ��֮ǰû��listҳ��
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
	 * չ�ֻ����Ʒ��Ϣ�������û�������ʱ��Ӧ���޸ģ����дд
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
	 * ��ת����Ʒ��Ϣ��ҳ�棬ͨ��id��ȱ��һ����Ʒ��ϸ��Ϣ�����ݱ����дд
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
	 * ͨ��id�����ﳵ�������Ʒ������session
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
	 * �ӹ��ﳵ���Ƴ���Ʒ���Ƴ�session������ͨ��ajax������Ʒ�ܼ۸�
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
	 * ����Json�ļ۸������Ʒ�����Ӻ�ɾ����session����Ʒ���Ƴ�
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
