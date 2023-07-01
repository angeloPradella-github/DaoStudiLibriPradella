package it.betacom.util;

import java.io.File;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.*;
import java.io.FileOutputStream;

public class PDFGenerator {

	public static void create(String filePath, String content) {
	    try {
	        Document document = new Document();

	        File file = new File(filePath);
	        FileOutputStream fos = new FileOutputStream(file);

	        PdfWriter.getInstance(document, fos);

	        document.open();
	        document.add(new Paragraph(content));
	        
	        document.close();
	        fos.close();

	        System.out.println("  ! Pdf creato correttamente: " + file.getAbsolutePath());

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
