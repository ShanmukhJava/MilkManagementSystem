//package com.example.MilkDocumentations.controller;
//
//import java.util.List;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.example.MilkDocumentations.entity.MilkSupplier;
//import com.example.MilkDocumentations.repository.MilkSupplierRepository;
//import com.example.MilkDocumentations.service.MilkSupplierService;
//
//@Controller("/suppliers")
//public class MilkSupplierController {
//	
//	private static final Logger logger = LogManager.getLogger(MilkSupplierController.class);
//
//	@Autowired
//	private MilkSupplierService milkSupplierService;
//
//	@Autowired
//	private MilkSupplierRepository milkSupplierRepository;
//
//	@GetMapping("/list")
//	public String list(Model model) {
//		List<MilkSupplier> suppliers = milkSupplierRepository.findAll();
//		model.addAttribute("suppliers", suppliers);
//		return "list";
//	}
//
//	@GetMapping("/add")
//	public String showAddSupplierForm(Model model) {
//		model.addAttribute("milkSupplier", new MilkSupplier());
//		return "addSupplier";
//	}
//
//	@PostMapping("/add")
//	public String addSupplier(@ModelAttribute("milkSupplier") MilkSupplier milkSupplier) {
//		milkSupplierRepository.save(milkSupplier);
//		return "list";
//	}
//	@GetMapping("/all")
//	public ModelAndView home(Model model) {
//		ModelAndView modelAndView = new ModelAndView("index");
//		try {
//			List<MilkSupplier> suppliers = milkSupplierService.getAllSuppliers();
//			modelAndView.addObject("suppliers", suppliers);
//
//		} catch (Exception e) {
//			logger.error("Error fetching employees", e);
//
//		}
//		return modelAndView;
//
//	}
//
//}
