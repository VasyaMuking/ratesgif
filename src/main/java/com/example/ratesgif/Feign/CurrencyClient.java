package com.example.ratesgif.Feign;

import com.example.ratesgif.DTO.Rates;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "currency", url = "https://openexchangerates.org/api")
public interface CurrencyClient {

    @RequestMapping(method = RequestMethod.GET, value = "/historical/{date}.json")
    Rates getRatesByDate(@RequestParam String app_id, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") String date);
}
