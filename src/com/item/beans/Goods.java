package com.item.beans;
/**
 * ªıŒÔ¿‡
 * @author wangqun
 *
 */
public class Goods {
	private int goodId;
	private String goodName;
	private String price;
	private String miaoshu;
	private String gclassId;
	private String image;

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

	public Goods(int goodId, String goodName, String price, String miaoshu, String gclassId) {
		super();
		this.goodId = goodId;
		this.goodName = goodName;
		this.price = price;
		this.miaoshu = miaoshu;
		this.gclassId = gclassId;
	}

	public Goods() {
		super();
	}

	public Goods(String goodName, String price, String gclassId) {
		super();
		this.goodName = goodName;
		this.price = price;
		this.gclassId = gclassId;
	}

	public Goods(String goodName, String price, String miaoshu, String gclassId) {
		super();
		this.goodName = goodName;
		this.price = price;
		this.miaoshu = miaoshu;
		this.gclassId = gclassId;
	}

	@Override
	public String toString() {
		return "Goods [goodId=" + goodId + ", goodName=" + goodName + ", price=" + price + ", miaoshu=" + miaoshu
				+ ", gclassId=" + gclassId + ", image=" + image + "]";
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

}
