package ir.operation.server.meter.controller;

import ir.operation.server.meter.dto.ElectricityMeterDTO;
import ir.operation.server.meter.exception.ElectricityMeterException;
import ir.operation.server.meter.service.impl.ElectricityMeterServiceImpl;
import ir.operation.server.person.exception.PersonInfoException;
import ir.operation.server.utilities.protocol.Protocol;
import ir.operation.server.utilities.response.ResponseApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/electricity/meter")
@Slf4j
public class ElectricityMeterController {

    private final ElectricityMeterServiceImpl electricityMeterService;

    @Autowired
    public ElectricityMeterController(ElectricityMeterServiceImpl electricityMeterService) {
        this.electricityMeterService = electricityMeterService;
    }


    @PostMapping("/add")
    public ResponseEntity<ResponseApi<? extends Protocol>> add(@RequestBody ElectricityMeterDTO electricityMeterDTO)
            throws ElectricityMeterException.BadRequest {
        try {
            return new ResponseEntity<>(
                    new ResponseApi<>(HttpStatus.CREATED, electricityMeterService.add(electricityMeterDTO)),
                    HttpStatus.CREATED);
        } catch (ElectricityMeterException | PersonInfoException e) {
            log.error(e.getResponseApi().toString());
            return new ResponseEntity<>(e.getResponseApi(), e.getResponseApi().getHttpStatus());
        }
    }

    @GetMapping("/get")
    public ResponseEntity<List<ElectricityMeterDTO>> findAllElectricityMeter() throws ElectricityMeterException.BadRequest {
        return new ResponseEntity<>(electricityMeterService.findAllElectricityMeter(), HttpStatus.OK);
    }
}
