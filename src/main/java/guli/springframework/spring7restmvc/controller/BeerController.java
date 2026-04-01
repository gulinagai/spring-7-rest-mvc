package guli.springframework.spring7restmvc.controller;

import guli.springframework.spring7restmvc.model.Beer;
import guli.springframework.spring7restmvc.service.BeerService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
    private final BeerService beerService;

    @PatchMapping("{beerId}")
    public ResponseEntity updatePatchById(@PathVariable("beerId") UUID beerId, @RequestBody Beer beer) {

        beerService.updatePatchById(beerId,  beer);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"{beerID}"})
    public ResponseEntity deleteById(@PathVariable("beerID") UUID beerID) {

        beerService.deleteById(beerID);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //@RequestMapping(method = RequestMethod.POST)

    @PutMapping("{beerId}")
    public ResponseEntity updateById(@PathVariable("beerId") UUID beerId, @RequestBody Beer beer) {
        log.info("beerId é {}", beerId);
        log.info("beer é {}", beer);

        beerService.updateBeerById(beerId, beer);



        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PostMapping
    public ResponseEntity handlePost(@RequestBody Beer beer) {

        Beer savedBeer = beerService.saveNewBeer(beer);

        HttpHeaders headers = new HttpHeaders();

        headers.add("Location", "/api/v1/beer/" +  savedBeer.getId().toString());

                                                        // o ResponseEntity, representa o response completo, com status, body e headers.
        return new ResponseEntity<>(headers, HttpStatus.CREATED);  // nessa linha, é como se estivesse retornando um response da requisicao com o statusCode 201, que é o HttpStratus.CREATED e um body vazio
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Beer> listBeers() {
        return beerService.listBeers();
    }

   @RequestMapping(value = "{beerId}", method = RequestMethod.GET)
    public Beer getBeerById(@PathVariable("beerId") UUID beerId) {

        log.info("getBeerById foi chamado - Controller");

        return beerService.getBeerById(beerId);
    }
}
