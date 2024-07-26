package com.example.MilkDocumentations.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MilkDocumentations.entity.MyEntity;
import com.example.MilkDocumentations.repository.MyEntityRepository;

@Service
public class MyEntityService {
	
	@Autowired
	
    private MyEntityRepository repository;
	
	 public List<MyEntity> getAllEntitys() {
	        return repository.findAll();
	    }

	    public MyEntity getEntityById(Long id) {
	        return repository.findById(id).orElse(null);
	    }

	    public MyEntity saveEntity(MyEntity entity) {
	        return repository.save(entity);
	    }

	    public void deleteEntity(Long id) {
	        repository.deleteById(id);
	    }
	

}
