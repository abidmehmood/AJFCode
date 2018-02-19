//ConversionRequired.java
package obssao.currencyconversion;
public interface ConversionRequired extends ConvertibleState {

}
aspect ConversionRequiredAspect {

    public void ConversionRequired.entry(){
            System.out.println("ConversionRequired.entry()");

            }
    public void ConversionRequired.exit(){
            System.out.println("ConversionRequired.exit()");
            }

    public long ConversionRequired.convert(){
            System.out.println("ConversionRequired.convert()");
            convertible.setState(convertible.convertedState);
            return 1910;
            }
}