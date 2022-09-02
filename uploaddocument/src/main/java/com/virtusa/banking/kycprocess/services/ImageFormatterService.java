package com.virtusa.banking.kycprocess.services;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class ImageFormatterService {
    @Autowired 
	private ImageService imageService;
	
    public void convertImageToPdf(String imageName) throws IOException, DocumentException
    {
    	System.out.print(imageName);
    	String[] name=imageName.split("\\.");
    	InputStream in = new ByteArrayInputStream(this.imageService.getImageByNameToArray(imageName));
		BufferedImage bImageFromConvert = ImageIO.read(in);
		
		Document document = new Document();

        PdfWriter writer = PdfWriter.getInstance(document,
                               new FileOutputStream(name[0]+".pdf"));
        document.open();

        PdfContentByte pdfCB = new PdfContentByte(writer);
        Image image = Image.getInstance(pdfCB, bImageFromConvert, 1);
        document.add(image);
    	document.close();
    }
}
