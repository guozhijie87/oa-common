package com.wonder.util;

/**
 * Created by Guozhijie on 2016/8/29.
 */
public class RESTfulMessage {
    public static final String SECCESS="succes";
    public static final String ERROR="error";

    private Integer code;
    private String message;
    private Object data;

    public static class MessageBuilder{
        private Integer code;
        private String messgae;
        private Object data;
      public MessageBuilder(Integer code){
          this.code=code;
      }
        public MessageBuilder(Integer code,String messgae){
            this.code=code;
            this.messgae=messgae;
        }
        public RESTfulMessage build(){
            return new RESTfulMessage(this);
        }
        public RESTfulMessage.MessageBuilder message(String messgae){
            this.messgae=messgae;
            return this;
        }
        public  RESTfulMessage.MessageBuilder data(Object data){
            this.data=data;
            return this;
        }
    }

    private static  RESTfulMessage.MessageBuilder messageCode(Integer code){
        return new RESTfulMessage.MessageBuilder(code);
    }

    private static  RESTfulMessage.MessageBuilder messageCode(Integer code,String messgae){
        return new RESTfulMessage.MessageBuilder(code,messgae);
    }

    public static RESTfulMessage.MessageBuilder success(){
        return messageCode(Integer.valueOf(1),"success");
    }

    public static RESTfulMessage.MessageBuilder error(){
        return messageCode(Integer.valueOf(0),"error");
    }

    public RESTfulMessage(RESTfulMessage.MessageBuilder builder){
        if(builder.code!=null){
            this.code=builder.code;;
        }
        if(builder.messgae!=null){
            this.message=builder.messgae;
        }
        if(builder.data!=null){
            this.data=data;
        }
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
