package com.dev.helpdesk.services.Exception;
import com.dev.helpdesk.resources.exception.StandardError;
import java.util.ArrayList;
import java.util.List;
public class ValidacaoError extends StandardError {

    private static final long serialVersionUID = 1L;
    private List<FieldsMsg> errors = new ArrayList<>();
    public ValidacaoError(Long timestamp, Integer status, String error, String message, String path ) {
        super(timestamp, status, error, message, path);
    }
    public List<FieldsMsg> getErrors() {
        return errors;
    }
    public void AddErrors(String filedName,String message) {
        this.errors.add( new FieldsMsg(filedName,message));
    }
    public ValidacaoError( ) {
        super( );
    }
}
