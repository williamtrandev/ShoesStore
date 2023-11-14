package com.trantanthanh.springcommerce.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Base64;

public class FileUploadUtil {
    public static void saveImageFromBase64(String uploadDir, String fileName, String base64String) {
        Path uploadPath = Paths.get(uploadDir);

        try {
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            byte[] imageBytes = Base64.getDecoder().decode(base64String);
            Path filePath = Paths.get(uploadDir, fileName);
            Files.write(filePath, imageBytes);
            System.out.println("File đã được lưu tại: " + filePath);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
