package ru.dasha.CurrencyCbrService.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import ru.dasha.CurrencyCbrService.cbrclient.CbrClient;
import ru.dasha.CurrencyCbrService.exeption.CurrencyRateNotFoundException;
import ru.dasha.CurrencyCbrService.model.CurrencyNominalRate;
import ru.dasha.CurrencyCbrService.model.CurrencyRate;
import ru.dasha.CurrencyCbrService.parser.Parser;

@Service
public class RateService {	
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final RatesGettingService ratesGettingService;
    private static Logger log = LoggerFactory.getLogger(RateService.class);
    
    RateService(RatesGettingService ratesGettingService){
    	this.ratesGettingService = ratesGettingService;
    }

    public CurrencyRate getRateByCharCode(String charCode) {
        LocalDateTime time = LocalDateTime.now();
        String date = dtf.format(time);
        log.info("Getting rate for {}.", charCode);
        return ratesGettingService.getCurrencyRates(date).stream()
                .filter(rate -> rate.getCharCode().equals(charCode))
                .findFirst()
                .orElseThrow(() -> new CurrencyRateNotFoundException("Currency Rate not found. Currency:" + charCode + ", date:" + date));
    }

}
