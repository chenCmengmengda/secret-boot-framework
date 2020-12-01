package cn.chenc.framework.common.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

/**
 * 　@description: TODO
 * 　@author secret
 * 　@date 2020/12/1 20:22
 *
 */
@Configuration
@ComponentScans({@ComponentScan("cn.chenc.framework")
})
public class SecretBootAutoConfiguration {
}
