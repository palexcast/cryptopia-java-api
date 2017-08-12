package no.avexis.cryptopia.models.pub;

import com.google.gson.annotations.SerializedName;

public class MarketOrder {
    @SerializedName("TradePairId")
    private Long tradePairId;
    @SerializedName("Label")
    private String label;
    @SerializedName("Price")
    private double price;
    @SerializedName("Volume")
    private double volume;
    @SerializedName("Total")
    private double total;

    public Long getTradePairId() {
        return tradePairId;
    }

    public void setTradePairId(Long tradePairId) {
        this.tradePairId = tradePairId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
