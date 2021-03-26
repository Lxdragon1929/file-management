package com.home.fileManagement.module.req;

import lombok.Data;
import lombok.experimental.Accessors;

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
     * 上传人姓名
     */
    private String uName;

    /**
     * 分享组id
     */
    private String shareId;

    /**
     * 文件存放路径
     */
    private String url;

    /**
     * 是否共享 1：共享
     */
    private boolean isShare;

    /**
     * 备注
     */
    private String remark;
}
