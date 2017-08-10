package no.avexis.cryptopia.models.pub;

import java.util.List;

public class MarketOrdersList {
    private List<MarketOrder> Buy;
    private List<MarketOrder> Sell;

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
