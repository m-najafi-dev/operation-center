package ir.operation.server.person.exception;

import ir.operation.server.person.exception.enumeration.PersonInfoMessageError;
import ir.operation.server.utilities.exception.BaseException;
import ir.operation.server.utilities.exception.enumeration.MessageError;
import ir.operation.server.utilities.protocol.Protocol;
import ir.operation.server.utilities.response.ResponseApi;
import org.springframework.http.HttpStatus;

public class PersonInfoException extends BaseException {

    public PersonInfoException(ResponseApi<? extends Protocol> responseApi) {
        super(responseApi);
    }

    public static class BadRequest extends PersonInfoException {

        private static final long serialVersionUID = 3555714415375055301L;

        public BadRequest() {
            super(new ResponseApi<>(
                    HttpStatus.BAD_REQUEST,
                    PersonInfoMessageError.BAD_REQUEST_EXCEPTION.getStatusCode(),
                    PersonInfoMessageError.BAD_REQUEST_EXCEPTION.getNameEn(),
                    PersonInfoMessageError.BAD_REQUEST_EXCEPTION.getNameFa(), null));
        }

        public BadRequest(String msgEn) {
            super(new ResponseApi<>(
                    HttpStatus.BAD_REQUEST,
                    PersonInfoMessageError.BAD_REQUEST_EXCEPTION.getStatusCode(),
                    msgEn,
                    PersonInfoMessageError.BAD_REQUEST_EXCEPTION.getNameFa(), null));
        }

        public BadRequest(String msgEn, String msgFa) {
            super(new ResponseApi<>(
                    HttpStatus.BAD_REQUEST,
                    PersonInfoMessageError.BAD_REQUEST_EXCEPTION.getStatusCode(),
                    msgEn,
                    msgFa, null));
        }
    }

    public static class FailedOperation extends PersonInfoException {
        private static final long serialVersionUID = 3555714415375055302L;

        public FailedOperation() {
            super(new ResponseApi<>(
                    HttpStatus.EXPECTATION_FAILED,
                    MessageError.BAD_REQUEST_EXCEPTION.getStatusCode(),
                    MessageError.FAILED_OPERATION_EXCEPTION.getNameEn(),
                    MessageError.FAILED_OPERATION_EXCEPTION.getNameFa(), null));
        }

        public FailedOperation(String msgEn) {
            super(new ResponseApi<>(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    MessageError.FAILED_OPERATION_EXCEPTION.getStatusCode(),
                    msgEn,
                    MessageError.FAILED_OPERATION_EXCEPTION.getNameFa(), null));
        }

        public FailedOperation(String msgEn, String msgFa) {
            super(new ResponseApi<>(
                    HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.EXPECTATION_FAILED.value(),
                    msgEn,
                    msgFa, null));
        }
    }

    public static class NotFund extends PersonInfoException {
        private static final long serialVersionUID = 3555714415375055303L;

        public NotFund() {
            super(new ResponseApi<>(
                    HttpStatus.NOT_FOUND,
                    PersonInfoMessageError.NOT_FUND_EXCEPTION.getStatusCode(),
                    PersonInfoMessageError.NOT_FUND_EXCEPTION.getNameEn(),
                    PersonInfoMessageError.NOT_FUND_EXCEPTION.getNameFa(), null));
        }

        public NotFund(String msgEn) {
            super(new ResponseApi<>(
                    HttpStatus.NOT_FOUND,
                    PersonInfoMessageError.NOT_FUND_EXCEPTION.getStatusCode(),
                    msgEn,
                    PersonInfoMessageError.NOT_FUND_EXCEPTION.getNameFa(), null));
        }

        public NotFund(String msgEn, String msgFa) {
            super(new ResponseApi<>(
                    HttpStatus.NOT_FOUND,
                    PersonInfoMessageError.NOT_FUND_EXCEPTION.getStatusCode(),
                    msgEn,
                    msgFa, null));
        }

    }
}
