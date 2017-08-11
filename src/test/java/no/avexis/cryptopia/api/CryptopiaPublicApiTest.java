package no.avexis.cryptopia.api;


import no.avexis.cryptopia.exceptions.MissingParameterException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        api.getCurrencies();
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
    void getMarket_ThrowsNullpointer1() throws Exception {
        Throwable exception = assertThrows(MissingParameterException.class, () -> {
            api.getMarket(null, null);
        });
    }

    @Test
    void getMarket_ThrowsNullpointer2() throws Exception {
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
    void getMarketHistory_ThrowsNullpointer1() throws Exception {
        Throwable exception = assertThrows(MissingParameterException.class, () -> {
            api.getMarketHistory(null, null);
        });
        assertEquals(NAME_OR_IS_REQ, exception.getMessage());
    }

    @Test
    void getMarketHistory_ThrowsNullpointer2() throws Exception {
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
    void getMarketOrders_ThrowsNullpointer1() throws Exception {
        Throwable exception = assertThrows(MissingParameterException.class, () -> {
            api.getMarketOrders(null, null);
        });
        assertEquals(NAME_OR_IS_REQ, exception.getMessage());
    }

    @Test
    void getMarketOrders_ThrowsNullpointer2() throws Exception {
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
    void getMarketOrderGroups_ThrowsNullpointer1() throws Exception {
        Throwable exception = assertThrows(MissingParameterException.class, () -> {
            api.getMarketOrderGroups(null, null);
        });
        assertEquals(MARKETS_REQ, exception.getMessage());
    }

    @Test
    void getMarketOrderGroups_ThrowsNullpointer2() throws Exception {
        Throwable exception = assertThrows(MissingParameterException.class, () -> {
            api.getMarketOrderGroups(new String[0], 24);
        });
        assertEquals(MARKETS_REQ, exception.getMessage());
    }

    @Test
    void getMarketOrderGroups_ThrowsNullpointer3() throws Exception {
        Throwable exception = assertThrows(MissingParameterException.class, () -> {
            api.getMarketOrderGroups(null, 24);
        });
        assertEquals(MARKETS_REQ, exception.getMessage());
    }
}