package ru.dasha.CurrencyCbrService.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import ru.dasha.CurrencyCbrService.cbrclient.CbrClient;
import ru.dasha.CurrencyCbrService.model.CurrencyNominalRate;
import ru.dasha.CurrencyCbrService.model.CurrencyRate;
import ru.dasha.CurrencyCbrService.parser.Parser;

@Service
public class RatesGettingService {
	private final CbrClient cbrClient;
    private final Parser parser;
    private static Logger log = LoggerFactory.getLogger(RatesGettingService.class);
    
    RatesGettingService(CbrClient cbrClient, Parser parser){
    	this.cbrClient = cbrClient;
    	this.parser = parser;
    }

    @Cacheable("rates")
    public List<CurrencyRate> getCurrencyRates(String date) {
        log.info("Getting rates from CBR.");
        String xmlCbr = cbrClient.getRatesByCbr();
        List<CurrencyNominalRate> nominalRateList = parser.parse(xmlCbr);
        return nominalRateList.stream().map(n ->
                new CurrencyRate(
                        n.getCharCode(),
                        Double.parseDouble(n.getValue()) / Double.parseDouble(n.getNominal())))
                .collect(Collectors.toList());
    }

}
