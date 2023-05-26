package com.hrutility.hrutilityjava.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileUploadUtil {
    public  static String saveFile(String fileName,MultipartFile multipartFiles) throws IOException {
        Path fileUploadPath = Path.of("upload");
//        create directory if not exist
        if(!Files.exists(fileUploadPath)){
        Files.createDirectories(fileUploadPath);
    }
//        generate a unique file name if no file name is provided
        String fileCode = fileName + "-" + Math.random();
   try(InputStream inputStream = multipartFiles.getInputStream()) {
       Path filePath = fileUploadPath.resolve(fileCode);
       Files.copy(inputStream,filePath, StandardCopyOption.REPLACE_EXISTING);
   }catch(IOException exe){
       throw new IOException("Could not save file" + fileName);
   }
        return fileCode;
   }

}
