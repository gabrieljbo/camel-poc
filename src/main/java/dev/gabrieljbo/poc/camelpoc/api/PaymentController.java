package dev.gabrieljbo.poc.camelpoc.api;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.gabrieljbo.poc.camelpoc.domain.Payment;
import dev.gabrieljbo.poc.camelpoc.domain.PaymentType;
import dev.gabrieljbo.poc.camelpoc.services.PaymentRouter;

@RestController
public class PaymentController {

    @Autowired
    PaymentRouter paymentRouter;

    @RequestMapping(value = "/payment")
    public void startCamel() {
	Payment payment = new Payment(PaymentType.CASH, 1, "Mi primer pago", LocalDate.now(), 500.66);
	paymentRouter.routePayment(payment);
    }
}
