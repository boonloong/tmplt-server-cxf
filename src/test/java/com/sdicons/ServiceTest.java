package com.sdicons;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestConfig.class})
public class ServiceTest {

    @Test
    public void invokeRestService()
    throws Exception {
        // Setup REST connection.
        URL url = new URL("http://localhost:9090/rest/hello?name=Heisenberg");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "application/json");
        // Get Response.
        InputStream is = conn.getInputStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        final String line = rd.readLine();
        // Verify the response.
        Assert.assertEquals("Exepcted another REST answer ...", "{\"message\":{\"contents\":\"REST Service - Hello Heisenberg!\"}}", line);
    }

    @Test
    public void invokeSoapService()
            throws Exception {
        // Setup REST connection.
        URL url = new URL("http://localhost:9090/soap/hello");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        // Get Response.
        InputStream is = conn.getInputStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        final String line = rd.readLine();
        // Verify the response.
        Assert.assertEquals("Exepcted another SOAP answer ...",
                "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
                    "<soap:Body>" +
                        "<ns2:helloResponse xmlns:ns2=\"http://sdicons.com/\"><return>SOAP Service - Hello World!</return></ns2:helloResponse>" +
                    "</soap:Body>" +
                "</soap:Envelope>", line);
    }
}
