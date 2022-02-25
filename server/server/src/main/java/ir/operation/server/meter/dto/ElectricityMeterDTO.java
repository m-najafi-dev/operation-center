package ir.operation.server.meter.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.operation.server.meter.enumeration.MeterType;
import ir.operation.server.person.model.PersonInfo;
import ir.operation.server.utilities.protocol.Protocol;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElectricityMeterDTO implements Protocol {

    private String meterCode;
    private MeterType meterType;
    private PersonInfo personInfo;
}
