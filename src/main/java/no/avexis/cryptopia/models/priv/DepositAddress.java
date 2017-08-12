package no.avexis.cryptopia.models.priv;

import javax.xml.bind.annotation.XmlElement;

public class DepositAddress {
    @XmlElement(name = "Currency")
    private String currency;
    @XmlElement(name = "Address")
    private String address;
    @XmlElement(name = "BaseAddress")
    private String baseAddress;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBaseAddress() {
        return baseAddress;
    }

    public void setBaseAddress(String baseAddress) {
        this.baseAddress = baseAddress;
    }
}
