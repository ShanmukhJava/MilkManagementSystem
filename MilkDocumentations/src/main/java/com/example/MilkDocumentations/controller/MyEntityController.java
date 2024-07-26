package com.example.MilkDocumentations.controller;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.MilkDocumentations.entity.MyEntity;
import com.example.MilkDocumentations.service.MyEntityService;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
@Controller
@RequestMapping("/entities")
public class MyEntityController {

    @Autowired
    private MyEntityService entityService;

    @GetMapping("/")
    public String listEntities(Model model) {
        model.addAttribute("entities", entityService.getAllEntitys());
        return "listEntities"; 
    }

    @GetMapping("/new")
    public String showAddEntityForm(Model model) {
        model.addAttribute("entity", new MyEntity());
        model.addAttribute("countryList", Arrays.asList("USA", "UK", "Canada", "Australia", "India"));
        return "addEntity";
    }

    @PostMapping("/add")
    public String addEntity(@ModelAttribute("entity") MyEntity entity, 
                            @RequestParam("profilePicture") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                // Get the file name
                String fileName = file.getOriginalFilename();
                
                // Define the path where the file will be saved
                String uploadDir = "C:\\Users\\shanmukha srinivas\\OneDrive\\Desktop\\";
                Path uploadPath = Paths.get(uploadDir);

                // If the directory doesn't exist, create it
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }

                // Create the full path including the file name
                Path filePath = uploadPath.resolve(fileName);

                // Save the file
                Files.copy(file.getInputStream(), filePath);

                // Set the file path in the entity
                entity.setProfilePicturePath(filePath.toString());

            } catch (IOException e) {
                e.printStackTrace();
                // Handle the exception (e.g., show an error message to the user)
            }
        }
        
        // Save the entity
        entityService.saveEntity(entity);
        
        return "redirect:/entities/";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        MyEntity entity = entityService.getEntityById(id);
        model.addAttribute("entity", entity);
        return "editEntity";
    }

    @PostMapping("/update/{id}")
    public String updateEntity(@PathVariable("id") Long id, @ModelAttribute MyEntity myEntity) {
        myEntity.setId(id);
        entityService.saveEntity(myEntity);
        return "redirect:/entities/";
    }

    @GetMapping("/delete/{id}")
    public String deleteEntity(@PathVariable("id") Long id) {
        entityService.deleteEntity(id);
        return "redirect:/entities/";
    }
}
