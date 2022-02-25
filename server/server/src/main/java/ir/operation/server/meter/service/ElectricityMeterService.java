package ir.operation.server.meter.service;

import ir.operation.server.meter.dto.ElectricityMeterDTO;
import ir.operation.server.meter.exception.ElectricityMeterException;

import java.util.List;

public interface ElectricityMeterService {

    ElectricityMeterDTO add(ElectricityMeterDTO electricityMeterDTO) throws ElectricityMeterException;

    List<ElectricityMeterDTO> findAllElectricityMeter();

    Boolean activeOrDeActiveMeter(Boolean value);


}
