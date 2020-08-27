package com.rcm.weigoucenter;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@SpringBootTest
class WeigouCenterApplicationTests {
    @Autowired
    private FastFileStorageClient fastFileStorageClient;
    @Test
   public void uploadTest() throws FileNotFoundException {
        File file=new File("F:\\springboot\\weigou\\weigou-web\\weigou-center\\cloud.jpeg");
        FileInputStream fileInputStream=new FileInputStream(file);
        StorePath storePath = fastFileStorageClient.uploadImageAndCrtThumbImage(fileInputStream, file.length(), "jpeg", null);
        System.out.println(storePath.getFullPath());
        System.out.println(storePath.getGroup());
        System.out.println(storePath.getPath());
    }

}
