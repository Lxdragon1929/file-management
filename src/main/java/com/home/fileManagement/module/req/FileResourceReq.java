package com.home.fileManagement.module.req;

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
@Data
@Accessors(chain = true)
public class FileResourceReq {

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
     * 是否共享 1：共享
     */
    private boolean isShare;

    /**
     * 资源类型 1：图片 2：视频 3：音频 4：文档 5：其他
     */
    private Integer type;

    /**
     * 备注
     */
    private String remark;
}
