package ru.dasha.CurrencyCbrService.exeption;

public class CurrencyRateParsingException extends RuntimeException {
    public CurrencyRateParsingException(Exception ex) {
        super(ex);
    }
}