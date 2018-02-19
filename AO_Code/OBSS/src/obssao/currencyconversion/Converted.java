//Converted.java
package obssao.currencyconversion;

public interface Converted extends ConvertibleState {

}

    aspect ConvertedAspect {
public void Converted.entry(){
        System.out.println("Converted.entry()");
        }

public void Converted.exit(){
        System.out.println("Converted.exit()");
        }

        }
