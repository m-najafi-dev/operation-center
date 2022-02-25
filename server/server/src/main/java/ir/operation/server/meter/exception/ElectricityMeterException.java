package ir.operation.server.meter.exception;

import ir.operation.server.meter.exception.enumeration.ElectricityMeterMessageError;
import ir.operation.server.utilities.exception.BaseException;
import ir.operation.server.utilities.exception.enumeration.MessageError;
import ir.operation.server.utilities.protocol.Protocol;
import ir.operation.server.utilities.response.ResponseApi;
import org.springframework.http.HttpStatus;

public class ElectricityMeterException extends BaseException {

    public ElectricityMeterException(String msgEn, String msgFa) {
        super(msgEn, msgFa);
    }

    public ElectricityMeterException(ResponseApi<? extends Protocol> responseApi) {
        super(responseApi);
    }

    public static class BadRequest extends ElectricityMeterException {

        private static final long serialVersionUID = 3555714415375055302L;

        public BadRequest() {
            super(new ResponseApi<>(
                    HttpStatus.BAD_REQUEST,
                    MessageError.BAD_REQUEST_EXCEPTION.getStatusCode(),
                    MessageError.BAD_REQUEST_EXCEPTION.getNameEn(),
                    MessageError.BAD_REQUEST_EXCEPTION.getNameFa(), null));
        }

        public BadRequest(String msgEn) {
            super(new ResponseApi<>(
                    HttpStatus.BAD_REQUEST,
                    ElectricityMeterMessageError.FAILED_OPERATION_EXCEPTION.getStatusCode(),
                    msgEn,
                    MessageError.BAD_REQUEST_EXCEPTION.getNameFa(), null));
        }

        public BadRequest(String msgEn, String msgFa) {
            super(msgEn, msgFa);
        }
    }

    public static class FailedOperation extends ElectricityMeterException {
        private static final long serialVersionUID = 3555714415375055302L;

        public FailedOperation() {
            super(new ResponseApi<>(
                    HttpStatus.EXPECTATION_FAILED,
                    ElectricityMeterMessageError.FAILED_OPERATION_EXCEPTION.getStatusCode(),
                    ElectricityMeterMessageError.FAILED_OPERATION_EXCEPTION.getNameEn(),
                    ElectricityMeterMessageError.FAILED_OPERATION_EXCEPTION.getNameFa(), null));
        }

        public FailedOperation(String msgEn) {
            super(new ResponseApi<>(
                    HttpStatus.EXPECTATION_FAILED,
                    ElectricityMeterMessageError.FAILED_OPERATION_EXCEPTION.getStatusCode(),
                    msgEn,
                    ElectricityMeterMessageError.FAILED_OPERATION_EXCEPTION.getNameFa(), null));
        }

        public FailedOperation(String msgEn, String msgFa) {
            super(msgEn, msgFa);
        }
    }
}
