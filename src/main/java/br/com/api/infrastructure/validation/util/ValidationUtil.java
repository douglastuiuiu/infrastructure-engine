package br.com.api.infrastructure.validation.util;

import br.com.api.infrastructure.validation.model.FieldErrorResponse;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author douglasog87@gmail.com
 * @since 29/12/2016
 */
public class ValidationUtil {

    private ValidationUtil() {
        //vazio
    }

    /**
     * Define o retorno de erro informando quais dados não passaram pela validação padrão do BeanValidation (JSR 303)
     *
     * @param error
     * @return
     */
    public static List<FieldErrorResponse> createFieldErrorResponse(MethodArgumentNotValidException error) {
        List<FieldErrorResponse> listErrors = new ArrayList<>();
        for (FieldError fieldError : error.getBindingResult().getFieldErrors()) {
            FieldErrorResponse validationResponse = new FieldErrorResponse();
            validationResponse.setFieldName(fieldError.getField());
            validationResponse.setTypeRejected(fieldError.getCode() != null ? fieldError.getCode().toString() : null);
            validationResponse.setValueRejected(fieldError.getRejectedValue() != null ? fieldError.getRejectedValue().toString() : null);
            validationResponse.setDefaultMessage(fieldError.getDefaultMessage());
            listErrors.add(validationResponse);
        }
        return listErrors;
    }
}