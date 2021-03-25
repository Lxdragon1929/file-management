package com.home.fileManagement.module.res;

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
     * 是否删除 1：删除
     */
    private boolean isDelete;

    /**
     * 备注
     */
    private String remark;

}
