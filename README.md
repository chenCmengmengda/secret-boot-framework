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

如果觉得以上工具仍然不够用，本框架内置了hutool来解决大家的需求。

**关于本框架详情介绍请看 [wiki说明文档](https://gitee.com/SecretOpen/secret-boot-framework/wikis/%E7%AE%80%E4%BB%8B?sort_id=3220070)**


#### 使用方法
已发布到maven中央仓库
```
<dependency>
    <groupId>com.gitee.secretopen</groupId>
    <artifactId>secret-boot-framework-all</artifactId>
    <version>1.3.0</version>
</dependency>
```

#### 核心依赖
|  组件   | 版本  |
|  ----  | ----  |
| springboot  | 2.4.0 |
| mybatis-plus  | 3.4.1 |
| mysql  | 5.7/8.x |
| redis  |  |
| hutool  | 5.5.2 |

#### 截图
![avatar](http://secretOpen.gitee.io/secret-boot-framework/img1.png)


#### demo使用说明

1.  导入maven包
2.  运行DemoApplication
3.  访问localhost:8080

### 致谢

本项目有参考他人的代码，感谢各位大神的付出！
* 广大的开源爱好者
* [OneBlog](https://gitee.com/yadong.zhang/DBlog) 一个简洁美观、功能强大并且自适应的Java博客。
* [Hotool](https://gitee.com/loolly/hutool) 一个小而全的Java工具类库。
