package ir.operation.server.meter.repository;

import ir.operation.server.meter.model.ElectricityMeter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectricityMeterRepository extends JpaRepository<ElectricityMeter, Long> {

    ElectricityMeter findElectricityMeterById(Long id);
}
