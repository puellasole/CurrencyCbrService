package ru.dasha.CurrencyCbrService.model;

public class CurrencyRate {
	private String charCode;
	private Double value;
	
	public CurrencyRate(String charCode, Double value) {
		this.charCode = charCode;
		this.value = value;
	}
	
	public String getCharCode() {
		return charCode;
	}

	public void setCharCode(String charCode) {
		this.charCode = charCode;
	}
	
	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public static Builder builder() {
        return new Builder();
    }

	public static class Builder {
        private String charCode;
        private Double value;

        public Builder charCode(String charCode) {
            this.charCode = charCode;
            return this;
        }

        public Builder value(Double value) {
            this.value = value;
            return this;
        }

        public CurrencyRate build() {
            return new CurrencyRate(charCode, value);
        }
    }
}
