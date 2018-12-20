package dev.gabrieljbo.poc.camelpoc.services;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.gabrieljbo.poc.camelpoc.domain.Payment;

@Component
public class PaymentRouterImpl implements PaymentRouter {

    @Autowired
    ProducerTemplate producerTemplate;

    @Override
    public void routePayment(Payment payment) {
	producerTemplate.sendBody("direct:paymentRoute", payment);
    }

}
