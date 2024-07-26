package com.example.MilkDocumentations.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.MilkDocumentations.entity.MilkSupplier;
import com.example.MilkDocumentations.repository.DocumentTypeRepository;
import com.example.MilkDocumentations.repository.MilkSupplierRepository;
import com.example.MilkDocumentations.service.MilkSupplierManagementService;
import com.example.MilkDocumentations.service.MilkSupplierService;

@Controller
public class HomeController {
 
	@Autowired
	private MilkSupplierRepository milkSupplierRepository;

	@Autowired
	private MilkSupplierService milkSupplierService;
	@Autowired
	private DocumentTypeRepository documentTypeRepository;
	
	@Autowired
	private  MilkSupplierManagementService managementService;
	
	
	private static final Logger logger = LogManager.getLogger(HomeController.class);

	
	
//	@GetMapping("/")
//	public ModelAndView home(Model model) {
//		ModelAndView modelAndView = new ModelAndView("index");
//		try {
//			List<MilkSupplier> suppliers = milkSupplierService.getAllSuppliers();
//			modelAndView.addObject("suppliers", suppliers);
//            logger.info("loading the index page");
//		} catch (Exception e) {
//			logger.error("Error fetching employees", e);
//
//		}
//		return modelAndView;
//
//	}
	
	  @GetMapping("/addSupplier")
    public String showAddSupplierForm(Model model) {
        try {
			model.addAttribute("milkSupplier", new MilkSupplier());
			logger.info("loading the Milk supplier adding page..");
			return "addSupplier";
		} catch (Exception e) {

			logger.info("Error while loading the adding Milk supplier page");
			e.printStackTrace();
		}
        return null;
    }

	  @PostMapping("/add")
	    public String addSupplier(MilkSupplier milkSupplier) {
	        try {
				milkSupplierRepository.save(milkSupplier);
				logger.info("Saving the Milk Supplier into database..");
				return "redirect:/";
			} catch (Exception e) {
				logger.error("Error while adding the Supplier into database..!!");
				e.printStackTrace();
			}
	        return null;
	    }
//	  @GetMapping("/addMilkManagement")
//	    public String showAddMilkManagementForm(Model model) {
//		  model.addAttribute("MilkManagement", new MilkManagement());
//		  List<MilkSupplier> milkSuppliers = milkSupplierService.getAllSuppliers();
//		  model.addAttribute("MilkSuppliers", milkSuppliers);
//		  List<DocumentType> documentTypes = documentTypeRepository.findAll();
//		  model.addAttribute("DocumentTypes", documentTypes);
//		  return "addMilkManagement"; 
//	    }
//	  @PostMapping("/saveMilkManagement")
//		public String saveMilkManagement(@ModelAttribute("milkManagement") MilkManagement milkManagement,
//				@RequestParam("document") MultipartFile document, Model model) throws IOException {
//			managementService.saveMilkManagement(milkManagement, document);
//			return "redirect:/milkManagementList";
//
//		}
 
}
