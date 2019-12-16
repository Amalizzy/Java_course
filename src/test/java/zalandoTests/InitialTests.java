package zalandoTests;

import ZalandoPages.CartPage;
import ZalandoPages.HomePage;
import ZalandoPages.ProductDetailPage;
import ZalandoPages.ProductsPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import zalandooComponents.CartComponent;
import zalandooComponents.ProductComponent;

import java.util.List;

@Epic("shop")
@Feature("Button price")
@Story("Create price range for product")

public class InitialTests extends AbstractsTest {

    private HomePage homePage;

    @BeforeTest
    public void beforeTest(){
        homePage = new HomePage(driver);
    }

    @Test
    @Description("Testing only products with discounts")
    public void testOnlyProductsWithDiscounts(){

        ProductsPage productsZalandoPage = homePage
                .getheader()
                .clickOnWomanMenuItem()
                .clickOnShoesSubMenuItem()
                .clickOnItem("Boots");
         productsZalandoPage.getProductsHeader().clickOnPrice().selectOnlySpecialOffers();

        Assert.assertEquals(84,productsZalandoPage.getProductsWithDiscount().size() );
    }

    @Test
    @Description("Testin only products with price range")
    public void testOnlyProductsWithPriceRange(){

        ProductsPage productsPage = homePage
                .getheader()
                .clickOnWomanMenuItem()
                .clickOnShoesSubMenuItem()
                .clickOnItem("Boots");
        productsPage.getProductsHeader().clickOnPrice().setPriceRange("20", "30");

        List<ProductComponent> products = productsPage.getProducts();

        products
                .stream()
                .filter(p -> p.isProduct())
                .forEach(p -> Assert.assertTrue(p.getPrice() >= 20 && p.getPrice() <= 30));
    }

    @Test
    @Description("Testing only one item")
    public void testProductOneItemInBag(){

        ProductsPage productsPage = homePage
                .getheader()
                .clickOnWomanMenuItem()
                .clickOnShoesSubMenuItem()
                .clickOnItem("Boots");

        List<ProductComponent> products = productsPage.getProducts();

        ProductDetailPage productDetailPage = products.get(0).clickOnProduct();

        String color = productDetailPage.getColorTitle();
        Double price = productDetailPage.getPrice();

        productDetailPage.clickOnSize().chooseSizeShoes("7");
        CartPage cartPage = productDetailPage.clickOnAddToBag().clickOnAddToBagDialog();

        List<CartComponent> cartItems = cartPage.getCartItems();

        Assert.assertEquals(1, cartItems.size());
        Assert.assertTrue(cartItems.get(0).getColor().contains(color), "Expected product color " + color + " is not same as cart color: black");
        Assert.assertEquals(price, cartItems.get(0).getPrice());
    }
}
