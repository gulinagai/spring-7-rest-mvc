package guli.springframework.spring7restmvc.controller;

import guli.springframework.spring7restmvc.model.Beer;
import guli.springframework.spring7restmvc.service.BeerService;
import guli.springframework.spring7restmvc.service.BeerServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;


import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


//@SpringBootTest
@WebMvcTest(BeerController.class)
class BeerControllerTest {

    //@Autowired
    //BeerController beerController;

    @Autowired
    MockMvc mockmvc;

    @MockitoBean    // essa anotação basicamente diz ao Mockito para fornecer uma simulação disso no contexto Spring.
    BeerService beerService;

    BeerServiceImpl beerServiceImpl = new BeerServiceImpl();

    @Test
    void getBeerById() throws Exception {

        Beer testBeer = beerServiceImpl.listBeers().get(0);

        given(beerService.getBeerById(any(UUID.class))).willReturn(testBeer);

        mockmvc.perform(get("/api/v1/beer/" + UUID.randomUUID()).
                        accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.beerName").value(testBeer.getBeerName()))
                .andDo(print());

        // System.out.println(beerController.getBeerById(UUID.randomUUID()));
    }
}

// Como funciona o jsonPath
//
//Ele navega no JSON:
//
//{
//  "beerName": "Heineken"
//}
//
// Você acessa com:
//
//jsonPath("$.beerName")
