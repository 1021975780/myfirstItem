package com.item.beans;
/**
 * µØÇø
 * @author wangqun
 *
 */
public class District {
	private int districtId;
	private String districtName;

	public int getDistrictId() {
		return districtId;
	}

	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public District(int districtId, String districtName) {
		super();
		this.districtId = districtId;
		this.districtName = districtName;
	}

	public District() {
		super();
	}

	public District(String districtName) {
		super();
		this.districtName = districtName;
	}

	@Override
	public String toString() {
		return "District [districtId=" + districtId + ", districtName=" + districtName + "]";
	}

}
