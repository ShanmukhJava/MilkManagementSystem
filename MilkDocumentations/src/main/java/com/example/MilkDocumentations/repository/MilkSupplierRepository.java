package com.example.MilkDocumentations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MilkDocumentations.entity.MilkSupplier;

@Repository
public interface MilkSupplierRepository extends JpaRepository<MilkSupplier, Long>{

}
