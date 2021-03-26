package com.home.fileManagement.servie;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author LX
 * @since 2021/3/26 14:47
 */

public interface FileOperateService {

    /**
     * 上传文件
     * @param remote 文件
     * @param path 存放路径
     * @return
     */
    boolean uploadFile(MultipartFile remote,String path);


}
