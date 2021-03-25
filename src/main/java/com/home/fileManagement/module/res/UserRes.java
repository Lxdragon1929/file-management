package com.home.fileManagement.module.res;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import java.util.Date;

/**
 * @author LX
 * @since 2021/3/24 9:54
 */
@Data
@Accessors(chain = true)
public class UserRes {

    @Id
    private String id;

    /**
     * 分享组id
     */
    private String shareId;

    private String userName;

    private String password;

    private Date createTime;

    private Date updateTime;

    /**
     * 备注
     */
    private String remark;

}
