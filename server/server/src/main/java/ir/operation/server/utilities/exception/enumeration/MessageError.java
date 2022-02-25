package ir.operation.server.utilities.exception.enumeration;

/*
mehran, 2/22/2022, 9:49 AM
*/
public enum MessageError {
    BAD_REQUEST_EXCEPTION(400L, "اطلاعات ارسال شده صحیح نمی باشد", "TheValuesSentAreIncorrectPersonException"),
    FAILED_OPERATION_EXCEPTION(417L, "عملیات ذخیره اطلاعات شکست خورد", "FailedOperationSaveExecution");
    private final long statusCode;
    private final String nameFa;
    private final String nameEn;

    MessageError(long statusCode, String nameFa, String nameEn) {
        this.statusCode = statusCode;
        this.nameFa = nameFa;
        this.nameEn = nameEn;
    }

    public long getStatusCode() {
        return statusCode;
    }

    public String getNameFa() {
        return nameFa;
    }

    public String getNameEn() {
        return nameEn;
    }
}
