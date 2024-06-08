package ru.dasha.CurrencyCbrService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.dasha.CurrencyCbrService.model.CurrencyRate;
import ru.dasha.CurrencyCbrService.service.RateService;

@RestController
@RequestMapping(path = "${app.rest.api.prefix}")
public class RateController {
	private final RateService rateService;
	
	RateController(RateService rateService){
		this.rateService = rateService;
	}
	
	@GetMapping("/{charCode}")
	public CurrencyRate getRateByCharCode(@PathVariable String charCode) {
		return rateService.getRateByCharCode(charCode);
	}

}
