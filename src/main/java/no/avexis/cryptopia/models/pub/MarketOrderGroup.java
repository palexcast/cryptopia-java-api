package no.avexis.cryptopia.models.pub;

import java.util.List;

public class MarketOrderGroup {
    private Long TradePairId;
    private String Market;
    private List<MarketOrder> Buy;
    private List<MarketOrder> Sell;

    public Long getTradePairId() {
        return TradePairId;
    }

    public void setTradePairId(Long tradePairId) {
        TradePairId = tradePairId;
    }

    public String getMarket() {
        return Market;
    }

    public void setMarket(String market) {
        Market = market;
    }

    public List<MarketOrder> getBuy() {
        return Buy;
    }

    public void setBuy(List<MarketOrder> buy) {
        Buy = buy;
    }

    public List<MarketOrder> getSell() {
        return Sell;
    }

    public void setSell(List<MarketOrder> sell) {
        Sell = sell;
    }
}
