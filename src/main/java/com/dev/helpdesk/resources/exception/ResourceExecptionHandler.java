package com.dev.helpdesk.resources.exception;
import com.dev.helpdesk.services.Exception.ErroDataIntegrity;
import com.dev.helpdesk.services.Exception.ObjectNotFoundException;
import com.dev.helpdesk.services.Exception.ValidacaoError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExecptionHandler {
@ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException ex,
                HttpServletRequest request){
               StandardError erro = new StandardError(System.currentTimeMillis(),
                       HttpStatus.NOT_FOUND.value(),"Object not found",ex.getMessage(),request.getRequestURI());
               return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }
@ExceptionHandler(ErroDataIntegrity.class)
        public ResponseEntity<StandardError> erroDataInterity(ErroDataIntegrity ex,
                                                              HttpServletRequest request){
            StandardError erro = new StandardError(System.currentTimeMillis(),
                    HttpStatus.BAD_REQUEST.value(),"Violação de Dados Erro 25",ex.getMessage(),request.getRequestURI());
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
}
@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> erroDataInterity(MethodArgumentNotValidException ex,
                                         HttpServletRequest request){
        ValidacaoError error = new ValidacaoError(System.currentTimeMillis()
                ,HttpStatus.BAD_REQUEST.value()
                ,"Validação"
                ,"Erro na validação dos campos "
                ,request.getRequestURI());

        for(FieldError x : ex.getBindingResult().getFieldErrors()){
              error.AddErrors(x.getField(),x.getDefaultMessage());
        }
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
