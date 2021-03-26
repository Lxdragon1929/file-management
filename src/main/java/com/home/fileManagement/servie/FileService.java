package com.home.fileManagement.servie;

import com.home.fileManagement.module.common.Pagination;
import com.home.fileManagement.module.req.FileResourceReq;
import com.home.fileManagement.module.res.FileResourceRes;

/**
 * @author LX
 * @since 2021/3/24 11:33
 */

public interface FileService {

    FileResourceRes addOrUpdate(FileResourceReq req);

    boolean delete(String id);

    FileResourceRes detail(String id);

    Pagination<FileResourceRes> list(String type, String fileName, int page, int pageSize);

}
