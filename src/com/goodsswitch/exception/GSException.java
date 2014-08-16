package com.goodsswitch.exception;

public class GSException extends Exception {

    /**错误码*/
    private String errorCode = " ";
    public GSException(){
        super();
    }
    /**
     * 有提示信息的异常构造器
     * @param errorMsg 异常编码
     */
    public GSException(String errorMsg){
        super(errorMsg);
    }
    
    /**
     * 带提示信息和异常编码的构造器
     * @param errorMsg 提示信息
     * @param errorCode 异常编码
     */
    public GSException(String errorMsg,String errorCode){
        this(errorMsg);
        this.setErrorCode(errorCode);
    }
    
    public String getErrorCode() {
        return errorCode;
    }
    
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
    
    

}
