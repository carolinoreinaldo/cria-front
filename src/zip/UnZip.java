package zip;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnZip {
    private StringBuilder extractedFiles = new StringBuilder();
		
    public void unZipIt(String zipFile) throws IOException{

     byte[] buffer = new byte[1024];
    	
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
   }    
}