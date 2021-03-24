package com.home.fileManagement.module.db;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author LX
 * @since 2021/3/24 11:15
 */
@Table(name = "file_resource")
@Entity
@Data
@Accessors(chain = true)
public class FileResource {

    @Id
    private String id;

    /**
     * 上传人id
     */
    private String uid;

    /**
     * 分享组id
     */
    private String shareId;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 文件存放路径
     */
    private String url;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 是否删除 1：删除
     */
    private boolean isDelete;

    /**
     * 是否共享 1：共享
     */
    private boolean isShare;
}
