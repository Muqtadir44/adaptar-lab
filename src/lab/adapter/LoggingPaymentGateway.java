package lab.adapter;

import java.time.LocalDateTime;

public class LoggingPaymentGateway implements PaymentGateway {

    private final PaymentGateway wrapped;

    public LoggingPaymentGateway(PaymentGateway wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void pay(double dollars) {
        System.out.println("[LOG] " + LocalDateTime.now() + " | About to pay $" + dollars);
        wrapped.pay(dollars);
        System.out.println("[LOG] " + LocalDateTime.now() + " | Payment completed");
    }

    @Override
    public void refund(double dollars) {
        System.out.println("[LOG] " + LocalDateTime.now() + " | About to refund $" + dollars);
        wrapped.refund(dollars);
        System.out.println("[LOG] " + LocalDateTime.now() + " | Refund completed");
    }
}
