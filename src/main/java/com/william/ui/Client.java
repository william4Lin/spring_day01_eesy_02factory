package com.william.ui;

import com.william.factory.BeanFactory;
import com.william.service.IAccountService;
import com.william.service.impl.AccountServiceImpl;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {

    public static void main(String[] args) {
        //IAccountService accountService = new AccountServiceImpl();
        IAccountService accountService = (IAccountService) BeanFactory.getBean("accountService");
        accountService.saveAccount();
    }

}
