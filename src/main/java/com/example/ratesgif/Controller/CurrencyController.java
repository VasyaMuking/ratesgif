package com.example.ratesgif.Controller;

import com.example.ratesgif.DTO.Rates;
import com.example.ratesgif.Service.CurrencyService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(path = "/currency")
public class CurrencyController extends HttpServlet {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }


    @GetMapping(path = "/richStatus")
    public void getRichStatus(HttpServletResponse response) throws IOException {

        String imageUrl = currencyService.getRichStatus();
        response.sendRedirect(imageUrl);
    }


    @GetMapping(path = "/get")
    public Rates getRatesByDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") String date) {
        return currencyService.getRatesByDate(date);
    }

}
