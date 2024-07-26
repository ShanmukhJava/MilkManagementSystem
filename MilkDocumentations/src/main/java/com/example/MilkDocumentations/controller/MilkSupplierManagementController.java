package com.example.MilkDocumentations.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.MilkDocumentations.configuration.FileUploadUtil;
import com.example.MilkDocumentations.entity.DocumentType;
import com.example.MilkDocumentations.entity.MilkSupplierManagement;
import com.example.MilkDocumentations.entity.MilkSupplier;
import com.example.MilkDocumentations.repository.DocumentTypeRepository;
import com.example.MilkDocumentations.repository.MilkSupplierManagementRepository;
import com.example.MilkDocumentations.repository.MilkSupplierManagementRepository;
import com.example.MilkDocumentations.repository.MilkSupplierRepository;
import com.example.MilkDocumentations.service.MilkSupplierManagementService;
import com.example.MilkDocumentations.service.MilkSupplierManagementService;
import com.example.MilkDocumentations.service.MilkSupplierService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class MilkSupplierManagementController {

	private static final long MAX_FILE_SIZE_BYTES = 2048576; // 1MB in bytes
	private static final String uploadDir = "C:\\Users\\shanmukha srinivas\\OneDrive\\Desktop\\employees";
	private static final Logger logger = LogManager.getLogger(MilkSupplierManagementController.class);

	@Autowired
	private MilkSupplierManagementRepository MilkSupplierManagementRepository;
	@Autowired
	private MilkSupplierService milkSupplierService;
	@Autowired
	private DocumentTypeRepository documentTypeRepository;
	@Autowired
	private MilkSupplierRepository milkSupplierRepository;

	@Autowired
	private MilkSupplierManagementService MilkSupplierManagementService;

//	@GetMapping("/hi")
//	public String getList() {
//		return "MilkSupplierManagementList";
//	}

	@GetMapping("/addMilkSupplierManagement")
	public ModelAndView showAddMilkSupplierManagementForm(
			@ModelAttribute("MilkSupplierManagement") MilkSupplierManagement MilkSupplierManagement) {
		try {
			logger.info("Loading the MilkManagment adding page");
			ModelAndView modelAndView = new ModelAndView("addMilkSupplierManagement");

			List<MilkSupplier> milkSuppliers = milkSupplierRepository.findAll();
			List<DocumentType> documentTypes = documentTypeRepository.findAll();
			List<MilkSupplierManagement> MilkSupplierManagements = MilkSupplierManagementRepository.findAll();

			modelAndView.addObject("milkSuppliers", milkSuppliers);
			modelAndView.addObject("documentTypes", documentTypes);
			modelAndView.addObject("MilkSupplierManagements", MilkSupplierManagements);
			logger.info("About to redirect to the the MilkManagment adding page");
			return modelAndView;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Somethings wrong with the add Milk Management page");
			e.printStackTrace();
		}

		return null;
	}

	@PostMapping("/saveMilkSupplierManagement")
	public String saveMilkSupplierManagement(
			@ModelAttribute("MilkSupplierManagement") MilkSupplierManagement MilkSupplierManagement,
			@RequestParam("document") MultipartFile document, Model model) throws IOException {
		try {
			logger.info("Saving the milk management of document number: " + MilkSupplierManagement.getDocumentNumber()
					+ " into database");
			MilkSupplierManagementService.saveMilkSupplierManagement(MilkSupplierManagement, document);
			logger.info("Redirecting back to  the MilkSupplierManagementList");
			return "redirect:/MilkSupplierManagementList";

		} catch (Exception e) {
			logger.error("Somethings wrong happened while saving MilkSupplierManagement object with document id : "
					+ MilkSupplierManagement.getDocumentNumber());
			e.printStackTrace();
			return null;

		}

	}

	@GetMapping("/MilkSupplierManagementList")
	public String viewMilkSupplierManagementList(Model model) {
		try {
			logger.info("Started loading the Milk Management List page");
			List<MilkSupplierManagement> MilkSupplierManagements = MilkSupplierManagementService
					.findAllUndeletedRecords();
			model.addAttribute("milkManagements", MilkSupplierManagements);
			logger.info("Viewing the Milk Management List page");
			return "milkManagementList";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("/viewMilkSupplierManagement/{id}")
	public String viewMilkSupplierManagement(@PathVariable("id") Long id, Model model) {
		try {

			MilkSupplierManagement MilkSupplierManagement = MilkSupplierManagementService.findById(id);
			model.addAttribute("MilkSupplierManagement", MilkSupplierManagement);
			logger.info("Viewing the milk management which record having id :" + id);
			return "viewMilkSupplierManagement";
		} catch (Exception e) {
			logger.info("Something's wrong with viewing the milk management which record having id :" + id);
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("/editMilkSupplierManagement/{id}")
	public String editMilkSupplierManagement(@PathVariable long id, Model model) {
		try {
			logger.info("Started loading the Edit Milk management record having id :" + id);
			MilkSupplierManagement MilkSupplierManagement = MilkSupplierManagementService.findById(id);

			if (MilkSupplierManagement == null) {
				return "redirect:/MilkSupplierManagementList";
			}

			List<MilkSupplier> milkSuppliers = milkSupplierRepository.findAll();
			List<DocumentType> documentTypes = documentTypeRepository.findAll();
			model.addAttribute("milkSuppliers", milkSuppliers);
			model.addAttribute("documentTypes", documentTypes);
			model.addAttribute("milkManagement", MilkSupplierManagement);
			logger.info("Viewing Edit Milk management record having id :" + id);
			return "editMilkManagement";
		} catch (Exception e) {
			logger.info("Something's wrong with the Edit Milk management record having id :" + id);
			e.printStackTrace();
		}
		return null;
	}

	@PostMapping("/updateMilkSupplierManagement/{id}")
	public String updateMilkSupplierManagement(@PathVariable long id,
			@ModelAttribute("MilkSupplierManagement") MilkSupplierManagement MilkSupplierManagement,
			@RequestParam(value = "document", required = false) MultipartFile document) throws IOException {
		try {
			logger.info("Received Edit request for MilkSupplierManagement with ID: " + id);
			logger.info("Started updating the Existing Milk management record having id :" + id);
			if (MilkSupplierManagement != null) {

				if (document != null && !document.isEmpty()) {

					String fileName = StringUtils.cleanPath(document.getOriginalFilename());
					String fullPath = uploadDir + File.separator + fileName;
					MilkSupplierManagement.setDocumentUrl(fullPath);
					MilkSupplierManagement.setPhotoName(fileName);
					FileUploadUtil.saveFile(uploadDir, fileName, document);
				} else {
					logger.info("image not given while updating so updating only data");
				}

				MilkSupplierManagementService.updateMilkSupplierManagement(MilkSupplierManagement, id);
				logger.info("Redirecting back to loading the Milk management list which record having id :" + id);
				return "redirect:/MilkSupplierManagementList";
			} else {
				throw new IllegalArgumentException("MilkSupplierManagement object or its ID is null");
			}
		} catch (IOException e) {

			logger.info("Started loading the Edit Milk management page which record having id :" + id);
			e.printStackTrace();
		}
		return null;
	}

//	@GetMapping("/confirmDelete/{id}")
//	public String showConfirmationPage(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
//		try {
//			logger.info("Delete confirmation for record with id :" + id);
//			MilkSupplierManagement MilkSupplierManagement = MilkSupplierManagementService.findMilkSupplierManagementById(id);
//			model.addAttribute("MilkSupplierManagement", MilkSupplierManagement);
//			return "deleteConfirmation";
//		} catch (Exception e) {
//			logger.info("Error encountered while confirmation of deletion record with record : " + id);
//			e.printStackTrace();
//		}
//		return null;
//	}

	@PostMapping("/deleteMilkSupplierManagement/{id}")
	public String deleteMilkSupplierManagement(@PathVariable long id) {
		try {
			MilkSupplierManagementService.delete(id);
			logger.info("Deleting record with id :" + id);
			logger.info("Redirecting back to Milk Management List");
			return "redirect:/MilkSupplierManagementList";

		} catch (Exception e) {
			logger.info("Error encountered while Deleting record with id :" + id);
			e.printStackTrace();
		}
		return null;
	}

//	@GetMapping("/MilkSupplierManagement/photo/{photoName}")
//	public void getEmployeePhoto(@PathVariable String photoName, HttpServletResponse response) throws IOException {
//		String filePath = "C:/Users/shanmukha srinivas/OneDrive/Desktop/MilkSupplierManagement/" + photoName;
//		File file = new File(filePath);
//		if (!file.exists()) {
//			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
//			return;
//		}
//		String contentType = Files.probeContentType(file.toPath());
//		if (contentType == null || (!contentType.equals("image/jpeg") && !contentType.equals("image/png"))) {
//			response.setStatus(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
//			return;
//		}
//		response.setContentType(contentType);
//		try (FileInputStream inputStream = new FileInputStream(file);
//				OutputStream outputStream = response.getOutputStream()) {
//			byte[] bytes = new byte[1024];
//			int bytesRead;
//			while ((bytesRead = inputStream.read(bytes)) != -1) {
//				outputStream.write(bytes, 0, bytesRead);
//			}
//		}
//	}

}
