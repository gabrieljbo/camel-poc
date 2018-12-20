package dev.gabrieljbo.poc.camelpoc.routing;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.mq.jms.MQQueueConnectionFactory;
import com.ibm.msg.client.wmq.WMQConstants;

@Component
public class PaymentRoute extends RouteBuilder {
    private String cashOutputQueueEndpoint = "wmq:queue:PAYMENT.CASH.QL.REQ";
    private String cardOutputQueueEndpoint = "wmq:queue:PAYMENT.CARD.QL.REQ";

    @Autowired
    CamelContext camelContext;

    @Override
    public void configure() throws Exception {
	// from("direct:paymentRoute").log("MESSAGE: ${body}");

	MQQueueConnectionFactory mqQueueConnectionFactory = new MQQueueConnectionFactory();
	mqQueueConnectionFactory.setHostName("192.168.33.10");
	mqQueueConnectionFactory.setChannel("DEV.SVRCONN");// communications link
	mqQueueConnectionFactory.setPort(1414);
	mqQueueConnectionFactory.setQueueManager("DEV");// service provider
	mqQueueConnectionFactory.setTransportType(WMQConstants.WMQ_CM_CLIENT);
	mqQueueConnectionFactory.setStringProperty(WMQConstants.USERID, "devusr");

	camelContext.addComponent("wmq", JmsComponent.jmsComponentAutoAcknowledge(mqQueueConnectionFactory));
	from("direct:paymentRoute")
	.choice()
	    .when()
		.simple("${body.getType} == ${type:dev.gabrieljbo.poc.camelpoc.domain.PaymentType.CASH}")
		.to(cashOutputQueueEndpoint)
	    .when()
		.simple("${body.getType} == ${type:dev.gabrieljbo.poc.camelpoc.domain.PaymentType.CARD}")
		.to(cardOutputQueueEndpoint)
	.endChoice();        
    }
}