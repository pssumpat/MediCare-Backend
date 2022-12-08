package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Admin;
import com.example.demo.services.AdminService;

@CrossOrigin(origins ={"http://localhost:4200","http://localhost:49335"})
@RestController
@RequestMapping("/api/admin")
public class AdminController 
{
	@Autowired
	AdminService service;
	
	@GetMapping("")
	public ResponseEntity<Object> getAdmin()
	{
		List<Admin> resp = service.getAllAdmin();
		return new ResponseEntity<>(resp,HttpStatus.CREATED);
	}
	
//	@GetMapping("/{adminId}")
//	public ResponseEntity<Object> getAdminById(@PathVariable("adminId") int id)
//	{
//		Admin resp = service.getAdminById(id);
//		return new ResponseEntity<>(resp,HttpStatus.CREATED);
//	}
//	
	@GetMapping("/{adminEmail}")
	public ResponseEntity<Object> getAdminByEmail(@PathVariable("adminEmail") String inputEmail)
	{
		Admin resp = service.getAdminByEmail(inputEmail);
		return new ResponseEntity<>(resp,HttpStatus.CREATED);
	}
	
	@PostMapping("")
	public ResponseEntity<Object> saveAdmin(@RequestBody Admin a)
	{
		Admin resp = service.saveAdmin(a);
		return new ResponseEntity<>(resp,HttpStatus.CREATED);
	}
	
	@PutMapping("/{adminId}")
	public ResponseEntity<Object> updateAdmin(@PathVariable("adminId") int id, @RequestBody Admin newA)
	{
		Admin resp = service.updateAdmin(newA, id);
		return new ResponseEntity<>(resp, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{adminId}")
	public ResponseEntity<Object> deleteAdmin(@PathVariable("adminId") int id)
	{
		boolean resp = service.deleteAdmin(id);
		return new ResponseEntity<>(resp, HttpStatus.CREATED);
	}

}
