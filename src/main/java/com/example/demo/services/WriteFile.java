/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.services;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;

/**
 *
 * @author Alex
 */
public class WriteFile {

    public static void write(byte[] data, String path) throws FileNotFoundException, IOException {
        try (FileOutputStream stream = new FileOutputStream(path)) {
            stream.write(data);
        }
    }

    public static void createJpg() {
        int desiredSizeInBytes = 36601; // Kích thước mong muốn: 3 MB
        int width = 800; // Độ rộng hình ảnh
        int height = 600; // Chiều cao hình ảnh
        String outputFilePath = "output.jpg"; // Đường dẫn tới tệp đầu ra

        try {
            // Tạo hình ảnh trắng với kích thước và màu nền tùy chỉnh
            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            
            
            // Tạo tệp JPG từ hình ảnh và lưu xuống đĩa
            File outputFile = new File(outputFilePath);
            ImageIO.write(bufferedImage, "jpg", outputFile);

            // Kiểm tra và điều chỉnh kích thước của tệp đầu ra
            long fileSize = outputFile.length();
            System.out.println("Kích thước tệp vượt quá kích thước mong muốn: " + fileSize + " bytes");
            System.out.println("Đang điều chỉnh kích thước...");

            // Xóa tệp hiện tại và tạo lại với kích thước mong muốn
            outputFile.delete();
            double scaleFactor = Math.sqrt((double) desiredSizeInBytes / fileSize);
            width = (int) (width * scaleFactor);
            height = (int) (height * scaleFactor);
            bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            ImageIO.write(bufferedImage, "jpg", outputFile);

            System.out.println("Đã tạo tệp JPG thành công: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
