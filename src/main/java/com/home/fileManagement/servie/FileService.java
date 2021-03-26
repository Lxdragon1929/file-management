package com.home.fileManagement.servie;

import com.home.fileManagement.module.common.Pagination;
import com.home.fileManagement.module.db.User;
import com.home.fileManagement.module.req.FileResourceReq;
import com.home.fileManagement.module.res.FileResourceRes;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author LX
 * @since 2021/3/24 11:33
 */

public interface FileService {

    boolean add(User user, MultipartFile[] files);

    FileResourceRes update(FileResourceReq req);

    boolean delete(String id);

    FileResourceRes detail(String id);

    Pagination<FileResourceRes> list(String userId,String type, String fileName, int page, int pageSize);

    void uploadAndAdd(User user, MultipartFile file);

}
