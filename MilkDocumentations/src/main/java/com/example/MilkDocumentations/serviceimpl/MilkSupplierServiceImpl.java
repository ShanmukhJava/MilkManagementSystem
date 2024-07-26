package com.example.MilkDocumentations.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MilkDocumentations.entity.MilkSupplier;
import com.example.MilkDocumentations.repository.MilkSupplierRepository;
import com.example.MilkDocumentations.service.MilkSupplierService;

@Service
public class MilkSupplierServiceImpl implements MilkSupplierService {
	
	
	private static final Logger logger = LoggerFactory.getLogger(MilkSupplierService.class);
	
	@Autowired
	private MilkSupplierRepository milkSupplierRepository; 

	@Override
	public List<MilkSupplier> getAllSuppliers() {
        logger.info("Fetching all milk suppliers");
        List<MilkSupplier> suppliers = milkSupplierRepository.findAll();
        logger.debug("Retrieved {} suppliers", suppliers.size());
        return suppliers;
    }

	@Override
    public MilkSupplier getSupplierById(long id) {
        logger.info("Fetching supplier with ID: {}", id);
        return milkSupplierRepository.findById(id).orElse(null);
    }

	@Override
    public MilkSupplier saveSupplier(MilkSupplier supplier) {
        logger.info("Saving new supplier: {}", supplier.getFirstName());
        return milkSupplierRepository.save(supplier);
    }

	@Override
    public void deleteSupplier(long id) {
        logger.info("Deleting supplier with ID: {}", id);
        milkSupplierRepository.deleteById(id);
    }

}
