package lab.adapter;

/**
 * Legacy library class that we cannot change.
 * It expects integer cents (e.g., 1999 for $19.99).
 */
public class LegacyPaymentService {
    private final String merchantId;

    public LegacyPaymentService(String merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * Simulates making a payment in integer cents.
     */
    public void makePayment(int cents) {
        // Simulate some legacy behavior and print to stdout
        System.out.println("[LegacyPaymentService] Merchant: " + merchantId
            + " | Payment received: " + cents + " cents");
        // Pretend some internal checks happen here...
        System.out.println("[LegacyPaymentService] Status: PAYMENT_OK");
    }
}
