package com.work1.JavaBoot_WorkI.Controller;

import com.work1.JavaBoot_WorkI.entity.Product;
import com.work1.JavaBoot_WorkI.entity.User;
import com.work1.JavaBoot_WorkI.repository.ProductRepository;
import com.work1.JavaBoot_WorkI.repository.UserRepository;
import com.work1.JavaBoot_WorkI.response.ErrorMessageResponse;
import com.work1.JavaBoot_WorkI.response.ProductResponse;
import com.work1.JavaBoot_WorkI.response.ProductResponseList;
import com.work1.JavaBoot_WorkI.response.UserResposnse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SearchProductControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    //Mock Repository
    @MockBean
    private ProductRepository productRepository;

    @Test
    @DisplayName("SuccessCase findByproductName, productName = ยาหม่อง, Result = result.getProductName() == ยาหม่อง")
    void successProductByName() {
        //จำลอง Arrange
        Product product = new Product();
        product.setId(1);
        product.setProductName("ยาหม่อง");
        product.setProductId(12223);
        when(productRepository.findByproductName("ยาหม่อง")).thenReturn(Optional.of(product));
        //Act
        ProductResponse result = testRestTemplate.getForObject("/productbyname/ยาหม่อง", ProductResponse.class);
        //Verify
        assertEquals("ยาหม่อง", result.getProductName());
    }
    @Test
    @DisplayName("FailedCase findByproductName,Send UserName = ยาแก้ปวด, Result = ไม่พบสินค้า ยาแก้ปวด")
    void failedProductByName() {
        ErrorMessageResponse result = testRestTemplate.getForObject("/productbyname/ยาแก้ปวด", ErrorMessageResponse.class);
        assertEquals("ไม่พบสินค้า ยาแก้ปวด", result.getErrorMessage());
    }

    @Test
    @DisplayName("SuccessCase findByProductLikeName,productName = ยาหม่อง, Result = result.getProductName() == ยาหม่อง")
    void successProductLikeName() {
        //จำลอง Arrange
        Product product = new Product();
        product.setId(1);
        product.setProductName("ยาหม่อง");
        product.setProductId(12223);
        List<Product> productList = new ArrayList<Product>();
        productList.add(product);
        when(productRepository.findByproductNameContains("ยาหม่อง")).thenReturn(Optional.of(productList));
        //Act
        ProductResponseList result = testRestTemplate.getForObject("/productlikename/ยาหม่อง", ProductResponseList.class);
        //Verify
        assertEquals("ยาหม่อง", result.getProductResponseList().get(0).getProductName());
    }

    @Test
    @DisplayName("FailedCase findByProductLikeName,Send UserName = มะม่วง, Result = ไม่พบสินค้า มะม่วง")
    void failedProductLikeName() {
        ErrorMessageResponse result = testRestTemplate.getForObject("/productlikename/มะม่วง", ErrorMessageResponse.class);
        assertEquals("ไม่พบสินค้า มะม่วง", result.getErrorMessage());
    }
}