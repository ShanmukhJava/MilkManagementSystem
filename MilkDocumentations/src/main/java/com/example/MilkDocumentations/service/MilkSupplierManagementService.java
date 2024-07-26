package com.example.MilkDocumentations.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.MilkDocumentations.entity.MilkSupplierManagement;

public interface MilkSupplierManagementService {
	
	 MilkSupplierManagement saveMilkSupplierManagement(MilkSupplierManagement MilkSupplierManagement,MultipartFile document);
	    List<MilkSupplierManagement> findAllMilkSupplierManagements();
	    MilkSupplierManagement findById(long id);
	    void deleteById(Long id);
		public void updateMilkSupplierManagement(MilkSupplierManagement MilkSupplierManagement, long id);
		void delete(Long id);
		MilkSupplierManagement findMilkSupplierManagementById(Long id);
		List<MilkSupplierManagement> findAllUndeletedRecords();
		
		

}
