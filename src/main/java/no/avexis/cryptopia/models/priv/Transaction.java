package no.avexis.cryptopia.models.priv;

import com.google.gson.annotations.SerializedName;

import java.sql.Timestamp;

public class Transaction {
    @SerializedName("TimeStamp")
    private Timestamp timeStamp;
    @SerializedName("Status")
    private String status;
    @SerializedName("Amount")
    private Double amount;
    @SerializedName("Confirmations")
    private Long confirmations;
    @SerializedName("Fee")
    private Double fee;
    @SerializedName("Type")
    private String type;
    @SerializedName("Address")
    private String address;
    @SerializedName("TxId")
    private String txId;
    @SerializedName("Id")
    private Long id;

    @SerializedName("currency")
    private String currency;

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getConfirmations() {
        return confirmations;
    }

    public void setConfirmations(Long confirmations) {
        this.confirmations = confirmations;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
