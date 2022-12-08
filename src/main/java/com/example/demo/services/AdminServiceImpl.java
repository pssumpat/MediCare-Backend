package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Admin;
import com.example.demo.repos.AdminRepo;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepo repo;
	
	@Override
	public List<Admin> getAllAdmin() {
		return repo.findAll();
	}

//	@Override
//	public Admin getAdminById(int id) 
//	{
//		if(repo.findById(id).isPresent())
//		{
//			return repo.findById(id).get();
//		}
//		return null;
//	}
	
	@Override
	public Admin getAdminByEmail(String inputEmail) 
	{
		Admin admin = repo.findByEmail(inputEmail);
		if(admin!=null)
		{
			return repo.findByEmail(inputEmail);
		}
		return null;
	}

	@Override
	public boolean deleteAdmin(int id) 
	{
		if(repo.findById(id).isPresent())
		{
			repo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Admin saveAdmin(Admin admin) {
		repo.save(admin);
		return admin;
	}

	@Override
	public Admin updateAdmin(Admin newA, int id) {
		Admin oldA = repo.findById(id).get();
		oldA.setEmail(newA.getEmail());
		oldA.setPassword(newA.getPassword());
		repo.save(oldA);
		return oldA;
	}



}
