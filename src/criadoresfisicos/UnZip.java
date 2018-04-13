package criadoresfisicos;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.swing.JOptionPane;

public class UnZip {
    private StringBuilder extractedFiles = new StringBuilder();
		
    public static void main(String[] args) {
		new UnZip().unZipIt("C:\\workspace\\cria-front\\projetos\\cadastro-simples.zip", "C:\\workspace\\cria-front\\cadastro-simples");
	}
    
    public void unZipIt(String zipFile, String outputFolder){

     byte[] buffer = new byte[1024];
    	
     try{
    		
    	//create output directory is not exists
    	File folder = new File(outputFolder);
    	if(!folder.exists()){
    		folder.mkdir();
    	}
    		
    	//get the zip file content
    	ZipInputStream zis = 
    		new ZipInputStream(new FileInputStream(zipFile));
    	//get the zipped file list entry
    	ZipEntry ze = zis.getNextEntry();
    		
    	while(ze!=null){
    			
			String fileName = ze.getName();
			String nome;
			nome = fileName;
			File newFile = new File(nome);
			        
			extractedFiles.append("\nfile unzip : "+ newFile.getAbsoluteFile());
			        
			if(!newFile.exists() && ze.isDirectory()) {
			   newFile.mkdir();
			} 
			if(!ze.isDirectory()) {  
			    FileOutputStream fos = new FileOutputStream(newFile);             
			
			    int len;
			    while ((len = zis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			    }
					
			    fos.close();   
			}
			ze = zis.getNextEntry();
	    	}
    	
        zis.closeEntry();
    	zis.close();
    		
    	JOptionPane.showMessageDialog(null, extractedFiles.toString());
    		
    }catch(Exception e){
    	StringWriter sw = new StringWriter();
		   PrintWriter pw = new PrintWriter(sw);
		   e.printStackTrace(pw);
		   String sStackTrace = sw.toString();
		   JOptionPane.showMessageDialog(null, sStackTrace);
		   e.printStackTrace();
    }
   }    
}