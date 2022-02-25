package ir.operation.server.meter.model;

import ir.operation.server.meter.enumeration.MeterType;
import ir.operation.server.person.model.PersonInfo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "ELECTRICITY_METER")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ElectricityMeter implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, updatable = false)
    private String meterCode = UUID.randomUUID().toString();

    @Enumerated(EnumType.STRING)
    private MeterType meterType;

    @Column(nullable = false)
    private boolean active;

    @CreationTimestamp
    private LocalDateTime creationTimestamp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_info_id", referencedColumnName = "id")
    @ToString.Exclude
    private PersonInfo personInfo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ElectricityMeter that = (ElectricityMeter) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
