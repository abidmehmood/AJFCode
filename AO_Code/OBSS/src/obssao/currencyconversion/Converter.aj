//Converter.aj

package obssao.currencyconversion;

public aspect Converter {

    // here we write a pointcut which will pick any call to our aspect that has been mapped..

    pointcut conversionRequiredUsed(ConversionRequired ur): execution (* *(..)) && target (ur);

    pointcut excludeInternalCalls(): !within (ConvertibleAspect) || !within (ConvertibleStateAspect) ||
            !within (ConversionRequiredAspect);
    pointcut toUse(ConversionRequired ur): conversionRequiredUsed(ur) && excludeInternalCalls();

    before (ConversionRequired ur): toUse(ur) {

        System.out.println("Converter.JoinPoint detected: Going to execute advice");

        ConvertibleAspect.ConvertibleClass p = ConvertibleAspect.ConvertibleClass.getInstance();
        ur.convertible = p;
        ur.convertible.state = ConvertibleAspect.ConvertibleStateClass.getInstance();
        ur.convertible.conversionRequiredState = ConvertibleAspect.ConversionRequiredClass.getInstance(p);
        ur.convertible.convertedState = ConvertibleAspect.ConvertedClass.getInstance(p);

        System.out.println("Converter.Finished executing advice");
    }

}
