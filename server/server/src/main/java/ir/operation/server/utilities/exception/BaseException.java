package ir.operation.server.utilities.exception;

import ir.operation.server.utilities.response.ResponseApi;
import ir.operation.server.utilities.protocol.Protocol;

public abstract class BaseException extends RuntimeException {
    private final String messageEn;
    private final String messageFa;

    private ResponseApi<? extends Protocol> responseApi;

    public BaseException(String msgEn, String msgFa) {
        this.messageEn = msgEn;
        this.messageFa = msgFa;
    }

    public BaseException(ResponseApi<? extends Protocol> responseApi) {
        this.responseApi = responseApi;
        this.messageEn = responseApi.getMessageEn();
        this.messageFa = responseApi.getMessageFa();
    }


    public String getMessageEn() {
        return messageEn;
    }

    public String getMessageFa() {
        return messageFa;
    }

    public ResponseApi<? extends Protocol> getResponseApi() {
        return responseApi;
    }
}
