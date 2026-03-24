package guli.springframework.spring7restmvc.controller;

import guli.springframework.spring7restmvc.model.Beer;
import guli.springframework.spring7restmvc.service.BeerService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RestController
public class BeerController {
    private final BeerService beerService;

    @RequestMapping("api/v1/beer")
    public List<Beer> listBeers() {
        return beerService.listBeers();
    }

//    @RequestMapping("api/v1/beer/{id}")
//    @PathParam('')
    public Beer getBeerById(UUID id) {

        log.info("getBeerById foi chamado - Controller");

        return beerService.getBeerById(id);
    }
}
