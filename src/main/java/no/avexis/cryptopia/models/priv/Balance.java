package no.avexis.cryptopia.models.priv;

import com.google.gson.annotations.SerializedName;

public class Balance {
    @SerializedName("CurrencyId")
    private Long currencyId;
    @SerializedName("Symbol")
    private String symbol;
    @SerializedName("Total")
    private double total;
    @SerializedName("Available")
    private double available;
    @SerializedName("Unconfirmed")
    private double unconfirmed;
    @SerializedName("HeldForTrades")
    private double heldForTrades;
    @SerializedName("PendingWithdraw")
    private double pendingWithdraw;
    @SerializedName("Address")
    private String address;
    @SerializedName("BaseAddress")
    private String baseAddress;
    @SerializedName("Status")
    private String status;
    @SerializedName("StatusMessage")
    private String statusMessage;

    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        currencyId = currencyId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getAvailable() {
        return available;
    }

    public void setAvailable(double available) {
        this.available = available;
    }

    public double getUnconfirmed() {
        return unconfirmed;
    }

    public void setUnconfirmed(double unconfirmed) {
        this.unconfirmed = unconfirmed;
    }

    public double getHeldForTrades() {
        return heldForTrades;
    }

    public void setHeldForTrades(double heldForTrades) {
        this.heldForTrades = heldForTrades;
    }

    public double getPendingWithdraw() {
        return pendingWithdraw;
    }

    public void setPendingWithdraw(double pendingWithdraw) {
        this.pendingWithdraw = pendingWithdraw;
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
}
