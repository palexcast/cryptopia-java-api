package no.avexis.cryptopia.models.pub;

import com.google.gson.annotations.SerializedName;

public class MarketHistory {
    @SerializedName("TradePairId")
    private Long tradePairId;
    @SerializedName("Label")
    private String label;
    @SerializedName("Type")
    private String type;
    @SerializedName("Price")
    private double price;
    @SerializedName("Amount")
    private double amount;
    @SerializedName("Total")
    private double total;
    @SerializedName("Timestamp")
    private double timestamp;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(double timestamp) {
        this.timestamp = timestamp;
    }
}
