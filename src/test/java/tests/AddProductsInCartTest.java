package tests;

import components.CartComponents;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;

import java.util.List;

public class AddProductsInCartTest extends AbstractBaseTest{

//    @Test
//    public void testAddOneItemToCart(){
//
//        HomePage homePage =new HomePage(driver);
//
//        ProductDetailsPage productDetailsPage = homePage
//               .getheader()
//               .clickOnHamburgerMenu()
//               .hoverOnShopMenuItem()
//               .clickOnProductType("Christmas")
//               .getProducts().get(0)
//               .clickOnProduct();
//
//        String description = productDetailsPage.getProductTitle();
//
//        Double price = productDetailsPage.getPrice();
//
//        List<CartComponents> cartItems = productDetailsPage
//                   .clickOnAddToCard()
//                   .clickOnWievCart()
//                   .getCartItems();
//
//        Assert.assertEquals(1, cartItems.size());
//        Assert.assertEquals(description, cartItems.get(0).getDescription());
//        Assert.assertEquals(price, cartItems.get(0).getPrice());
//
//    }
//
//    @Test
//    public void testSoldOutItemCantBeAddedToCart(){
//
//        HomePage homePage = new HomePage(driver);
//
//        ProductDetailsPage productDetailsPage = homePage
//                .getheader()
//                .clickOnHamburgerMenu()
//                .hoverOnShopMenuItem()
//                .clickOnProductType("Christmas")
//                .getProducts()
//                .get(0)
//                .clickOnProduct();
//
//        Assert.assertTrue(productDetailsPage.cartButtonDoesNotExist());
//    }
}
