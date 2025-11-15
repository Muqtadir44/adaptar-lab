package lab.adapter;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Adapter + Decorator + Multi-Currency Demo ===");

        LegacyPaymentService legacy = new LegacyPaymentService("MERCHANT-123");

        PaymentAdapter adapter = new PaymentAdapter(legacy);

        // Decorator wraps adapter
        PaymentGateway gateway = new LoggingPaymentGateway(adapter);

        // Normal payments
        gateway.pay(19.99);
        gateway.pay(5.00);
        gateway.pay(0.555); // rounding test

        // Refund test
        gateway.refund(9.50);

        // Multi-currency tests
        adapter.pay(10, "EUR");
        adapter.pay(100, "PKR");
    }
}
