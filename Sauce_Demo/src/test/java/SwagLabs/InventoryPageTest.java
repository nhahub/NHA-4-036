package SwagLabs;
import SwagLabs.base.BaseTest;
import SwagLabs.pages.InventoryPage;
import org.testng.annotations.BeforeMethod;

public class InventoryPageTest extends BaseTest {
    public InventoryPage inventoryPage;

    //Tests



    @BeforeMethod
    @Override
    public void SetUp() {
        super.SetUp();
        inventoryPage = new InventoryPage(driver);
    }



}
