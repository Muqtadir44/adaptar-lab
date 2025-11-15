package lab.adapter;

/**
 * Adapter that converts dollars to cents and calls the legacy service.
 */
public class PaymentAdapter implements PaymentGateway {

    private final LegacyPaymentService legacy;

    public PaymentAdapter(LegacyPaymentService legacy) {
        this.legacy = legacy;
    }

    @Override
    public void pay(double dollars) {
        // Convert dollars to cents safely: round to nearest cent
        int cents = (int) Math.round(dollars * 100);
        System.out.println("[PaymentAdapter] Converting $" + dollars + " -> " + cents + " cents");
        legacy.makePayment(cents);
    }
}
