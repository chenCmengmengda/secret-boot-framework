# secret-boot-framework

![JDK](https://img.shields.io/badge/JDK-1.8-green.svg)
![Maven](https://img.shields.io/badge/Maven-3.6.1-green.svg)
![MySQL](https://img.shields.io/badge/MySQL-5.7-green.svg)
![Redis](https://img.shields.io/badge/Redis-3.2.100-green.svg)
[![license](https://img.shields.io/badge/license-GPL%20v3-yellow.svg)](https://gitee.com/secret_C/secretBlogBoot/blob/master/LICENSE)


#### 介绍
secret-boot脚手架(根据核心依赖版本长期更新)

只实现开发中最基础的springboot、mybatis、redis整合

内置丰富的基础工具类，开箱即用

#### 功能
jackson支持LocalDateTime、LocalDate、LocalTime

cache模块支持缓存切面

##### 模块介绍
|  模块   | 介绍  |
|  ----  | ----  |
| secret-boot-framework-core  | 框架核心模块 |
| secret-boot-framework-cache  | 框架缓存模块 |
| secret-boot-framework-mybatis-plus  | 与mybatis-plus集成 |
| secret-boot-framework-captcha  | 图形验证码 |
| secret-boot-framework-ffmpeg  | ffmpet工具模块 |
| secret-boot-framework-excel  | excel工具工具模块 |

##### core模块内置工具类介绍
|  类名   | 介绍  |
|  ----  | ----  |
| AesUtil  | AES加密工具 |
| AspectUtil  | aop切面工具 |
| CacheKeyUtil  | 缓存key生成工具 |
| CookieUtils  | Cookie工具 |
| DateUtils  | 日期工具 |
| ExceptionUtil  | 异常工具 |
| FtpUtil  | Ftp工具 |
| HtmlUtil  | Html工具 |
| HttpClientUtil  | Http工具 |
| IDUtils  | id生成策略工具 |
| IpUtil  | ip工具 |
| JsonUtils  | json转换工具 |
| Md5Util  | md5工具 |
| PasswordUtil  | 密码加密工具 |
| RegexUtils  | 正则表达式工具 |
| RequestUtil  | http请求工具 |
| RestClientUtil  | Http接口请求工具 |
| RSAEncryptUtil | RSA加密工具 |
| TextUtil | 文本转化工具 |
| WebSpiderUtils | 爬虫工具 |
| ZipFileUtils | zip压缩工具 |
| OkHttpClientUtils | OkHttp3封装工具 |

##### cache模块内置工具类介绍
|  类名   | 介绍  |
|  ----  | ----  |
| RedisUtils  | Redis工具 |
| SessionUtils  | Session工具 |

##### captcha模块内置工具类介绍
|  类名   | 介绍  |
|  ----  | ----  |
| GifCaptcha  | 生成gif图片验证码 |
| SpecCaptcha   | 生成png图片验证码 |

##### ffmpeg模块内置工具类介绍
|  类名   | 介绍  |
|  ----  | ----  |
| VideoUtil  | 视频工具类 |
| Mp4VideoUtil   | mp4工具类 |
| HlsVideoUtil   | hls工具类 |

如果觉得以上工具仍然不够用，本框架内置了hutool来解决大家的需求。

#### 使用方法
已发布到maven中央仓库
```
<dependency>
    <groupId>com.gitee.secretopen</groupId>
    <artifactId>secret-boot-framework-all</artifactId>
    <version>1.1</version>
</dependency>
```

#### 核心依赖
|  组件   | 版本  |
|  ----  | ----  |
| springboot  | 2.1.12.RELEASE |
| mybatis-plus  | 3.0.7 |
| mysql  | 5.7/8.x |
| redis  |  |
| hutool  | 4.1.21 |

#### 截图
![avatar](http://secretOpen.gitee.io/secret-boot-framework/img1.png)


#### 使用说明

1.  导入maven包
2.  运行DemoApplication
3.  访问localhost:8080

### 致谢

本项目有参考他人的代码，感谢各位大神的付出！
* 广大的开源爱好者
* [OneBlog](https://gitee.com/yadong.zhang/DBlog) 一个简洁美观、功能强大并且自适应的Java博客。
* [Hotool](https://gitee.com/loolly/hutool) 一个小而全的Java工具类库。
