package com.example.MilkDocumentations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MilkDocumentations.entity.MyEntity;
@Repository
public interface MyEntityRepository extends JpaRepository<MyEntity, Long>{

}
