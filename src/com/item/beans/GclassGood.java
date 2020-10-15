package com.item.beans;
/**
 * 类别和物品的合成类
 * 多了一个类别名字段
 * @author wangqun
 *
 */
public class GclassGood {
	private int goodId;
	private String goodName;
	private String price;
	private String miaoshu;
	private String gclassId;
	private String image;
	private String gclassName;
	public int getGoodId() {
		return goodId;
	}
	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getMiaoshu() {
		return miaoshu;
	}
	public void setMiaoshu(String miaoshu) {
		this.miaoshu = miaoshu;
	}
	public String getGclassId() {
		return gclassId;
	}
	public void setGclassId(String gclassId) {
		this.gclassId = gclassId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getGclassName() {
		return gclassName;
	}
	public void setGclassName(String gclassName) {
		this.gclassName = gclassName;
	}
	@Override
	public String toString() {
		return "GclassGood [goodId=" + goodId + ", goodName=" + goodName + ", price=" + price + ", miaoshu=" + miaoshu
				+ ", gclassId=" + gclassId + ", image=" + image + ", gclassName=" + gclassName + "]";
	}
	
}

