package ir.operation.server.person.exception.enumeration;

/*
mehran, 2/22/2022, 9:49 AM
*/
public enum PersonInfoMessageError {
    NOT_FUND_EXCEPTION(404L, "شماره مشترک مورد نظر در سیستم ثبت نشده است", "PersonNotFundException"),
    BAD_REQUEST_EXCEPTION(400L, "اطلاعات ارسال شده مشترک مورد نظر صحیح نمی باشد", "PersonNotFundException");
    private final long statusCode;
    private final String nameFa;
    private final String nameEn;

    PersonInfoMessageError(long statusCode, String nameFa, String nameEn) {
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
