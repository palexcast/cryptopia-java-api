package no.avexis.cryptopia.api;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import no.avexis.cryptopia.client.CryptopiaPublicClient;
import no.avexis.cryptopia.exceptions.CryptopiaException;
import no.avexis.cryptopia.models.pub.*;

import java.util.List;

public class CryptopiaPublicApi extends AbstractCryptopiaApi {

    private static final String NAME_ID = "Name or Id";
    private static final String MARKETS = "Markets";

    private static final CryptopiaPublicClient client = new CryptopiaPublicClient();

    public List<Currency> getCurrencies() throws CryptopiaException {
        final JsonObject result = client.send("GetCurrencies");
        final JsonElement data = getData(result);
        return fromJson(data);
    }

    public List<TradePair> getTradePairs() throws CryptopiaException {
        final JsonObject result = client.send("GetTradePairs");
        final JsonElement data = getData(result);
        return fromJson(data);
    }

    public List<Market> getMarkets(final String baseMarket, final Integer hours) throws CryptopiaException {
        final String method = addParams("GetMarkets", baseMarket, hours);
        final JsonObject result = client.send(method);
        final JsonElement data = getData(result);
        return fromJson(data);
    }

    public Market getMarket(final String nameOrId, final Integer hours) throws CryptopiaException {
        req(NAME_ID, nameOrId);

        final String method = addParams("GetMarket", nameOrId, hours);
        final JsonObject result = client.send(method);
        final JsonElement data = getData(result);
        return fromJson(data);
    }

    public List<MarketHistory> getMarketHistory(final String nameOrId, final Integer hours) throws CryptopiaException {
        req(NAME_ID, nameOrId);
        final String method = addParams("GetMarketHistory", nameOrId, hours);
        final JsonObject result = client.send(method);
        final JsonElement data = getData(result);
        return fromJson(data);
    }


    public List<MarketOrdersList> getMarketOrders(final String nameOrId, final Integer count) throws CryptopiaException {
        req(NAME_ID, nameOrId);
        final String method = addParams("GetMarketOrders", nameOrId, count);
        final JsonObject result = client.send(method);
        final JsonElement data = getData(result);
        return fromJson(data);
    }

    public List<MarketOrderGroup> getMarketOrderGroups(final String[] markets, final Integer count) throws CryptopiaException {
        reqArray(MARKETS, markets);
        final String method = addParams("GetMarketOrderGroups", arrayAsString(markets), count);
        final JsonObject result = client.send(method);
        final JsonElement data = getData(result);
        return fromJson(data);
    }

}
