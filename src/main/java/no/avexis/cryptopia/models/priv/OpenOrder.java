package no.avexis.cryptopia.models.priv;

import com.google.gson.annotations.SerializedName;

import java.sql.Timestamp;

public class OpenOrder {
    @SerializedName("TimeStamp")
    private Timestamp timeStamp;
     @SerializedName("Amount")
    private Double amount;
    @SerializedName("Remaining")
    private Double remaining;
    @SerializedName("Type")
    private String type;
    @SerializedName("OrderId")
    private Long orderId;
    @SerializedName("Market")
    private String market;
    @SerializedName("TradePairId")
    private Long tradePairId;
    @SerializedName("Total")
    private Double total;
    @SerializedName("Rate")
    private Double rate;

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getRemaining() {
        return remaining;
    }

    public void setRemaining(Double remaining) {
        this.remaining = remaining;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public Long getTradePairId() {
        return tradePairId;
    }

    public void setTradePairId(Long tradePairId) {
        this.tradePairId = tradePairId;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
