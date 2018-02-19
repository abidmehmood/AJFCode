//Convertible.java
package obssao.currencyconversion;

public interface Convertible {

}

    aspect ConvertibleAspect {
        // declaration of fields and methods into interface
        //instance of Currency class to be declared as result of association
        Currency Convertible.converter=null;

public long Convertible.convert(Currency source,Currency target){
        System.out.println("Convertible.convert() called");

        return state.convert();

        }

static class ConvertibleClass {
    public static ConvertibleClass getInstance() {
        return new ConvertibleClass();
    }
}

// aspect-specific interface implementations to provide access to intances
// of classes that correspond to interfaces
static class ConvertibleStateClass {
    static ConvertibleStateClass getInstance() {
        return new ConvertibleStateClass();
    }
}

static class ConversionRequiredClass {
    ConversionRequiredClass(Convertible c) {
        convertible = (ConvertibleClass) c;
    }

    static ConversionRequiredClass getInstance(Convertible c) {

        return new ConversionRequiredClass(c);
    }
}

static class ConvertedClass {
    ConvertedClass(Convertible c) {
        convertible = (ConvertibleClass) c;
    }

    static ConvertedClass getInstance(Convertible c) {
        return new ConvertedClass(c);
    }
}

    // declare associations of classes to interfaces and other classes
    declare parents:ConvertibleClass implements Convertible;
        declare parents:ConvertibleStateClass implements ConvertibleState;
        declare parents:ConversionRequiredClass implements ConversionRequired;
        declare parents:ConvertedClass implements Converted;
        declare parents:ConversionRequiredClass extends ConvertibleStateClass;
        declare parents:ConvertedClass extends ConvertibleStateClass;

public ConvertibleStateClass Convertible.state; // reference to class that
// handles states

public ConversionRequiredClass Convertible.conversionRequiredState;
// references to classes each representing a state
public ConvertedClass Convertible.convertedState;

// initialize the Persistable

public void Convertible.initialize(){
        System.out.println("Convertible.initialize()...");
        state=ConvertibleStateClass.getInstance();
        conversionRequiredState=ConversionRequiredClass.getInstance(this);
        convertedState=ConvertedClass.getInstance(this);

        state.entry();
        }

public void Convertible.setState(ConvertibleState st){
        System.out
        .println("Convertible.setState(): going to change the state to "
        +st.toString());
        state=(ConvertibleStateClass)st;
        System.out.println("Convertible.setState(): stated changed to"+state);
        state.entry();
        }

        }