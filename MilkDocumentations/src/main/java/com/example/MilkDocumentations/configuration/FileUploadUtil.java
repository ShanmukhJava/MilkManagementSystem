package com.example.MilkDocumentations.configuration;

import java.io.IOException;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import com.example.MilkDocumentations.controller.HomeController;

public class FileUploadUtil {

	
	private static final Logger logger = LogManager.getLogger(FileUploadUtil.class);
public static void saveFile(String uploadDir, String fileName, MultipartFile multipartFile) throws IOException {
		
	
		Path uploadPath = Paths.get(uploadDir);

		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}

		try (InputStream inputStream = multipartFile.getInputStream()) {
			logger.info("saving the image file...");
			Path filePath = uploadPath.resolve(fileName);
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException ioe) {
			throw new IOException("Could not save image file: " + fileName, ioe);
		}
	}
	
	
}
