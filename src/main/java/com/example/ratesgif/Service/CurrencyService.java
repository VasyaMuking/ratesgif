package com.example.ratesgif.Service;

import com.example.ratesgif.DTO.Rates;

public interface CurrencyService {
    Rates getRatesByDate(String date);
    String getRichStatus();
}
