package com.home.fileManagement.controller;

import com.home.fileManagement.module.common.Pagination;
import com.home.fileManagement.module.db.User;
import com.home.fileManagement.module.res.FileResourceRes;
import com.home.fileManagement.servie.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author LX
 * @since 2021/3/24 11:22
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    /**
     * 添加文件
     * @param files
     * @return
     */
    @PostMapping("/add")
    public boolean add(@RequestBody MultipartFile[] files){
        User user = new User();
        user.setId("111")
                .setUserName("test001");
        return fileService.add(user, files);
    }

    /**
     * 删除文件
     * @param id
     * @return
     */
    @PostMapping("/delete")
    public boolean delete(String id){
        return fileService.delete(id);
    }

    /**
     * 文件详情
     * @param id
     * @return
     */
    @GetMapping("/detail")
    public FileResourceRes detail(String id){
        return fileService.detail(id);
    }

    /**
     * 文件列表
     * @param uid
     * @param type
     * @param fileName
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/list")
    public Pagination<FileResourceRes> list(String uid,
                                            @RequestParam(required = false) String type,
                                            @RequestParam(required = false) String fileName,
                                            @RequestParam(required = false,defaultValue = "1") int page,
                                            @RequestParam(required = false,defaultValue = "10") int pageSize){
        return fileService.list(uid, type, fileName, page, pageSize);
    }


}
