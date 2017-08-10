package no.avexis.cryptopia.models.priv;

public class Balance {
    private Long CurrencyId;
    private String Symbol;
    private double Total;
    private double Available;
    private double Unconfirmed;
    private double HeldForTrades;
    private double PendingWithdraw0;
    private String Address;
    private String BaseAddress;
    private String Status;
    private String StatusMessage;

    public Long getCurrencyId() {
        return CurrencyId;
    }

    public void setCurrencyId(Long currencyId) {
        CurrencyId = currencyId;
    }

    public String getSymbol() {
        return Symbol;
    }

    public void setSymbol(String symbol) {
        Symbol = symbol;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double total) {
        Total = total;
    }

    public double getAvailable() {
        return Available;
    }

    public void setAvailable(double available) {
        Available = available;
    }

    public double getUnconfirmed() {
        return Unconfirmed;
    }

    public void setUnconfirmed(double unconfirmed) {
        Unconfirmed = unconfirmed;
    }

    public double getHeldForTrades() {
        return HeldForTrades;
    }

    public void setHeldForTrades(double heldForTrades) {
        HeldForTrades = heldForTrades;
    }

    public double getPendingWithdraw0() {
        return PendingWithdraw0;
    }

    public void setPendingWithdraw0(double pendingWithdraw0) {
        PendingWithdraw0 = pendingWithdraw0;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getBaseAddress() {
        return BaseAddress;
    }

    public void setBaseAddress(String baseAddress) {
        BaseAddress = baseAddress;
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
}
