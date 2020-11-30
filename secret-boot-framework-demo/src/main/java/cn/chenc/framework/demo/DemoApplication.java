package cn.chenc.framework.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 　@description: TODO
 * 　@author secret
 * 　@date 2020/11/28 13:54
 *
 */
@SpringBootApplication
@EnableTransactionManagement
@ComponentScan(basePackages = {"cn.chenc.framework"})
public class DemoApplication {

    public static void main(String[] args){
        SpringApplication.run(DemoApplication.class, args);
    }

}
