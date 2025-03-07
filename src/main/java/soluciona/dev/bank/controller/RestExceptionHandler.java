package soluciona.dev.bank.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import soluciona.dev.bank.exception.BankException;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(BankException.class)
    public ProblemDetail handleBankException(BankException e){
        return e.toProblemDetail();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        var fieldErros = e.getFieldErrors()
                .stream()
                .map(f -> new InvalidParam(f.getField(), f.getDefaultMessage()))
                .toList();

        var pb = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        pb.setTitle("Your request parameters didn't validate."); //https://datatracker.ietf.org/doc/html/rfc7807
        pb.setProperty("invalid-params", fieldErros);

        return pb;
    }

    private record InvalidParam(String name, String reason){}
}
