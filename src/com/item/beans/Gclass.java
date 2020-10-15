package com.item.beans;
/**
 * Àà±ð
 * @author wangqun
 *
 */
public class Gclass {
	private int gclassId;
	private String name;

	public int getGclassId() {
		return gclassId;
	}

	public void setGclassId(int gclassId) {
		this.gclassId = gclassId;
	}

	@Override
	public String toString() {
		return "Gclass [gclassId=" + gclassId + ", name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gclass(int gclassId, String name) {
		super();
		this.gclassId = gclassId;
		this.name = name;
	}

	public Gclass(String name) {
		super();
		this.name = name;
	}

	public Gclass() {
		super();
	}

}
