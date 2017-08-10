package no.avexis.cryptopia.api;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import javafx.util.Pair;
import no.avexis.cryptopia.client.CryptopiaPrivateClient;
import no.avexis.cryptopia.models.priv.Balance;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CryptopiaPrivateApi extends AbstractCryptopiaApi {

    private final CryptopiaPrivateClient client;

    public CryptopiaPrivateApi(final String publicKey, final String privateKey) {
        client = new CryptopiaPrivateClient(publicKey, privateKey);
    }

    public List<Balance> getBalance(final String currency, final Integer currencyId) throws Exception {
        final JsonObject params = toJsonObject(new Pair<>("Currency", currency), new Pair<>("CurrencyId", currencyId));
        final JsonObject result = client.send("GetBalance", params);
        final JsonElement data = getData(result);
        final Type listType = new TypeToken<ArrayList<Balance>>() {
        }.getType();
        return gson.fromJson(data, listType);
    }

    public List<Balance> getDepositAddress(final String currency, final Integer currencyId) throws Exception {
        either(currency, currencyId);
        final JsonObject params = toJsonObject(new Pair<>("Currency", currency), new Pair<>("CurrencyId", currencyId));
        final JsonObject result = client.send("GetDepositAddress", params);
        final JsonElement data = getData(result);
        final Type listType = new TypeToken<ArrayList<Balance>>() {
        }.getType();
        return gson.fromJson(data, listType);
    }


    public List<Balance> getTradeHistory(final String market, final Integer tradePairId, final Integer count) throws Exception {
        either(market, tradePairId);
        final JsonObject params = toJsonObject(new Pair<>("Market", market), new Pair<>("TradePairId", tradePairId), new Pair<>("Count", count));
        final JsonObject result = client.send("GetTradeHistory", params);
        final JsonElement data = getData(result);
        final Type listType = new TypeToken<ArrayList<Balance>>() {
        }.getType();
        return gson.fromJson(data, listType);
    }

    public List<Balance> getTransactions(final String type, final Integer count) throws Exception {
        final JsonObject params = toJsonObject(new Pair<>("Type", req(type)), new Pair<>("Count", count));
        final JsonObject result = client.send("GetTransactions", params);
        final JsonElement data = getData(result);
        final Type listType = new TypeToken<ArrayList<Balance>>() {
        }.getType();
        return gson.fromJson(data, listType);
    }

    public List<Balance> submitTrade(final String market, final Integer tradePairId, final String type, final Double rate, final Double amount) throws Exception {
        either(market, tradePairId);
        final JsonObject params = toJsonObject(new Pair<>("Market", market), new Pair<>("TradePairId", tradePairId),
                new Pair<>("Type", req(type)), new Pair<>("Rate", req(rate)), new Pair<>("Amount", req(amount)));
        final JsonObject result = client.send("SubmitTrade", params);
        final JsonElement data = getData(result);
        final Type listType = new TypeToken<ArrayList<Balance>>() {
        }.getType();
        return gson.fromJson(data, listType);
    }

    public String cancelTrade(final String type, final Integer orderId, final Integer tradePairId) throws Exception {
        reqIfIs(orderId, type.toLowerCase(), "trade");
        reqIfIs(tradePairId, type.toLowerCase(), "tradepair");
        final JsonObject params = toJsonObject(new Pair<>("Type", req(type)), new Pair<>("OrderId", orderId), new Pair<>("TradePairId", tradePairId));
        final JsonObject result = client.send("CancelTrade", params);
        return result.get("Success").toString() + ": " + getData(result).toString();
    }

    public String submitTip(final String currency, final Integer currencyId, final Integer activeUsers, final Double amount) throws Exception {
        either(currency, currencyId);
        if (null == activeUsers || activeUsers < 2 || activeUsers > 100) {
            throw new NullPointerException("ActiveUsers is invalid");
        }
        final JsonObject params = toJsonObject(new Pair<>("Currency", currency), new Pair<>("CurrencyId", currencyId),
                new Pair<>("ActiveUsers", activeUsers), new Pair<>("Amount", req(amount)));
        final JsonObject result = client.send("SubmitTip", params);
        return result.get("Success").toString() + ": " + getData(result).toString();
    }

    public String submitWithdraw(final String currency, final Integer currencyId, final String address, final Integer paymentId, final Double amount) throws Exception {
        either(currency, currencyId);
        final JsonObject params = toJsonObject(new Pair<>("Currency", currency), new Pair<>("CurrencyId", currencyId),
                new Pair<>("Address", req(address)), new Pair<>("PaymentId", req(paymentId)), new Pair<>("Amount", req(amount)));
        final JsonObject result = client.send("SubmitWithdraw", params);
        return result.get("Success").toString() + ": " + getData(result).toString();
    }

    public String submitTransfer(final String currency, final Integer currencyId, final String username, final Double amount) throws Exception {
        either(currency, currencyId);
        final JsonObject params = toJsonObject(new Pair<>("Currency", currency), new Pair<>("CurrencyId", currencyId),
                new Pair<>("Username", req(username)), new Pair<>("Amount", req(amount)));
        final JsonObject result = client.send("SubmitTransfer", params);
        return result.get("Success").toString() + ": " + getData(result).toString();
    }
}
