package ee.bootcamp.dd;

import java.util.HashMap;
import java.util.Map;

public class Money {

    private String currency;
    private int value;
    private static Map<String, Money> allCurrencies = new HashMap<>();

    private Money(String currency, int value) {
        this.currency = currency;
        this.value = value;
    }

    public static Money valueOf(String currencyName, int currencyDenomination) {
        Money money = allCurrencies.get(currencyName);

        if(money==null || !money.equals(new Money(currencyName, currencyDenomination))) {
            money = new Money(currencyName, currencyDenomination);
            allCurrencies.put(currencyName, money);
        }

        return allCurrencies.get(currencyName);
    }

    public Money add(Money another) throws DifferentCurrenciesException {
        if(currency.equals(another.currency)) {
            return new Money(currency, this.value + another.value);
        }
        throw new DifferentCurrenciesException();
    }

    public String getCurrency() {
        return currency;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        Money that = (Money) other;

        if (value != that.value) return false;
        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = currency != null ? currency.hashCode() : 0;
        result = 31 * result + value;
        return result;
    }

    private class DifferentCurrenciesException extends Throwable {
    }
}
