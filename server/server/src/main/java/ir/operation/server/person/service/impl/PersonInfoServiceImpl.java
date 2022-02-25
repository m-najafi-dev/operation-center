package ir.operation.server.person.service.impl;

import ir.operation.server.person.dto.PersonInfoDTO;
import ir.operation.server.person.exception.PersonInfoException;
import ir.operation.server.person.model.PersonInfo;
import ir.operation.server.person.repository.PersonInfoRepository;
import ir.operation.server.person.service.PersonInfoService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PersonInfoServiceImpl implements PersonInfoService {

    private final PersonInfoRepository personInfoRepository;

    public PersonInfoServiceImpl(PersonInfoRepository personInfoRepository) {
        this.personInfoRepository = personInfoRepository;
    }

    @Override
    public PersonInfoDTO add(PersonInfoDTO personInfoDTO) throws PersonInfoException {
        if (personInfoDTO.getFirstName() != null) {
            try {
                PersonInfo savePersonInfo =
                        personInfoRepository.save(new ModelMapper().map(personInfoDTO, PersonInfo.class));
                return new ModelMapper().map(savePersonInfo, PersonInfoDTO.class);
            } catch (Exception e) {
                log.error(e.getMessage());
                throw new PersonInfoException.FailedOperation(e.getMessage());
            }
        }
        throw new PersonInfoException.BadRequest();
    }

    @Override
    public List<PersonInfoDTO> findAllPersonInfo() {
        return personInfoRepository.findAll().
                stream().
                map(personInfo ->
                        new ModelMapper().map(personInfo, PersonInfoDTO.class))
                .collect(Collectors.toList());
    }
}
