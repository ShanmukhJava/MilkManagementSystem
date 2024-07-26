package com.example.MilkDocumentations.service;

import java.util.List;

import com.example.MilkDocumentations.entity.MilkSupplier;
import com.example.MilkDocumentations.pojos.MilkSupplierPojo;


public interface MilkSupplierService {

	public List<MilkSupplier> getAllSuppliers();
	
	 public MilkSupplier getSupplierById(long id);

	    public MilkSupplier saveSupplier(MilkSupplier supplier);

	    public void deleteSupplier(long id);
	
	
}
