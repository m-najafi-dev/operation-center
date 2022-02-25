package ir.operation.server.person.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.operation.server.utilities.protocol.Protocol;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonInfoDTO implements Protocol {

    private Long id;
    private String firstName;
    private String lastName;
    private String nationalCode;
}
