package ru.dasha.CurrencyCbrService.parser;

import java.util.List;

import ru.dasha.CurrencyCbrService.model.CurrencyNominalRate;

public interface Parser {
	List<CurrencyNominalRate> parse(String ratesAsString);
}
