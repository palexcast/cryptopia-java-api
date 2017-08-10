package no.avexis.cryptopia.models.pub;

public class MarketOrder {
    private Long TradePairId;
    private String Label;
    private double Price;
    private double Volume;
    private double Total;

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

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public double getVolume() {
        return Volume;
    }

    public void setVolume(double volume) {
        Volume = volume;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double total) {
        Total = total;
    }
}
