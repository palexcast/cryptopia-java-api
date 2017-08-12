package no.avexis.cryptopia.models.pub;

import com.google.gson.annotations.SerializedName;

public class TradePair {
    @SerializedName("Id")
    private long id;
    @SerializedName("Label")
    private String label;
    @SerializedName("Currency")
    private String currency;
    @SerializedName("Symbol")
    private String symbol;
    @SerializedName("BaseCurrency")
    private String baseCurrency;
    @SerializedName("BaseSymbol")
    private String baseSymbol;
    @SerializedName("Status")
    private String status;
    @SerializedName("StatusMessage")
    private String statusMessage;
    @SerializedName("TradeFee")
    private double tradeFee;
    @SerializedName("MinimumTrade")
    private double minimumTrade;
    @SerializedName("MaximumTrade")
    private double maximumTrade;
    @SerializedName("MinimumBaseTrade")
    private double minimumBaseTrade;
    @SerializedName("MaximumBaseTrade")
    private double maximumBaseTrade;
    @SerializedName("MinimumPrice")
    private double minimumPrice;
    @SerializedName("MaximumPrice")
    private double maximumPrice;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getBaseSymbol() {
        return baseSymbol;
    }

    public void setBaseSymbol(String baseSymbol) {
        this.baseSymbol = baseSymbol;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public double getTradeFee() {
        return tradeFee;
    }

    public void setTradeFee(double tradeFee) {
        this.tradeFee = tradeFee;
    }

    public double getMinimumTrade() {
        return minimumTrade;
    }

    public void setMinimumTrade(double minimumTrade) {
        this.minimumTrade = minimumTrade;
    }

    public double getMaximumTrade() {
        return maximumTrade;
    }

    public void setMaximumTrade(double maximumTrade) {
        this.maximumTrade = maximumTrade;
    }

    public double getMinimumBaseTrade() {
        return minimumBaseTrade;
    }

    public void setMinimumBaseTrade(double minimumBaseTrade) {
        this.minimumBaseTrade = minimumBaseTrade;
    }

    public double getMaximumBaseTrade() {
        return maximumBaseTrade;
    }

    public void setMaximumBaseTrade(double maximumBaseTrade) {
        this.maximumBaseTrade = maximumBaseTrade;
    }

    public double getMinimumPrice() {
        return minimumPrice;
    }

    public void setMinimumPrice(double minimumPrice) {
        this.minimumPrice = minimumPrice;
    }

    public double getMaximumPrice() {
        return maximumPrice;
    }

    public void setMaximumPrice(double maximumPrice) {
        this.maximumPrice = maximumPrice;
    }
}
