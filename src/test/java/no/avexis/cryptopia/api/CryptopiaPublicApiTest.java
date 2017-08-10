package no.avexis.cryptopia.api;

import org.junit.Before;
import org.junit.Test;

public class CryptopiaPublicApiTest {
    private CryptopiaPublicApi api;

    @Before
    public void before() {
        api = new CryptopiaPublicApi();
    }

    @Test
    public void getCurrencies() throws Exception {
        api.getCurrencies();
    }

    @Test
    public void getTradePairs() throws Exception {
        api.getTradePairs();
    }

    @Test
    public void getMarkets_ValidBothHaveValues() throws Exception {
        api.getMarkets("something", 24);
    }

    @Test
    public void getMarkets_ValidBothNull() throws Exception {
        api.getMarkets(null, null);
    }

    @Test
    public void getMarkets_ValidBaseMarketNull() throws Exception {
        api.getMarkets(null, 24);
    }

    @Test
    public void getMarkets_ValidHoursNull() throws Exception {
        api.getMarkets("something", null);
    }

    @Test
    public void getMarket_Valid() throws Exception {
        api.getMarket("something", null);
        api.getMarket("something", 24);
    }

    @Test(expected = NullPointerException.class)
    public void getMarket_ThrowsNullpointer1() throws Exception {
        api.getMarket(null, null);
    }

    @Test(expected = NullPointerException.class)
    public void getMarket_ThrowsNullpointer2() throws Exception {
        api.getMarket(null, 24);
    }

    @Test
    public void getMarketHistory_ValidWithHours() throws Exception {
        api.getMarketHistory("something", 24);
    }

    @Test
    public void getMarketHistory_ValidNoHours() throws Exception {
        api.getMarketHistory("something", null);
    }

    @Test(expected = NullPointerException.class)
    public void getMarketHistory_ThrowsNullpointer1() throws Exception {
        api.getMarketHistory(null, null);
    }

    @Test(expected = NullPointerException.class)
    public void getMarketHistory_ThrowsNullpointer2() throws Exception {
        api.getMarketHistory(null, 24);
    }

    @Test
    public void getMarketOrders_ValidWithCount() throws Exception {
        api.getMarketOrders("something", 24);
    }

    @Test
    public void getMarketOrders_ValidNoCount() throws Exception {
        api.getMarketOrders("something", null);
    }

    @Test(expected = NullPointerException.class)
    public void getMarketOrders_ThrowsNullpointer1() throws Exception {
        api.getMarketOrders(null, null);
    }

    @Test(expected = NullPointerException.class)
    public void getMarketOrders_ThrowsNullpointer2() throws Exception {
        api.getMarketOrders(null, 24);
    }

    @Test
    public void getMarketOrderGroups_ValidWithCount() throws Exception {
        api.getMarketOrderGroups(new String[]{"something"}, 24);
    }

    @Test
    public void getMarketOrderGroups_ValidNoCount() throws Exception {
        api.getMarketOrderGroups(new String[]{"something"}, null);
    }

    @Test(expected = NullPointerException.class)
    public void getMarketOrderGroups_ThrowsNullpointer1() throws Exception {
        api.getMarketOrderGroups(null, null);
    }

    @Test(expected = NullPointerException.class)
    public void getMarketOrderGroups_ThrowsNullpointer2() throws Exception {
        api.getMarketOrderGroups(new String[0], 24);
    }

    @Test(expected = NullPointerException.class)
    public void getMarketOrderGroups_ThrowsNullpointer3() throws Exception {
        api.getMarketOrderGroups(null, 24);
    }
}