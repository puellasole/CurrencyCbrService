package ru.dasha.CurrencyCbrService.exeption;

public class CurrencyRateNotFoundException extends RuntimeException {
    public CurrencyRateNotFoundException(String m) {
        super(m);
    }
}