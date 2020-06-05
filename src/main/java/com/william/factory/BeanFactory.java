package com.william.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 一个创建Bean对象的工厂
 *
 * 就是创建service和dao对象的
 * 1.需要一个配置文件来配置service和dao
 *
 * 2.通过读取配置文件中的配置内容，反射创建对象
 *
 * 配置文件可以是xml也可以是properties
 */
public class BeanFactory {

    private static Properties props ;

    private static Map<String,Object> beans ;

    static{
        try {
            props = new Properties();
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);

            beans = new HashMap<String, Object>();

            Enumeration keys = props.keys();

            while(keys.hasMoreElements()){

                String key = keys.nextElement().toString();

                String beanPath = props.getProperty(key);

                Object value = Class.forName(beanPath).newInstance();

                beans.put(key,value);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties文件失败");
        }

    }

    /**
     *根据bean的名称获取对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
        return beans.get(beanName);
    }

   /* *//**
     * 根据beanName获取bean对象
     * @param beanName
     * @return
     *//*
    public static Object getBean(String beanName){
        Object bean = null;
        String beanPath = props.getProperty(beanName);
        try {
            bean = Class.forName(beanPath).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }*/
}
