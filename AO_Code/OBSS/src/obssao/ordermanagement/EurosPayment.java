// EurosPayment.java

package obssao.ordermanagement;

import obssao.currencyconversion.ConversionRequired;

public interface EurosPayment extends ProcessingState, ConversionRequired {
// by extending ConversionRequired we ensure that convert method will be called for conversion
}

    aspect EurosPaymentAspect {


        }