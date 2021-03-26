package com.home.fileManagement.servie.impl;

import com.home.fileManagement.servie.FileOperateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author LX
 * @since 2021/3/26 15:07
 */
@Service
@Slf4j
public class FileOperateImpl implements FileOperateService {

    @Override
    public boolean uploadFile(MultipartFile remote, String path) {
        try {
            File file = new File(path);
            //上传
            remote.transferTo(file);
        } catch (IOException e) {
            log.error("上传文件失败，文件名：{}", remote.getOriginalFilename());
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
