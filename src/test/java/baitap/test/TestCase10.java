package baitap.test;
import baitap.model.ExportOrders;
import driver.driverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
@Test
public class TestCase10 {
        public void TestExportOrders() {
            WebDriver driver = driverFactory.getChromeDriver();
            try {
                driver.get("http://live.techpanda.org/index.php/backendlogin");

                ExportOrders exportOrdersTest = new ExportOrders(driver);
                exportOrdersTest.loginBackend();

                exportOrdersTest.closeMessage();

                exportOrdersTest.clickSalesOrders();

                exportOrdersTest.clickExportCsv();

                Thread.sleep(3000);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                driver.quit();
            }
        }
    }
