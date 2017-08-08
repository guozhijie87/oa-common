package com.wonder.exception;

/**
 * Created by Guozhijie on 2016/9/12.
 */
public class ServiceException extends RuntimeException {
    protected String msg;
    protected int code;

    public  ServiceException(int code,String msgformat,Object...args){
        super(String.format(msgformat,args));
        this.code=code;
        this.msg=String.format(msgformat,args);
    }

    public ServiceException(){
        super();
    }
    public  ServiceException(String msg,Throwable cause){
        super(msg,cause);
    }
    public ServiceException(Throwable cause){
        super(cause);
    }
    public ServiceException(String msg){
        super(msg);
    }

    public ServiceException newInstance(String msg, Object...args){
        return new ServiceException(this.code,msg,args);
    }

    public String getMsg(){
        return msg;
    }
    public int getCode(){
        return code;
    }
}
