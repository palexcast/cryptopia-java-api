package no.avexis.cryptopia.api;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import javafx.util.Pair;
import no.avexis.cryptopia.client.CryptopiaPrivateClient;
import no.avexis.cryptopia.exceptions.CryptopiaException;
import no.avexis.cryptopia.models.priv.*;
import no.avexis.cryptopia.utils.JsonUtils;

import java.util.Arrays;
import java.util.List;

public class CryptopiaPrivateApi extends AbstractCryptopiaApi {

    private static final String ACTIVE_USERS = "ActiveUsers";
    private static final String ADDRESS = "Address";
    private static final String AMOUNT = "Amount";
    private static final String COUNT = "Count";
    private static final String CURRENCY = "Currency";
    private static final String CURRENCY_ID = "CurrencyId";
    private static final String MARKET = "Market";
    private static final String ORDER_ID = "OrderId";
    private static final String PAYMENT_ID = "PaymentId";
    private static final String RATE = "Rate";
    private static final String TRADE_PAIR_ID = "TradePairId";
    private static final String TYPE = "Type";
    private static final String USERNAME = "Username";

    private static final String SUCCESS = "Success";

    private final CryptopiaPrivateClient client;

    public CryptopiaPrivateApi(final String publicKey, final String privateKey) {
        client = new CryptopiaPrivateClient(publicKey, privateKey);
    }

    public List<Balance> getBalance(final String currency, final Integer currencyId) throws CryptopiaException {
        final Pair<String, Object> currencyParam = new Pair<>(CURRENCY, currency);
        final Pair<String, Object> currencyIdParam = new Pair<>(CURRENCY_ID, currencyId);

        final JsonObject params = JsonUtils.toJsonObject(Arrays.asList(currencyParam, currencyIdParam));
        final JsonObject result = client.send("GetBalance", params);
        final JsonElement data = JsonUtils.getData(result);
        return JsonUtils.fromJson(data, new TypeToken<List<Balance>>() {
        }.getType());
    }

    public DepositAddress getDepositAddress(final String currency, final Integer currencyId) throws CryptopiaException {
        final Pair<String, Object> currencyParam = new Pair<>(CURRENCY, currency);
        final Pair<String, Object> currencyIdParam = new Pair<>(CURRENCY_ID, currencyId);

        either(currencyParam, currencyIdParam);

        final JsonObject params = JsonUtils.toJsonObject(Arrays.asList(currencyParam, currencyIdParam));
        final JsonObject result = client.send("GetDepositAddress", params);
        final JsonElement data = JsonUtils.getData(result);
        return JsonUtils.fromJson(data, DepositAddress.class);
    }


    public List<TradeHistory> getTradeHistory(final String market, final Integer tradePairId, final Integer count) throws CryptopiaException {
        final Pair<String, Object> marketParam = new Pair<>(MARKET, market);
        final Pair<String, Object> tradePairIdParam = new Pair<>(TRADE_PAIR_ID, tradePairId);
        final Pair<String, Object> countParam = new Pair<>(COUNT, count);

        either(marketParam, tradePairIdParam);

        final JsonObject params = JsonUtils.toJsonObject(Arrays.asList(marketParam, tradePairIdParam, countParam));
        final JsonObject result = client.send("GetTradeHistory", params);
        final JsonElement data = JsonUtils.getData(result);
        return JsonUtils.fromJson(data, new TypeToken<List<TradeHistory>>() {
        }.getType());
    }

    public List<Transaction> getTransactions(final String type, final Integer count) throws CryptopiaException {
        final Pair<String, Object> typeParam = new Pair<>(TYPE, type);
        final Pair<String, Object> countParam = new Pair<>(COUNT, count);

        req(typeParam);

        final JsonObject params = JsonUtils.toJsonObject(Arrays.asList(typeParam, countParam));
        final JsonObject result = client.send("GetTransactions", params);
        final JsonElement data = JsonUtils.getData(result);
        return JsonUtils.fromJson(data, new TypeToken<List<Transaction>>() {
        }.getType());
    }

