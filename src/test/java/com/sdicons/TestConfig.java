package com.sdicons;

import org.springframework.context.annotation.Configuration;

/**
 * We derive the test context from the main application context and change the addresses of our services.
 * This will start a local instance of the services that we can call from our unit tests.
 * The nice thing is that we basically use and test the main application configuration as well.
 */
@Configuration
public class TestConfig
extends AppConfig {

    @Override
    protected String restAddress() {
        return "http://localhost:9090/rest";
    }

    @Override
    protected String soapAddress() {
        return "http://localhost:9090/soap";
    }
}
