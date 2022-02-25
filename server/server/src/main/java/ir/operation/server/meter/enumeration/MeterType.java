package ir.operation.server.meter.enumeration;

public enum MeterType {
    Homemade(0L, "خانگی", "Homemade"),
    Commercial(1L, "تجاری", "Commercial");

    private long id;
    private String nameFa;
    private String nameEn;

    MeterType(long id, String nameFa, String nameEn) {
        this.id = id;
        this.nameFa = nameFa;
        this.nameEn = nameEn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameFa() {
        return nameFa;
    }

    public void setNameFa(String nameFa) {
        this.nameFa = nameFa;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }
}
