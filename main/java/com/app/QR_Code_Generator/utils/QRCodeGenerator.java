package com.app.QR_Code_Generator.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.app.QR_Code_Generator.model.Student;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRCodeGenerator {
	
	public static void generateQRCode(Student student)throws WriterException, IOException{
		String qrCodePath = "A:\\QRCODE\\QRCODE";
		String qrCodeName = qrCodePath+student.getFirstName()+student.getId()+"-QRCODE.png";
		var qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(
												"ID: "+student.getId()+" \n"+
												"FirstName: "+student.getFirstName()+" \n"+
												"LastName: "+student.getLastName()+" \n"+
												"Email: "+student.getEmail()+" \n"+
												"mobile: "+student.getMobile(),
												BarcodeFormat.QR_CODE,300,300);
												
		Path path = FileSystems.getDefault().getPath(qrCodeName);
		MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
		
	}

}
