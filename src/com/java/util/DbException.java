package com.java.util;

import com.java.util.BaseException;

public class DbException extends BaseException {
    public DbException(Throwable ex) {
        super("数据库操作错误：" + ex.getMessage());
    }
}
