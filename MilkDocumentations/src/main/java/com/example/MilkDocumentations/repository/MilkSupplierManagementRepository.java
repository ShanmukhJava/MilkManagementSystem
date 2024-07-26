package com.example.MilkDocumentations.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MilkDocumentations.entity.MilkSupplierManagement;

@Repository
public interface MilkSupplierManagementRepository extends JpaRepository<MilkSupplierManagement , Long>{

	
	List<MilkSupplierManagement> findByDeletedFalse();
	
}
