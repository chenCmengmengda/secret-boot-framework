package cn.chenc.framework.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 　@description: TODO
 * 　@author secret
 * 　@date 2020/11/28 13:54
 *
 */
@SpringBootApplication
@EnableTransactionManagement
public class DemoApplication {

    public static void main(String[] args){
        SpringApplication.run(DemoApplication.class, args);
    }

}
