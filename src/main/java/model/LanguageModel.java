package model;

public class LanguageModel {
    String isoCode;
    String langDescription;
    int order;

    public LanguageModel(String isoCode, String langDescription, int order) {
        this.isoCode = isoCode;
        this.langDescription = langDescription;
        this.order = order;
    }

    @Override
    public String toString(){
        return isoCode;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public String getLangDescription() {
        return langDescription;
    }

    public void setLangDescription(String langDescription) {
        this.langDescription = langDescription;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
