package no.avexis.cryptopia.models.pub;

import com.google.gson.annotations.SerializedName;

public class Market {
    @SerializedName("TradePairId")
    private Long tradePairId;
    @SerializedName("Label")
    private String label;
    @SerializedName("AskPrice")
    private double askPrice;
    @SerializedName("BidPrice")
    private double bidPrice;
    @SerializedName("Low")
    private double low;
    @SerializedName("High")
    private double high;
    @SerializedName("Volume")
    private double volume;
    @SerializedName("LastPrice")
    private double lastPrice;
    @SerializedName("BuyVolume")
    private double buyVolume;
    @SerializedName("SellVolume")
    private double sellVolume;
    @SerializedName("Change")
    private double change;
    @SerializedName("Open")
    private double open;
    @SerializedName("Close")
    private double close;
    @SerializedName("BaseVolume")
    private double baseVolume;
    @SerializedName("BaseBuyVolume")
    private double baseBuyVolume;
    @SerializedName("BaseSellVolume")
    private double baseSellVolume;

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

    public double getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(double askPrice) {
        this.askPrice = askPrice;
    }

    public double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(double lastPrice) {
        this.lastPrice = lastPrice;
    }

    public double getBuyVolume() {
        return buyVolume;
    }

    public void setBuyVolume(double buyVolume) {
        this.buyVolume = buyVolume;
    }

    public double getSellVolume() {
        return sellVolume;
    }

    public void setSellVolume(double sellVolume) {
        this.sellVolume = sellVolume;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getBaseVolume() {
        return baseVolume;
    }

    public void setBaseVolume(double baseVolume) {
        this.baseVolume = baseVolume;
    }

    public double getBaseBuyVolume() {
        return baseBuyVolume;
    }

    public void setBaseBuyVolume(double baseBuyVolume) {
        this.baseBuyVolume = baseBuyVolume;
    }

    public double getBaseSellVolume() {
        return baseSellVolume;
    }

    public void setBaseSellVolume(double baseSellVolume) {
        this.baseSellVolume = baseSellVolume;
    }
}
