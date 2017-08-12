package no.avexis.cryptopia.models.pub;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MarketOrdersList {
    @SerializedName("Buy")
    private List<MarketOrder> buy;
    @SerializedName("Sell")
    private List<MarketOrder> sell;

    public List<MarketOrder> getBuy() {
        return buy;
    }

    public void setBuy(List<MarketOrder> buy) {
        this.buy = buy;
    }

    public List<MarketOrder> getSell() {
        return sell;
    }

    public void setSell(List<MarketOrder> sell) {
        this.sell = sell;
    }
}
