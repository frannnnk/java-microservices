package com.eazybytes.accounts.service.client;

import com.eazybytes.accounts.model.Cards;
import com.eazybytes.accounts.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("cards")
public interface CardsFeignClient {
    @PostMapping(value = "myCards", consumes = "application/json")
    List<Cards> getCardsDetails(@RequestBody Customer customer);
}
