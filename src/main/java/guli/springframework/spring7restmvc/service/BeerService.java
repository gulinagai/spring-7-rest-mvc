package guli.springframework.spring7restmvc.service;

import guli.springframework.spring7restmvc.model.Beer;

import java.util.UUID;

public interface BeerService {

    Beer getBeerById(UUID id);
}
