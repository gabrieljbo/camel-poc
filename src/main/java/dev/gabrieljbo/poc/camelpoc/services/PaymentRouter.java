package dev.gabrieljbo.poc.camelpoc.services;

import dev.gabrieljbo.poc.camelpoc.domain.Payment;

public interface PaymentRouter {
    public void routePayment(Payment payment);
}
