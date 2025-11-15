package lab.adapter;

import java.util.Map;

public class PaymentAdapter implements PaymentGateway {

    private final LegacyPaymentService legacy;

    // Static currency → USD rates
    private final Map<String, Double> rates = Map.of(
            "USD", 1.0,
            "EUR", 1.10,   // 1 EUR = 1.10 USD
            "PKR", 0.0036  // 1 PKR = 0.0036 USD (static example)
    );

    public PaymentAdapter(LegacyPaymentService legacy) {
        this.legacy = legacy;
    }

    @Override
    public void pay(double dollars) {
        int cents = (int) Math.round(dollars * 100);
        System.out.println("[PaymentAdapter] Converting $" + dollars + " -> " + cents + " cents");
        legacy.makePayment(cents);
    }

    // NEW multi-currency pay
    public void pay(double amount, String currency) {
        double rate = rates.getOrDefault(currency.toUpperCase(), 1.0);

        double usdAmount = amount * rate;

        System.out.println("[PaymentAdapter] "
                + amount + " " + currency.toUpperCase()
                + " → " + usdAmount + " USD (rate=" + rate + ")");

        pay(usdAmount); // call original pay()
    }

    @Override
    public void refund(double dollars) {
        int cents = (int) Math.round(dollars * 100);
        System.out.println("[PaymentAdapter] Converting refund $" + dollars + " -> " + cents + " cents");
        legacy.refundPayment(cents);
    }
}
