package ir.operation.server.person.repository;

import ir.operation.server.person.model.PersonInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonInfoRepository extends JpaRepository<PersonInfo, Long> {
}
