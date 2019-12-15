package zalandoTests;

import ZalandoPages.CartZalandoPage;
import ZalandoPages.HomeZalandoPage;
import ZalandoPages.ProductZalandoDetailPage;
import ZalandoPages.ProductsZalandoPage;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import zalandooComponents.CartZalandoZalandoComponent;
import zalandooComponents.ProductZalandoZalandoComponent;

import java.util.List;

@Epic("shop")
@Feature("Button price")
@Story("Create price range for product")

public class InitialTests extends AbstractsTest {

    private HomeZalandoPage homeZalandoPage;

    @BeforeTest
    public void beforeTest(){
        homeZalandoPage = new HomeZalandoPage(driver);
    }

    @Test
    @Description("Testing only products with discounts")
    public void testOnlyProductsWithDiscounts(){

        ProductsZalandoPage productsZalandoPage = homeZalandoPage
                .getheader()
                .clickOnWomanMenuItem()
                .clickOnShoesSubMenuItem()
                .clickOnItem();
         productsZalandoPage.getProductsHeader().clickOnPrice().selectOnlySpecialOffers();

        Assert.assertEquals(84,productsZalandoPage.getProductsWithDiscount().size() );
    }

    @Test
    @Description("Testin only products with price range")
    public void testProductsWithPriceRange(){

        ProductsZalandoPage productsZalandoPage = homeZalandoPage
                .getheader()
                .clickOnWomanMenuItem()
                .clickOnShoesSubMenuItem()
                .clickOnItem();
        productsZalandoPage.getProductsHeader().clickOnPrice().setPriceRange("20", "30");

        List<ProductZalandoZalandoComponent> products = productsZalandoPage.getProducts();

        products
                .stream()
                .filter(p -> p.isProduct())
                .forEach(p -> Assert.assertTrue(p.getPrice() >= 20 && p.getPrice() <= 30));


    }

    @Test
    @Description("Testing only one item")
    public void testOneItemInBag(){

        ProductsZalandoPage productsZalandoPage = homeZalandoPage
                .getheader()
                .clickOnWomanMenuItem()
                .clickOnShoesSubMenuItem()
                .clickOnItem();

        List<ProductZalandoZalandoComponent> products = productsZalandoPage.getProducts();

        ProductZalandoDetailPage productZalandoDetailPage = products.get(0).clickOnProduct();

        String color = productZalandoDetailPage.getColorTitle();
        Double price = productZalandoDetailPage.getPrice();

        productZalandoDetailPage.clickOnSize().chooseSizeShoes("38");
        CartZalandoPage cartZalandoPage = productZalandoDetailPage.clickOnAddToBag().clickOnAddToBagDialog();

        List<CartZalandoZalandoComponent> cartItems = cartZalandoPage.getCartItems();

        Assert.assertEquals(1, cartItems.size());
        Assert.assertTrue(cartItems.get(0).getColor().contains(color));
        Assert.assertEquals(price, cartItems.get(0).getPrice());
    }
}
