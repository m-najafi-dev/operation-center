package ir.operation.server.meter.service.impl;

import ir.operation.server.meter.dto.ElectricityMeterDTO;
import ir.operation.server.meter.exception.ElectricityMeterException;
import ir.operation.server.meter.model.ElectricityMeter;
import ir.operation.server.meter.repository.ElectricityMeterRepository;
import ir.operation.server.meter.service.ElectricityMeterService;
import ir.operation.server.person.exception.PersonInfoException;
import ir.operation.server.person.model.PersonInfo;
import ir.operation.server.person.repository.PersonInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ElectricityMeterServiceImpl implements ElectricityMeterService {

    private final ElectricityMeterRepository electricityMeterRepository;

    private final PersonInfoRepository personInfoRepository;

    @Autowired
    public ElectricityMeterServiceImpl(ElectricityMeterRepository electricityMeterRepository,
                                       PersonInfoRepository personInfoRepository) {
        this.electricityMeterRepository = electricityMeterRepository;
        this.personInfoRepository = personInfoRepository;
    }

    @Override
    public ElectricityMeterDTO add(ElectricityMeterDTO electricityMeterDTO) throws ElectricityMeterException, PersonInfoException {
        if (electricityMeterDTO != null && electricityMeterDTO.getMeterType() != null) {
            if (electricityMeterDTO.getPersonInfo() != null && electricityMeterDTO.getPersonInfo().getId() > 0) {
                Optional<PersonInfo> personInfo =
                        personInfoRepository.findById(electricityMeterDTO.getPersonInfo().getId());
                if (personInfo.isPresent()) {
                    try {
                        ElectricityMeter saveElectricityMeter =
                                electricityMeterRepository.save(
                                        new ModelMapper().map(electricityMeterDTO, ElectricityMeter.class));
                        saveElectricityMeter.setPersonInfo(personInfo.get());
                        return new ModelMapper().map(saveElectricityMeter, ElectricityMeterDTO.class);
                    } catch (Exception e) {
                        log.error(e.getMessage());
                        throw new ElectricityMeterException.FailedOperation(e.getMessage());
                    }
                }
                throw new PersonInfoException.NotFund();
            }
            throw new PersonInfoException.BadRequest();
        }
        throw new ElectricityMeterException.BadRequest();
    }

    @Override
    public List<ElectricityMeterDTO> findAllElectricityMeter() {
        return electricityMeterRepository.findAll().
                stream().
                map(electricityMeter ->
                        new ModelMapper().map(electricityMeter, ElectricityMeterDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean activeOrDeActiveMeter(Boolean value) {
        return null;
    }
}
