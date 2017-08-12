package no.avexis.cryptopia.api;


import no.avexis.cryptopia.exceptions.MissingParameterException;
import no.avexis.cryptopia.models.pub.Currency;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CryptopiaPublicApiTest {
    private static final String NAME_OR_IS_REQ = "Param \"Name or Id\" is required";
    private static final String MARKETS_REQ = "Param \"Markets\" is required";

    private static CryptopiaPublicApi api;

    @BeforeAll
    static void before() {
        api = new CryptopiaPublicApi();
    }

    @Test
    void getCurrencies() throws Exception {
        List<Currency> currencyList = api.getCurrencies();
        Currency cur = currencyList.get(0);
        assertFalse(cur.getName().isEmpty());
    }

    @Test
    void getTradePairs() throws Exception {
        api.getTradePairs();
    }

    @Test
    void getMarkets_ValidBothHaveValues() throws Exception {
        api.getMarkets("baseMarket", 24);
    }

    @Test
    void getMarkets_ValidBothNull() throws Exception {
        api.getMarkets(null, null);
    }

    @Test
    void getMarkets_ValidBaseMarketNull() throws Exception {
        api.getMarkets(null, 24);
    }

    @Test
    void getMarkets_ValidHoursNull() throws Exception {
        api.getMarkets("baseMarket", null);
    }

    @Test
    void getMarket_Valid() throws Exception {
        api.getMarket("nameOrId", null);
        api.getMarket("nameOrId", 24);
    }

    @Test
    void getMarket_MissingParameterExceptionBothNull() throws Exception {
        Throwable exception = assertThrows(MissingParameterException.class, () -> {
            api.getMarket(null, null);
        });
    }

    @Test
    void getMarket_MissingParameterExceptionNameOrIdNull() throws Exception {
        Throwable exception = assertThrows(MissingParameterException.class, () -> {
            api.getMarket(null, 24);
        });
    }

    @Test
    void getMarketHistory_ValidWithHours() throws Exception {
        api.getMarketHistory("nameOrId", 24);
    }

    @Test
    void getMarketHistory_ValidNoHours() throws Exception {
        api.getMarketHistory("nameOrId", null);
    }

    @Test
    void getMarketHistory_MissingParameterExceptionBothNull() throws Exception {
        Throwable exception = assertThrows(MissingParameterException.class, () -> {
            api.getMarketHistory(null, null);
        });
        assertEquals(NAME_OR_IS_REQ, exception.getMessage());
    }

    @Test
    void getMarketHistory_MissingParameterExceptionNameOrIdNull() throws Exception {
        Throwable exception = assertThrows(MissingParameterException.class, () -> {
            api.getMarketHistory(null, 24);
        });
        assertEquals(NAME_OR_IS_REQ, exception.getMessage());
    }

    @Test
    void getMarketOrders_ValidWithCount() throws Exception {
        api.getMarketOrders("nameOrId", 24);
    }

    @Test
    void getMarketOrders_ValidNoCount() throws Exception {
        api.getMarketOrders("nameOrId", null);
    }

    @Test
    void getMarketOrders_ThrowsMissingParameterExceptionBothNull() throws Exception {
        Throwable exception = assertThrows(MissingParameterException.class, () -> {
            api.getMarketOrders(null, null);
        });
        assertEquals(NAME_OR_IS_REQ, exception.getMessage());
    }

    @Test
    void getMarketOrders_MissingParameterExceptionNameOrIdNull() throws Exception {
        Throwable exception = assertThrows(MissingParameterException.class, () -> {
            api.getMarketOrders(null, 24);
        });
        assertEquals(NAME_OR_IS_REQ, exception.getMessage());
    }

    @Test
    void getMarketOrderGroups_ValidWithCount() throws Exception {
        api.getMarketOrderGroups(new String[]{"Markets"}, 24);
    }

    @Test
    void getMarketOrderGroups_ValidNoCount() throws Exception {
        api.getMarketOrderGroups(new String[]{"Markets"}, null);
    }

    @Test
    void getMarketOrderGroups_ThrowsMissingParameterExceptionBothValuesNull() throws Exception {
        Throwable exception = assertThrows(MissingParameterException.class, () -> {
            api.getMarketOrderGroups(null, null);
        });
        assertEquals(MARKETS_REQ, exception.getMessage());
    }

    @Test
    void getMarketOrderGroups_MissingParameterExceptionMarketsEmptyArray() throws Exception {
        Throwable exception = assertThrows(MissingParameterException.class, () -> {
            api.getMarketOrderGroups(new String[0], 24);
        });
        assertEquals(MARKETS_REQ, exception.getMessage());
    }

    @Test
    void getMarketOrderGroups_MissingParameterExceptionMarketsNull() throws Exception {
        Throwable exception = assertThrows(MissingParameterException.class, () -> {
            api.getMarketOrderGroups(null, 24);
        });
        assertEquals(MARKETS_REQ, exception.getMessage());
    }
}