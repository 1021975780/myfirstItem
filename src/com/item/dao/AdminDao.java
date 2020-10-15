package com.item.dao;

import com.item.beans.Admin;

public interface AdminDao {
	Admin getAdmin(String email);
	void updateInfo(Admin admin);
	void addAdmin(Admin admin);
	void removeAdmin(int id);
	void resetPwd(int id);
}
