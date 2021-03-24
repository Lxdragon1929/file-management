package com.home.fileManagement.module.enm;

/**
 * @author LX
 * @since 2021/3/24 15:07
 */

public enum ResourceType {

    photo(1,"图片"),
    vedio(2,"视频"),
    audio(3,"音频"),
    doc(4,"文档"),
    other(5,"其他");

    private Integer code;

    private String name;

    ResourceType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
