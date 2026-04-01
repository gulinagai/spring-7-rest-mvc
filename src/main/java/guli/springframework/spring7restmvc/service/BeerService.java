package guli.springframework.spring7restmvc.service;

import guli.springframework.spring7restmvc.model.Beer;

import java.util.List;
import java.util.UUID;

public interface BeerService {

    List<Beer> listBeers();

    Beer getBeerById(UUID id);

    Beer saveNewBeer(Beer beer);

    void updateBeerById(UUID beerId, Beer beer);

    void deleteById(UUID beerID);

    void updatePatchById(UUID beerId, Beer beer);
}
