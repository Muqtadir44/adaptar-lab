package lab.adapter;

/**
 * New interface expected by the application (dollars).
 */
public interface PaymentGateway {
    /**
     * Pay the given amount in dollars (e.g., 19.99).
     * @param dollars amount in dollars
     */
    void pay(double dollars);
}
