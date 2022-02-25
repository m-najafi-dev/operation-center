package ir.operation.server.person.model;

import ir.operation.server.meter.model.ElectricityMeter;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "PERSON")
@Data
public class PersonInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false, length = 10)
    private String nationalCode;

    @CreationTimestamp
    private LocalDateTime creationTimestamp;

    @Version
    private long lockVersion;

}
