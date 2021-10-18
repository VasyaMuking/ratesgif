package com.example.ratesgif.Feign;

import com.example.ratesgif.DTO.GifResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "gif", url = "http://api.giphy.com/v1/gifs/")
public interface GifClient {

    @RequestMapping(method = RequestMethod.GET, value = "/random")
    GifResponse getRandomGifByTag(@RequestParam("api_key") String apiKey, @RequestParam String tag);
}
