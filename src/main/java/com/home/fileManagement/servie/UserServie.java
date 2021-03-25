package com.home.fileManagement.servie;

import com.home.fileManagement.module.req.UserReq;
import com.home.fileManagement.module.res.UserRes;
import org.springframework.data.domain.Page;

/**
 * @author LX
 * @since 2021/3/24 11:33
 */

public interface UserServie {

    UserRes addOrUpdate(UserReq req);

    boolean delete(String id);

    UserRes detail(String id);

    Page<UserRes> list(String userName,int page,int pageSize);

}
