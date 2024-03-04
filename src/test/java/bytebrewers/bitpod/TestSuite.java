package bytebrewers.bitpod;
import bytebrewers.bitpod.controller.*;
import bytebrewers.bitpod.service.BankServiceTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        AuthControllerTest.class,
        BankControllerTest.class,
        PortfolioControllerTest.class,
        TransactionControllerTest.class,
        StockControllerTest.class,
        BankServiceTest.class
})
public class TestSuite {

}
