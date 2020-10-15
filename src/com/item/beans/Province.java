package com.item.beans;
/**
 * ʡ
 * @author wangqun
 *
 */
public class Province {
	private int provinceId;
	private String provinceName;

	public int getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public Province(int provinceId, String provinceName) {
		super();
		this.provinceId = provinceId;
		this.provinceName = provinceName;
	}

	public Province() {
		super();
	}

	public Province(String provinceName) {
		super();
		this.provinceName = provinceName;
	}

	@Override
	public String toString() {
		return "Province [provinceId=" + provinceId + ", provinceName=" + provinceName + "]";
	}

}
