package br.com.api.infrastructure.validation.model;

/**
 * @author douglasog87@gmail.com
 * @since 29/12/2016
 */
public class FieldErrorResponse {
    private String fieldName;
    private String defaultMessage;
    private Object typeRejected;
    private Object valueRejected;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public void setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    public Object getTypeRejected() {
        return typeRejected;
    }

    public void setTypeRejected(Object typeRejected) {
        this.typeRejected = typeRejected;
    }

    public Object getValueRejected() {
        return valueRejected;
    }

    public void setValueRejected(Object valueRejected) {
        this.valueRejected = valueRejected;
    }

}
