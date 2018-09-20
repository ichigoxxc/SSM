package com.itheima.springmvc.pojo.utils;

import org.springframework.stereotype.Repository;
/*20180920 这里需要加入Repository,UserMapper是由MapperScannerConfigurer自动生成bean的*/

@Repository
public class Message {

    private String message;
    private boolean flag;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
