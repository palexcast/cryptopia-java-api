package no.avexis.cryptopia.models.pub;

import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.XmlElement;

public class Currency {
    @SerializedName("DepositConfirmations")
    private Long depositConfirmations;
    @SerializedName("MinTip")
    private Double minTip;
    @SerializedName("MinBaseTrade")
    private Double minBaseTrade;
    @SerializedName("Name")
    private String name;
    @SerializedName("Status")
    private String status;
    @SerializedName("WithdrawFee")
    private Double withdrawFee;
    @SerializedName("IsTipEnabled")
    private Boolean isTipEnabled;
    @SerializedName("Symbol")
    private String symbol;
    @SerializedName("StatusMessage")
    private String statusMessage;
    @SerializedName("Algorithm")
    private String algorithm;
    @SerializedName("Id")
    private Long id;
    @SerializedName("ListingStatus")
    private String listingStatus;
    @SerializedName("MinWithdraw")
    private Double minWithdraw;

    public Long getDepositConfirmations() {
        return depositConfirmations;
    }

    public void setDepositConfirmations(Long depositConfirmations) {
        this.depositConfirmations = depositConfirmations;
    }

    public Double getMinTip() {
        return minTip;
    }

    public void setMinTip(Double minTip) {
        this.minTip = minTip;
    }

    public Double getMinBaseTrade() {
        return minBaseTrade;
    }

    public void setMinBaseTrade(Double minBaseTrade) {
        this.minBaseTrade = minBaseTrade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getWithdrawFee() {
        return withdrawFee;
    }

    public void setWithdrawFee(Double withdrawFee) {
        this.withdrawFee = withdrawFee;
    }

    public Boolean getTipEnabled() {
        return isTipEnabled;
    }

    public void setTipEnabled(Boolean tipEnabled) {
        isTipEnabled = tipEnabled;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getListingStatus() {
        return listingStatus;
    }

    public void setListingStatus(String listingStatus) {
        this.listingStatus = listingStatus;
    }

    public Double getMinWithdraw() {
        return minWithdraw;
    }

    public void setMinWithdraw(Double minWithdraw) {
        this.minWithdraw = minWithdraw;
    }
}
