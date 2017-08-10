package no.avexis.cryptopia.models.pub;

public class MarketHistory {
    private Long TradePairId;
    private String Label;
    private String Type;
    private double Price;
    private double Amount;
    private double Total;
    private double Timestamp;

    public Long getTradePairId() {
        return TradePairId;
    }

    public void setTradePairId(Long tradePairId) {
        TradePairId = tradePairId;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double total) {
        Total = total;
    }

    public double getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(double timestamp) {
        Timestamp = timestamp;
    }
}
