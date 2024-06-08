package ru.dasha.CurrencyCbrService.model;

public class CurrencyNominalRate {
	private String numCode;
	private String charCode;
	private String nominal;
	private String name;
	private String value;
	
	CurrencyNominalRate(String numCode, String charCode, String nominal, String name, String value){
		this.numCode = numCode;
		this.charCode = charCode;
		this.nominal = nominal;
		this.name = name;
		this.value = value;
		this.charCode = charCode;
	}
	
	public String getCharCode() {
		return charCode;
	}
	
	public String getNominal() {
		return nominal;
	}
	
	public String getValue() {
		return value;
	}

	public static Builder builder() {
		return new Builder();
	}
	
	public static class Builder {
		private String numCode;
		private String charCode;
		private String nominal;
		private String name;
		private String value;

		public Builder numCode(String numCode) {
			this.numCode = numCode;
			return this;
		}

		public Builder charCode(String charCode) {
			this.charCode = charCode;
			return this;
		}
		
		public Builder nominal(String nominal) {
			this.nominal = nominal;
			return this;
		}
		
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public Builder value(String value) {
			this.value = value;
			return this;
		}
		
		public CurrencyNominalRate build() {
            return new CurrencyNominalRate(numCode, charCode, nominal, name, value);
        }
	}
}
