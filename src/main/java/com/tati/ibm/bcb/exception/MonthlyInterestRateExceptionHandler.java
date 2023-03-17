package com.tati.ibm.bcb.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class MonthlyInterestRateExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String CONSTANT_VALIDATION_NOT_BLANK = "NotBlank";
    private static final String CONSTANT_VALIDATION_NOT_NULL = "NotNull";
    private static final String CONSTANT_VALIDATION_LENGTH = "Length";
    private static final String CONSTANT_VALIDATION_PATTERN = "Pattern";
    private static final String CONSTANT_VALIDATION_MIN = "Min";

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<StandardError> error = gerarListaDeErros(e.getBindingResult());
        return handleExceptionInternal(e, error, headers, HttpStatus.BAD_REQUEST, request);
    }
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException e, WebRequest request){
        String mensagem = "Taxa de Juros não encontrada";
        List<StandardError> error = Arrays.asList(new StandardError(mensagem));
        return handleExceptionInternal(e, error, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException e, WebRequest request){
        String mensagem = "Taxa de Juros não encontrada";
        List<StandardError> error = Arrays.asList(new StandardError(mensagem));
        return handleExceptionInternal(e, error, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<Object> objectNotFoundException(ObjectNotFoundException e, WebRequest request){
        String mensagem = e.getMessage();
        List<StandardError> error = Arrays.asList(new StandardError(mensagem));
        return handleExceptionInternal(e, error, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
    private List<StandardError> gerarListaDeErros(BindingResult bindingResult) {
        List<StandardError> error = new ArrayList<StandardError>();
        bindingResult.getFieldErrors().forEach(fieldError -> {
            String mensagem = tratarMensagemDeErroParaUsuario(fieldError);
            error.add(new StandardError(mensagem));
        });
        return error;
    }
    private String tratarMensagemDeErroParaUsuario(FieldError fieldError) {
        if (fieldError.getCode().equals(CONSTANT_VALIDATION_NOT_BLANK)) {
            return fieldError.getDefaultMessage().concat(" é obrigatório.");
        }
        if (fieldError.getCode().equals(CONSTANT_VALIDATION_NOT_NULL)) {
            return fieldError.getDefaultMessage().concat(" é obrigatório.");
        }
        if (fieldError.getCode().equals(CONSTANT_VALIDATION_LENGTH)) {
            return fieldError.getDefaultMessage().concat(String.format(" deve ter entre %s e %s caracteres.",
                    fieldError.getArguments()[2], fieldError.getArguments()[1]));
        }
        if (fieldError.getCode().equals(CONSTANT_VALIDATION_PATTERN)) {
            return fieldError.getDefaultMessage().concat(" formato inválido.");
        }
        if (fieldError.getCode().equals(CONSTANT_VALIDATION_MIN)) {
            return fieldError.getDefaultMessage().concat(String.format(" deve ser maior ou igual a %s",
                    fieldError.getArguments()[1]));
        }
        return fieldError.toString();
    }
}
