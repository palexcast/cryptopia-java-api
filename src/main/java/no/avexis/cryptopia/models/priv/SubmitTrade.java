package no.avexis.cryptopia.models.priv;

import com.google.gson.annotations.SerializedName;

public class SubmitTrade {
    @SerializedName("OrderId")
    private Long orderId;
    @SerializedName("FilledOrders")
    private Integer[] filledOrders;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer[] getFilledOrders() {
        return filledOrders;
    }

    public void setFilledOrders(Integer[] filledOrders) {
        this.filledOrders = filledOrders;
    }
}
