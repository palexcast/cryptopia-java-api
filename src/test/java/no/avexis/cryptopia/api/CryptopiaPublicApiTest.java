package no.avexis.cryptopia.api;


import no.avexis.cryptopia.exceptions.MissingParameterException;
import no.avexis.cryptopia.models.pub.Currency;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
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
    void Valid_GetCurrencies() throws Exception {
        List<Currency> currencyList = api.getCurrencies();
        Currency cur = currencyList.get(0);
        assertFalse(cur.getName().isEmpty());
    }

    @Test
    void Valid_GetTradePairs() throws Exception {
        api.getTradePairs();
    }

    @Nested
    @DisplayName("Get Markets")
    class getMarkets {
        @Test
        void Valid_NoNullValues() throws Exception {
            api.getMarkets("baseMarket", 24);
        }

        @Test
        void Valid_BothNull() throws Exception {
            api.getMarkets(null, null);
        }

        @Test
        void Valid_BaseMarketIsNull() throws Exception {
            api.getMarkets(null, 24);
        }

        @Test
        void Valid_HoursIsNull() throws Exception {
            api.getMarkets("baseMarket", null);
        }
    }

    @Nested
    @DisplayName("Get Market")
    class getMarket {
        @Test
        void Valid() throws Exception {
            api.getMarket("nameOrId", null);
            api.getMarket("nameOrId", 24);
        }

        @Test
        void MissingParameterException_BothAreNull() throws Exception {
            Throwable exception = assertThrows(MissingParameterException.class,
                    () -> api.getMarket(null, null));
        }

        @Test
        void MissingParameterException_NameOrIdIsNull() throws Exception {
            Throwable exception = assertThrows(MissingParameterException.class,
                    () -> api.getMarket(null, 24));
        }
    }


    @Nested
    @DisplayName("Get Market History")
    class getMarketHistory {
        @Test
        void Valid_NoNullValues() throws Exception {
            api.getMarketHistory("nameOrId", 24);
        }

        @Test
        void Valid_HoursIsNull() throws Exception {
            api.getMarketHistory("nameOrId", null);
        }

        @Test
        void MissingParameterException_BothAreNull() throws Exception {
            Throwable exception = assertThrows(MissingParameterException.class,
                    () -> api.getMarketHistory(null, null));
            assertEquals(NAME_OR_IS_REQ, exception.getMessage());
        }

        @Test
        void MissingParameterException_NameOrIdIsNull() throws Exception {
            Throwable exception = assertThrows(MissingParameterException.class,
                    () -> api.getMarketHistory(null, 24));
            assertEquals(NAME_OR_IS_REQ, exception.getMessage());
        }
    }


    @Nested
    @DisplayName("Get Market Orders")
    class getMarketOrders {

        @Test
        void Valid_NoNullValues() throws Exception {
            api.getMarketOrders("nameOrId", 24);
        }

        @Test
        void Valid_CountIsNull() throws Exception {
            api.getMarketOrders("nameOrId", null);
        }

        @Test
        void MissingParameterException_BothAreNull() throws Exception {
            Throwable exception = assertThrows(MissingParameterException.class,
                    () -> api.getMarketOrders(null, null));
            assertEquals(NAME_OR_IS_REQ, exception.getMessage());
        }

        @Test
        void MissingParameterException_NameOrIdIsNull() throws Exception {
            Throwable exception = assertThrows(MissingParameterException.class,
                    () -> api.getMarketOrders(null, 24));
            assertEquals(NAME_OR_IS_REQ, exception.getMessage());
        }
    }

    @Nested
    @DisplayName("Get Market Groups")
    class getMarketOrderGroups {

        @Test
        void Valid_NoNullValues() throws Exception {
            api.getMarketOrderGroups(new String[]{"Markets"}, 24);
        }

        @Test
        void Valid_CountIsNull() throws Exception {
            api.getMarketOrderGroups(new String[]{"Markets"}, null);
        }

        @Test
        void MissingParameterException_BothValuesAreNull() throws Exception {
            Throwable exception = assertThrows(MissingParameterException.class,
                    () -> api.getMarketOrderGroups(null, null));
            assertEquals(MARKETS_REQ, exception.getMessage());
        }

        @Test
        void MissingParameterException_MarketsEmptyArray() throws Exception {
            Throwable exception = assertThrows(MissingParameterException.class,
                    () -> api.getMarketOrderGroups(new String[0], 24));
            assertEquals(MARKETS_REQ, exception.getMessage());
        }

        @Test
        void MissingParameterException_MarketsIsNull() throws Exception {
            Throwable exception = assertThrows(MissingParameterException.class,
                    () -> api.getMarketOrderGroups(null, 24));
            assertEquals(MARKETS_REQ, exception.getMessage());
        }
    }
}