package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Admin;

public interface AdminService 
{
	public List<Admin> getAllAdmin();
//	public Admin getAdminById(int id);
	public boolean deleteAdmin(int id);
	public Admin saveAdmin(Admin admin);
	public Admin updateAdmin(Admin newA , int id);
	public Admin getAdminByEmail(String inputEmail);

}
