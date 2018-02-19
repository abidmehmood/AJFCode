//Currency.java

package obssao.currencyconversion;

public interface Currency {

}

    aspect CurrencyAspect {
        //fields
        String Currency.locale;
        String Currency.name;
        long Currency.exRate;
        long Currency.amount;

//constructor
static class CurrencyClass {
    public static CurrencyClass getInstance() {
        return new CurrencyClass();
    }
}
    //methods
    void Currency.readExRate(String locale){
        // stub only
        }

        long Currency.convert(Currency source,Currency target){
        return 0;
        }

        String Currency.getLocale(){
        return"";
        }
        }