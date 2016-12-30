package br.com.api.infrastructure.validation.model;

/**
 * @author douglasog87@gmail.com
 * @since 29/12/2016
 */
public class ErrorModel {
    private Integer code;
    private Object message;

    public ErrorModel() {

    }

    public ErrorModel(Integer code, Object message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

}
