package com.dev.helpdesk.services.Exception;
import java.io.Serializable;
import lombok.Data;
@Data
public class FieldsMsg  implements Serializable {
    private static final long serialVersionUID = 1L;
    private String fieldname;
    private String message;
    public FieldsMsg() {
    }
    public FieldsMsg(String fieldname, String message) {
        this.fieldname = fieldname;
        this.message = message;
    }
}
