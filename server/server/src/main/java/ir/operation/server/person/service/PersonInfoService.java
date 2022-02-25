package ir.operation.server.person.service;

import ir.operation.server.person.dto.PersonInfoDTO;
import ir.operation.server.person.exception.PersonInfoException;
import ir.operation.server.utilities.exception.BaseException;

import java.util.List;

public interface PersonInfoService {
    PersonInfoDTO add(PersonInfoDTO personInfoDTO) throws PersonInfoException.BadRequest, PersonInfoException.FailedOperation, BaseException;

    List<PersonInfoDTO> findAllPersonInfo();
}
