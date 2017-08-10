package no.avexis.cryptopia.models.pub;

public class TradePair {
    private long Id;
    private String Label;
    private String Currency;
    private String Symbol;
    private String BaseCurrency;
    private String BaseSymbol;
    private String Status;
    private String StatusMessage;
    private double TradeFee;
    private double MinimumTrade;
    private double MaximumTrade;
    private double MinimumBaseTrade;
    private double MaximumBaseTrade;
    private double MinimumPrice;
    private double MaximumPrice;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        Currency = currency;
    }

    public String getSymbol() {
        return Symbol;
    }

    public void setSymbol(String symbol) {
        Symbol = symbol;
    }

    public String getBaseCurrency() {
        return BaseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        BaseCurrency = baseCurrency;
    }

    public String getBaseSymbol() {
        return BaseSymbol;
    }

    public void setBaseSymbol(String baseSymbol) {
        BaseSymbol = baseSymbol;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getStatusMessage() {
        return StatusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        StatusMessage = statusMessage;
    }

    public double getTradeFee() {
        return TradeFee;
    }

    public void setTradeFee(double tradeFee) {
        TradeFee = tradeFee;
    }

    public double getMinimumTrade() {
        return MinimumTrade;
    }

    public void setMinimumTrade(double minimumTrade) {
        MinimumTrade = minimumTrade;
    }

    public double getMaximumTrade() {
        return MaximumTrade;
    }

    public void setMaximumTrade(double maximumTrade) {
        MaximumTrade = maximumTrade;
    }

    public double getMinimumBaseTrade() {
        return MinimumBaseTrade;
    }

    public void setMinimumBaseTrade(double minimumBaseTrade) {
        MinimumBaseTrade = minimumBaseTrade;
    }

    public double getMaximumBaseTrade() {
        return MaximumBaseTrade;
    }

    public void setMaximumBaseTrade(double maximumBaseTrade) {
        MaximumBaseTrade = maximumBaseTrade;
    }

    public double getMinimumPrice() {
        return MinimumPrice;
    }

    public void setMinimumPrice(double minimumPrice) {
        MinimumPrice = minimumPrice;
    }

    public double getMaximumPrice() {
        return MaximumPrice;
    }

    public void setMaximumPrice(double maximumPrice) {
        MaximumPrice = maximumPrice;
    }
}
