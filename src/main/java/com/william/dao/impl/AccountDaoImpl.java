package com.william.dao.impl;

import com.william.dao.IAccountDao;

/**
 * 模拟持久层的实现
 */
public class AccountDaoImpl implements IAccountDao {
    public void saveAccount(){
        System.out.println("持久层保存账户");
    }
}
