package dev.gabrieljbo.poc.camelpoc;

import org.apache.camel.CamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CamelPocApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    CamelContext camelContext;

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
	try {


	} catch (Exception e) {
	    e.printStackTrace();
	}

	return;
    }
}
