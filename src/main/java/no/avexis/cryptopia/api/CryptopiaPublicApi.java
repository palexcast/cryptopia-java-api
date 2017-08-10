package no.avexis.cryptopia.api;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import no.avexis.cryptopia.client.AbstractCryptopiaClient;
import no.avexis.cryptopia.client.CryptopiaPublicClient;
import no.avexis.cryptopia.models.pub.Currency;
import no.avexis.cryptopia.models.pub.Market;
import no.avexis.cryptopia.models.pub.MarketHistory;
import no.avexis.cryptopia.models.pub.MarketOrderGroup;
import no.avexis.cryptopia.models.pub.MarketOrdersList;
import no.avexis.cryptopia.models.pub.TradePair;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CryptopiaPublicApi extends AbstractCryptopiaApi {

    private static final CryptopiaPublicClient client = new CryptopiaPublicClient();

    public List<Currency> getCurrencies() throws Exception {
        final JsonObject result = client.send("GetCurrencies");
        final JsonElement data = getData(result);
        final Type listType = new TypeToken<ArrayList<Currency>>() {
        }.getType();
        return gson.fromJson(data, listType);
    }

    public List<TradePair> getTradePairs() throws Exception {
        final JsonObject result = client.send("GetTradePairs");
        final JsonElement data = getData(result);
        final Type listType = new TypeToken<ArrayList<TradePair>>() {
        }.getType();
        return gson.fromJson(data, listType);
    }

    public List<Market> getMarkets(final String baseMarket, final Integer hours) throws Exception {
        final String method = addParams("GetMarkets", baseMarket, hours);
        final JsonObject result = client.send(method);
        final JsonElement data = getData(result);
        final Type listType = new TypeToken<ArrayList<Market>>() {
        }.getType();
        return gson.fromJson(data, listType);
    }

    public Market getMarket(final String nameOrId, final Integer hours) throws Exception {
        final String method = addParams("GetMarket", req(nameOrId), hours);
        final JsonObject result = client.send(method);
        final JsonElement data = getData(result);
        return gson.fromJson(data, Market.class);
    }

    public List<MarketHistory> getMarketHistory(final String nameOrId, final Integer hours) throws Exception {
        final String method = addParams("GetMarketHistory", req(nameOrId), hours);
        final JsonObject result = client.send(method);
        final JsonElement data = getData(result);
        final Type listType = new TypeToken<ArrayList<MarketHistory>>() {
        }.getType();
        return gson.fromJson(data, listType);
    }


    public List<MarketOrdersList> getMarketOrders(final String nameOrId, final Integer count) throws Exception {
        final String method = addParams("GetMarketOrders", req(nameOrId), count);
        final JsonObject result = client.send(method);
        final JsonElement data = getData(result);
        final Type listType = new TypeToken<ArrayList<MarketOrdersList>>() {
        }.getType();
        return gson.fromJson(data, listType);
    }

    public List<MarketOrderGroup> getMarketOrderGroups(final String[] markets, final Integer count) throws Exception {
        final String marketsAsString = arrayAsString(req(markets));
        final String method = addParams("GetMarketOrderGroups", marketsAsString, count);
        final JsonObject result = client.send(method);
        final JsonElement data = getData(result);
        final Type listType = new TypeToken<ArrayList<MarketOrderGroup>>() {
        }.getType();
        return gson.fromJson(data, listType);
    }

}