    public List<SubmitTrade> submitTrade(final String market, final Integer tradePairId, final String type, final Double rate, final Double amount) throws CryptopiaException {
        final Pair<String, Object> marketParam = new Pair<>(MARKET, market);
        final Pair<String, Object> tradePairIdParam = new Pair<>(TRADE_PAIR_ID, tradePairId);
        final Pair<String, Object> typeParam = new Pair<>(TYPE, type);
        final Pair<String, Object> rateParam = new Pair<>(RATE, rate);
        final Pair<String, Object> amountParam = new Pair<>(AMOUNT, amount);

        req(typeParam);
        req(rateParam);
        req(amountParam);
        either(marketParam, tradePairIdParam);

        final JsonObject params = JsonUtils.toJsonObject(Arrays.asList(marketParam, tradePairIdParam, typeParam, rateParam, amountParam));
        final JsonObject result = client.send("SubmitTrade", params);
        final JsonElement data = JsonUtils.getData(result);
        return JsonUtils.fromJson(data, new TypeToken<SubmitTrade>() {
        }.getType());
    }

    public String cancelTrade(final String type, final Integer orderId, final Integer tradePairId) throws CryptopiaException {
        final Pair<String, Object> typeParam = new Pair<>(TYPE, type);
        final Pair<String, Object> orderIdParam = new Pair<>(ORDER_ID, orderId);
        final Pair<String, Object> tradePairIdParam = new Pair<>(TRADE_PAIR_ID, tradePairId);

        req(tradePairIdParam);
        reqIfIs(orderId, type.toLowerCase(), "trade");
        reqIfIs(tradePairId, type.toLowerCase(), "tradepair");

        final JsonObject params = JsonUtils.toJsonObject(Arrays.asList(typeParam, orderIdParam, tradePairIdParam));
        final JsonObject result = client.send("CancelTrade", params);
        return result.get(SUCCESS).toString() + ": " + JsonUtils.getData(result).toString();
    }

    public String submitTip(final String currency, final Integer currencyId, final Integer activeUsers, final Double amount) throws CryptopiaException {
        final Pair<String, Object> currencyParam = new Pair<>(CURRENCY, currency);
        final Pair<String, Object> currencyIdParam = new Pair<>(CURRENCY_ID, currencyId);
        final Pair<String, Object> activeUsersParam = new Pair<>(ACTIVE_USERS, activeUsers);
        final Pair<String, Object> amountParam = new Pair<>(AMOUNT, amount);

        req(amountParam);
        either(currencyParam, currencyIdParam);

        if (null == activeUsers || activeUsers < 2 || activeUsers > 100) {
            throw new NullPointerException("ActiveUsers is invalid");
        }
        final JsonObject params = JsonUtils.toJsonObject(Arrays.asList(currencyParam, currencyIdParam, activeUsersParam, amountParam));
        final JsonObject result = client.send("SubmitTip", params);
        return result.get(SUCCESS).toString() + ": " + JsonUtils.getData(result).toString();
    }

    public String submitWithdraw(final String currency, final Integer currencyId, final String address, final Integer paymentId, final Double amount) throws CryptopiaException {
        final Pair<String, Object> currencyParam = new Pair<>(CURRENCY, currency);
        final Pair<String, Object> currencyIdParam = new Pair<>(CURRENCY_ID, currencyId);
        final Pair<String, Object> addressParam = new Pair<>(ADDRESS, address);
        final Pair<String, Object> paymentIdParam = new Pair<>(PAYMENT_ID, paymentId);
        final Pair<String, Object> amountParam = new Pair<>(AMOUNT, amount);

        req(addressParam);
        req(paymentIdParam);
        req(amountParam);
        either(currencyParam, currencyIdParam);

        final JsonObject params = JsonUtils.toJsonObject(Arrays.asList(currencyParam, currencyIdParam, addressParam, paymentIdParam, amountParam));
        final JsonObject result = client.send("SubmitWithdraw", params);
        return result.get(SUCCESS).toString() + ": " + JsonUtils.getData(result).toString();
    }

    public String submitTransfer(final String currency, final Integer currencyId, final String username, final Double amount) throws CryptopiaException {
        final Pair<String, Object> currencyParam = new Pair<>(CURRENCY, currency);
        final Pair<String, Object> currencyIdParam = new Pair<>(CURRENCY_ID, currencyId);
        final Pair<String, Object> usernameParam = new Pair<>(USERNAME, username);
        final Pair<String, Object> amountParam = new Pair<>(AMOUNT, amount);

        req(usernameParam);
        req(amountParam);
        either(currencyParam, currencyIdParam);

        final JsonObject params = JsonUtils.toJsonObject(Arrays.asList(currencyParam, currencyIdParam, usernameParam, amountParam));
        final JsonObject result = client.send("SubmitTransfer", params);
        return result.get(SUCCESS).toString() + ": " + JsonUtils.getData(result).toString();
    }
}
