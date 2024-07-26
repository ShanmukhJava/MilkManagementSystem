package com.example.MilkDocumentations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MilkDocumentations.entity.DocumentType;

@Repository
public interface DocumentTypeRepository  extends JpaRepository<DocumentType , Long>{

}
