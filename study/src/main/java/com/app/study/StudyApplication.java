package com.app.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootApplication(scanBasePackages = "com.app.*")
@MapperScan(basePackages = "com.app.*.domain.*.repository")
public class StudyApplication {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext run = SpringApplication.run(StudyApplication.class, args);

//        test1(run);
        test2(run);

    }

    // BeanFactory学习
    private static void test1(ConfigurableApplicationContext run) throws Exception {
        // 1. 通过反射获取单例对象
        Field singletonObjects = DefaultSingletonBeanRegistry.class.getDeclaredField("singletonObjects");
        singletonObjects.setAccessible(true);

        ConfigurableListableBeanFactory beanFactory1 = run.getBeanFactory();
        Map<String, Object> result = (Map<String, Object>) singletonObjects.get(beanFactory1);
        Set<Map.Entry<String, Object>> entries = result.entrySet();
        result.entrySet().stream().filter(c -> c.getKey().equals("aaa")).forEach(c -> {
            System.out.println(c.getKey() + "===" + c.getValue());
        });
    }


    // applicationContext学习
    private static void test2(ConfigurableApplicationContext run) throws IOException {
        // 1. 获取国际化配置
        // String message = run.getMessage();
        // 2. 资源路径通配符
//        Resource[] resources = run.getResources("classpath*:META-INF/spring.factories");
//        for (Resource resource : resources) {
//            System.out.println("resource = " + resource);
//        }
        // 3. 获取环境配置信息
        ConfigurableEnvironment environment = run.getEnvironment();
        String property = environment.getProperty("spring.datasource.password");
        System.out.println("property = " + property);
    }

}
