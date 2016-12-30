package br.com.api.infrastructure.resource.handler;

import br.com.api.infrastructure.exception.AlreadyReportedException;
import br.com.api.infrastructure.exception.ServiceException;
import br.com.api.infrastructure.util.ApiUtil;
import br.com.api.infrastructure.util.MessageLocale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

/**
 * @author douglasog87@gmail.com
 * @since 29/12/2016
 */
@ControllerAdvice(annotations = RestController.class)
public class ApiValidatorExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(ApiValidatorExceptionHandler.class);

    @Autowired
    private MessageLocale messageLocale;

    /**
     * Erros gerados pela validação dos dados da requisição
     *
     * @param error
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException error) {
        logger.error("MethodArgumentNotValidException: " + error, error);
        return ApiUtil.responseErrorValidation(error);
    }

    /**
     * Erros relacionados a regras de negócio
     *
     * @param error
     * @return
     */
    @ExceptionHandler(value = ServiceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<Object> handleServiceException(ServiceException error) {
        logger.error("ServiceException: " + error, error);
        return ApiUtil.responseError(error.getMessage(), HttpStatus.BAD_REQUEST);
    }

    /**
     * Validação de tentativa de inserção de itens já existentes
     *
     * @param error
     * @return
     */
    @ExceptionHandler(value = AlreadyReportedException.class)
    @ResponseStatus(HttpStatus.ALREADY_REPORTED)
    @ResponseBody
    public ResponseEntity<Object> handleAlreadyReportedException(AlreadyReportedException error) {
        logger.error("handleAlreadyReportedException: " + error, error);
        return ApiUtil.responseError(error.getMessage(), HttpStatus.ALREADY_REPORTED);
    }

    /**
     * Erros relacionado ao envio de dados com formato ou tipo inválido
     *
     * @param error
     * @return
     */
    @ExceptionHandler(value = HttpMessageConversionException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntity<Object> handleException(HttpMessageConversionException error) {
        logger.error("HttpMessageConversionException: " + error, error);
        return ApiUtil.responseError(error.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }

    /**
     * Pega Qualquer outro erro não tratado
     *
     * @param error
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntity<Object> handleException(Exception error) {
        logger.error("Erro não tratado: " + error, error);
        return ApiUtil.responseError(messageLocale.getMessage("error.generic_error"), HttpStatus.BAD_REQUEST);
    }
}
