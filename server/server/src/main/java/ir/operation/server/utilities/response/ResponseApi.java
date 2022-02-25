package ir.operation.server.utilities.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.operation.server.utilities.protocol.Protocol;
import lombok.Data;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseApi<T> implements Protocol {
    private HttpStatus httpStatus;
    private long code;
    private String messageEn;
    private String messageFa;
    private T data;

    public ResponseApi() {
    }

    public ResponseApi(HttpStatus httpStatus, T data) {
        this.httpStatus = httpStatus;
        this.data = data;
    }

    public ResponseApi(HttpStatus httpStatus, long code, String messageEn, String messageFa, T data) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.messageEn = messageEn;
        this.messageFa = messageFa;
        this.data = data;
    }
}
