package com.example.MilkDocumentations.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.MilkDocumentations.entity.MilkSupplierManagement;
import com.example.MilkDocumentations.repository.DocumentTypeRepository;
import com.example.MilkDocumentations.repository.MilkSupplierManagementRepository;
import com.example.MilkDocumentations.repository.MilkSupplierRepository;
import com.example.MilkDocumentations.service.MilkSupplierManagementService;

@Controller
@RequestMapping("/milkManagement")
public class ManagementController {

	@Autowired
	 private MilkSupplierManagementService service;
	@Autowired 
	private MilkSupplierRepository supplierRepo;
	@Autowired    
	private DocumentTypeRepository docTypeRepo;
	@Autowired    
	private MilkSupplierManagementRepository managementRepository;

	   

	    @PostMapping("/deleteMilkManagement/{id}")
	    public ResponseEntity<String>  deleteMilkManagement(@PathVariable Long id) {
	    	Optional<MilkSupplierManagement> optional  = managementRepository.findById(id);
	    	if (optional.isPresent()) {
				MilkSupplierManagement management = optional.get();
				
			}
	    	service.delete(id);
	        return ResponseEntity.ok("deleted successfully");
	    }
}
