//ConvertibleState.java

package obssao.currencyconversion;

public interface ConvertibleState {

}

    aspect ConvertibleStateAspect {
// constructor for this class
public ConvertibleAspect.ConvertibleClass ConvertibleState.convertible;

// abstract methods of this class
public void ConvertibleState.entry(){
        }

public void ConvertibleState.exit(){
        }

public long ConvertibleState.convert(){
        //we overload this method in ConversionRequired
        return 0;
        }

        }