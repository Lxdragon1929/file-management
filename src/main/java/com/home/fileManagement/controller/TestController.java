package com.home.fileManagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author LX
 * @since 2021/3/24 11:45
 */
@RestController
@Slf4j
public class TestController {

    @PostMapping("/test")
    public String uploadFiles(@RequestBody MultipartFile[] files) {

        try {
            // 创建文件在服务器端存放路径
            //      String dir = request.getServletContext().getRealPath("G:\\家用文件服务");
            File fileDir = new File("G:\\家用文件服务");
            if(!fileDir.exists()) {
                fileDir.mkdirs();
            }
            //生成文件在服务器端存放的名字
            for(int i=0;i<files.length;i++) {
//                String fileSuffix = files[i].getOriginalFilename().substring(files[i].getOriginalFilename().lastIndexOf("."));
//                String fileName= UUID.randomUUID().toString()+fileSuffix;
//                File file = new File(fileDir+"/"+fileName);
                String originalFilename = files[i].getOriginalFilename();
                File file = new File(fileDir+"/"+originalFilename);
                //上传
                files[i].transferTo(file);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功";
    }

}
