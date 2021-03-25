package com.home.fileManagement.module.req;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author LX
 * @since 2021/3/24 9:54
 */
@Data
@Accessors(chain = true)
public class UserReq {

    private String id;

    /**
     * 分享组id
     */
    private String shareId;

    private String userName;

    private String password;

    /**
     * 备注
     */
    private String remark;

}
