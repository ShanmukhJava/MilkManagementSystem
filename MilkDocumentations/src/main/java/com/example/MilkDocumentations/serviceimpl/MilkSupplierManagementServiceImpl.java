package com.example.MilkDocumentations.serviceimpl;

import java.io.File;
import java.io.IOException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.MilkDocumentations.configuration.FileUploadUtil;
import com.example.MilkDocumentations.entity.MilkSupplierManagement;
import com.example.MilkDocumentations.exceptions.ResourceNotFoundException;
import com.example.MilkDocumentations.repository.MilkSupplierManagementRepository;
import com.example.MilkDocumentations.service.MilkSupplierManagementService;

@Service
public class MilkSupplierManagementServiceImpl implements MilkSupplierManagementService {

	private static final Logger logger = LogManager.getLogger(MilkSupplierManagementServiceImpl.class);
	private static final long MAX_FILE_SIZE_BYTES = 5048576;
//	private static final String uploadDir = "C:\\Users\\shanmukha srinivas\\OneDrive\\Desktop\\MilkSupplierManagement";
	String uploadDir = "src/main/resources/static/images";

	private MilkSupplierManagementRepository MilkSupplierManagementRepository;

	public MilkSupplierManagementServiceImpl(MilkSupplierManagementRepository MilkSupplierManagementRepository) {
		this.MilkSupplierManagementRepository = MilkSupplierManagementRepository;
	}

	@Override
	public MilkSupplierManagement saveMilkSupplierManagement(MilkSupplierManagement MilkSupplierManagement, MultipartFile imageFile) {
		try {
			String fileName = StringUtils.cleanPath(imageFile.getOriginalFilename());
			logger.info("fileName: " + fileName);
			MilkSupplierManagement.setDocumentUrl("/images/" + fileName);
			MilkSupplierManagement.setPhotoName(fileName);
			MilkSupplierManagement.setDocumentType(MilkSupplierManagement.getDocumentType());
			MilkSupplierManagement.setMilkSupplier(MilkSupplierManagement.getMilkSupplier());

			MilkSupplierManagement savedMilkManagment = MilkSupplierManagementRepository.save(MilkSupplierManagement);

			FileUploadUtil.saveFile(uploadDir, fileName, imageFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return MilkSupplierManagementRepository.save(MilkSupplierManagement);
	}

	@Override
	public List<MilkSupplierManagement> findAllMilkSupplierManagements() {
		List<MilkSupplierManagement> listOfMilkSupplierManagements = MilkSupplierManagementRepository.findAll();
		return listOfMilkSupplierManagements.stream().filter(e -> e.isDeleted() == false).collect(Collectors.toList());

	}

	public void deleteById(Long id) {
		MilkSupplierManagementRepository.deleteById(id);
	}

	@Override
	public void updateMilkSupplierManagement(MilkSupplierManagement MilkSupplierManagement, long id) {

		try {

			Optional<MilkSupplierManagement> optinalMilkSupplierManagement = MilkSupplierManagementRepository.findById(id);
			if (!optinalMilkSupplierManagement.isEmpty()) {
				MilkSupplierManagement existingRecord = optinalMilkSupplierManagement.get();
				existingRecord.setDeleted(false);
				existingRecord.setDocumentNumber(MilkSupplierManagement.getDocumentNumber());

				existingRecord.setDocumentType(MilkSupplierManagement.getDocumentType());
				existingRecord.setStartDate(MilkSupplierManagement.getStartDate());
				existingRecord.setEndDate(MilkSupplierManagement.getEndDate());

				existingRecord.setMilkSupplier(MilkSupplierManagement.getMilkSupplier());
				existingRecord.setDocumentType(MilkSupplierManagement.getDocumentType());

				MilkSupplierManagementRepository.save(existingRecord);
			}

		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public MilkSupplierManagement findById(long id) {
		try {
			Optional<MilkSupplierManagement> optionalMilkManageement = MilkSupplierManagementRepository.findById(id);
			if (optionalMilkManageement.isPresent()) {
				MilkSupplierManagement management = optionalMilkManageement.get();
				return management;

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ResourceNotFoundException("Object with ID " + id + " not found");
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		try {
			Optional<MilkSupplierManagement> optionalMilkSupplierManagement = MilkSupplierManagementRepository.findById(id);
			if (optionalMilkSupplierManagement.isPresent()) {
				MilkSupplierManagement management = optionalMilkSupplierManagement.get();
				management.setDeleted(true);
				MilkSupplierManagementRepository.save(management);
			}
		} catch (Exception e) {
			throw new ResourceNotFoundException("Object with ID " + id + " not found");
		}

	}

	@Override
	public MilkSupplierManagement findMilkSupplierManagementById(Long id) {

		Optional<MilkSupplierManagement> optionalMilkSupplierManagement = MilkSupplierManagementRepository.findById(id);
		if (optionalMilkSupplierManagement.isPresent()) {
			MilkSupplierManagement management = optionalMilkSupplierManagement.get();
			return management;

		}
		return null;
	}

	@Override
	public List<MilkSupplierManagement> findAllUndeletedRecords() {
		return MilkSupplierManagementRepository.findByDeletedFalse();

	}

//	    @Override
//		public void updateMilkSupplierManagement(MilkSupplierManagement MilkSupplierManagement, MultipartFile document) {
//
//			
//			try {
//				String fileName = StringUtils.cleanPath(document.getOriginalFilename());
//				Optional<MilkSupplierManagement> optionalMilkSupplierManagement = MilkSupplierManagementRepository.findById(MilkSupplierManagement.getId());
//				if (optionalMilkSupplierManagement.isPresent()) {
//					MilkSupplierManagement management = optionalMilkSupplierManagement.get();
//					MilkSupplierManagement.setDocumentNumber(MilkSupplierManagement.getDocumentNumber());
//					MilkSupplierManagement.setDocumentType(MilkSupplierManagement.getDocumentType());
//					MilkSupplierManagement.setDocumentUrl(uploadDir + fileName);
//	                MilkSupplierManagement.setEndDate(MilkSupplierManagement.getEndDate());
//	                MilkSupplierManagement.setStartDate(MilkSupplierManagement.getStartDate());
//	                MilkSupplierManagement.setDeleted(false);
//	                MilkSupplierManagement.setMilkSupplier(MilkSupplierManagement.getMilkSupplier());
//	                FileUploadUtil.saveFile(uploadDir, fileName, document);
//	                MilkSupplierManagementRepository.save(management);
//				}			
//			} catch (IOException e) {
//				e.printStackTrace();
//			}	
//		}

}
