package com.item.dao;

import java.util.List;

import com.item.beans.Gclass;

public interface GclassDao {
	int getID(String name);
	List<Gclass> getList();
	String getName(int id);
	void addGclass(String name);
	void updateGclass(Gclass gclass);
	Gclass getGclass(int id);
	List<Gclass> getList(String likename);
	void removeGclass(int id);
}
