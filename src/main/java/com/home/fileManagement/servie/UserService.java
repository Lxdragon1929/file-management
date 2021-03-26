package com.home.fileManagement.servie;

import com.home.fileManagement.module.common.Pagination;
import com.home.fileManagement.module.req.UserReq;
import com.home.fileManagement.module.res.UserRes;

/**
 * @author LX
 * @since 2021/3/24 11:33
 */

public interface UserService {

    UserRes addOrUpdate(UserReq req);

    boolean delete(String id);

    UserRes detail(String id);

    Pagination<UserRes> list(String userName, int page, int pageSize);

}
