package com.product.controller;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.http.MediaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.entity.Product;
import com.product.entity.ProductResponce;
import com.product.service.ProdServiceImpl;
import org.assertj.core.api.Assertions;

@WebMvcTest(controllers = ProductController.class)
public class ProductControllerTest {
	
	@Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;
    
    
    @MockBean 	
    private ProdServiceImpl prodServiceImpl;
    
    private List<Product> products;
    
    private Product product;
    
    private ProductResponce productResponce;
    
    @BeforeEach
    void setUp(){
    	products = List.of(new Product(1, "Study table", "Furniture", (long) 33330, "Furniture"),
    			new Product(2, "TV", "Electronic", (long) 223673, "Furniture"),
    		   new Product(3, "Mobile", "Electronic", (long) 8888, "Electronic")
               );
    	product = new Product( 4, "Mobile", "Electronic", (long) 8888, "Electronic");
    
    	
    }
    
    
    
    @Test
    //@Disabled
    void getUsersTest() throws Exception {

        Mockito.when(prodServiceImpl.getProducts()).thenReturn(products);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/fetchAllProducts")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        Assertions.assertThat(result).isNotNull();
        String userJson = result.getResponse().getContentAsString();
        Assertions.assertThat(userJson).isEqualToIgnoringCase(mapper.writeValueAsString(products));
    }





@Test
//@Disabled
void createUserTest() throws Exception {

    Mockito.when(prodServiceImpl.save(Mockito.any(Product.class))).thenReturn(product);

    MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/addProduct")
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(product).getBytes(StandardCharsets.UTF_8))
            .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();

    Assertions.assertThat(result).isNotNull();
    String userJson = result.getResponse().getContentAsString();
    Assertions.assertThat(userJson).isNotEmpty();
    Assertions.assertThat(userJson).isEqualToIgnoringCase(mapper.writeValueAsString(product));
}
}