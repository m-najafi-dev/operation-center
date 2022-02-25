package ir.operation.server.person.controller;

import ir.operation.server.meter.exception.ElectricityMeterException;
import ir.operation.server.person.dto.PersonInfoDTO;
import ir.operation.server.person.exception.PersonInfoException;
import ir.operation.server.person.service.impl.PersonInfoServiceImpl;
import ir.operation.server.utilities.protocol.Protocol;
import ir.operation.server.utilities.response.ResponseApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person/info")
@Slf4j
public class PersonInfoController {

    private final PersonInfoServiceImpl personInfoService;

    @Autowired
    public PersonInfoController(PersonInfoServiceImpl personInfoService) {
        this.personInfoService = personInfoService;
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseApi<? extends Protocol>> add(@RequestBody PersonInfoDTO personInfoDTO) {
        try {
            return new ResponseEntity<>(
                    new ResponseApi<>(HttpStatus.OK, personInfoService.add(personInfoDTO)),
                    HttpStatus.OK);
        } catch (PersonInfoException e) {
            log.error(e.getResponseApi().toString());
            return new ResponseEntity<>(e.getResponseApi(), e.getResponseApi().getHttpStatus());
        }
    }

    @GetMapping("/get")
    public ResponseEntity<List<PersonInfoDTO>> findAllPersonInfo() throws ElectricityMeterException.BadRequest {
        return new ResponseEntity<>(personInfoService.findAllPersonInfo(), HttpStatus.OK);
    }
}
