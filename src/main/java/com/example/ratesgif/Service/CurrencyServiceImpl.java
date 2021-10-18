package com.example.ratesgif.Service;

import com.example.ratesgif.DTO.GifResponse;
import com.example.ratesgif.DTO.Rates;
import com.example.ratesgif.DTO.Tags;
import com.example.ratesgif.Feign.CurrencyClient;
import com.example.ratesgif.Feign.GifClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class CurrencyServiceImpl implements CurrencyService{

    private final CurrencyClient currencyClient;
    private final GifClient gifClient;
    private final String currencyAppId;
    private final String gifAppId;

    public CurrencyServiceImpl(CurrencyClient currencyClient, GifClient gifClient,
                               @Value("${currency.app_id}") String currencyAppId,
                               @Value("${giphy.app_id}") String gifAppId) {
        this.currencyClient = currencyClient;
        this.gifClient = gifClient;
        this.currencyAppId = currencyAppId;
        this.gifAppId = gifAppId;
    }

    @Override
    public Rates getRatesByDate(String date) {

        return currencyClient.getRatesByDate(currencyAppId, date);

    }


    @Override
    public String getRichStatus() {

        GifResponse randomGifByTag = null;
        Rates todayRates = getRatesByDate(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        Rates yesterdayRates = getRatesByDate(LocalDate.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        if((todayRates.getRates().get("RUB").compareTo(yesterdayRates.getRates().get("RUB")) >= 0)) {
            randomGifByTag = gifClient.getRandomGifByTag(gifAppId, Tags.RICH.name());
        } else {
            randomGifByTag = gifClient.getRandomGifByTag(gifAppId, Tags.BROKE.name());
        }

        return randomGifByTag.getData().getImageUrl();
    }
}
