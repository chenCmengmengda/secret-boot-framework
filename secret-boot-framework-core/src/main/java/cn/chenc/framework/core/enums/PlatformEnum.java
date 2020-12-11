package cn.chenc.framework.core.enums;

/**
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0
 * @date 2018/5/7 15:16
 * @since 1.0
 */
public enum PlatformEnum {
    ADMIN("后台管理"),
    WEB("前台网站"),
    ;

    private String platform;

    PlatformEnum(String platform){
        this.platform=platform;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
