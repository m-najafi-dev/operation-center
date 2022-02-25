package ir.operation.server.meter.exception.enumeration;

/*
mehran, 2/22/2022, 9:49 AM
*/
public enum ElectricityMeterMessageError {
    NOT_FUND_EXCEPTION(404L, "اطلاعات کنتور مورد نظر یافت نشد", "ElectricityMeterNotFundException"),
    FAILED_OPERATION_EXCEPTION(417L, "عملیات ذخیره کنتور جدید شکست خورد", "ElectricityMeterFailedOperationSaveExecution");

    private final long statusCode;
    private final String nameFa;
    private final String nameEn;

    ElectricityMeterMessageError(long statusCode, String nameFa, String nameEn) {
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
