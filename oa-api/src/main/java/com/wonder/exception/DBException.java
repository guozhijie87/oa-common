package com.wonder.exception;

/**
 * Created by Guozhijie on 2016/9/12.
 */
public class DBException extends ServiceException {
    public static final DBException DB_INSERT_ERROR = new DBException(3, "数据库插入错误", new Object[0]);
    public static final DBException DB_UPDATE_ERROR = new DBException(3, "数据库更新错误", new Object[0]);
    public static final DBException DB_GET_ERROR = new DBException(3, "数据库查询错误", new Object[0]);
    public static final DBException DB_DELETE_ERROR = new DBException(3, "数据库删除错误", new Object[0]);
    protected String msg;
    protected int code;

    public DBException(int code, String msgformat, Object... args) {
        super(String.format(msgformat, args));
        this.code = code;
        this.msg = String.format(msgformat, args);
    }

    public DBException() {
        super();
    }

    public DBException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public DBException(Throwable cause) {
        super(cause);
    }

    public DBException(String msg) {
        super(msg);
    }

    public ServiceException newInstance(String msg, Object... args) {
        return new DBException(this.code, msg, args);
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }
}
