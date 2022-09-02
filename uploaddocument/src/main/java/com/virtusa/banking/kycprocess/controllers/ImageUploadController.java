package com.virtusa.banking.kycprocess.controllers;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.virtusa.banking.kycprocess.models.ImageModel;
import com.virtusa.banking.kycprocess.services.ImageService;

import net.minidev.json.JSONObject;
@RestController
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = {"http://localhost:7070", "http://localhost:8787"}, 
//allowedHeaders = "*",methods = {RequestMethod.GET,RequestMethod.POST})

public class ImageUploadController {
	@Autowired
	ImageService imageService;
	@PostMapping("/upload")
	public ResponseEntity<Object> uplaodImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		System.out.println("Original Image Byte Size - " + file.getBytes().length);
		this.imageService.saveImage(file);
		 JSONObject entity = new JSONObject();
         entity.put("message", "Image Saved ....");
		return new ResponseEntity<Object>(entity, HttpStatus.OK);
	}
	@GetMapping(path = { "/get/{imageName}" })
	public ImageModel getImage(@PathVariable("imageName") String imageName) throws IOException {
		return this.imageService.getImageByName(imageName);
	}
	
}