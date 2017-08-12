package no.avexis.cryptopia.models.pub;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MarketOrderGroup {
    @SerializedName("TradePairId")
    private Long tradePairId;
    @SerializedName("Market")
    private String market;
    @SerializedName("Buy")
    private List<MarketOrder> buy;
    @SerializedName("Sell")
    private List<MarketOrder> sell;

    public Long getTradePairId() {
        return tradePairId;
    }

    public void setTradePairId(Long tradePairId) {
        this.tradePairId = tradePairId;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

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
