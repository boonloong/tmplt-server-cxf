CXF REST/SOAP
=============

Description:
The goal of this template is to have a basic CXF server, ready to be run in Tomcat.
Both REST service and SOAP service based on standard JAX-RS and JAX-WS using the Apache CXF framework.
The Spring configuration is based on annotations, no XML context files!

The special thing about the CXFServlet is that it detects the presence of the Spring context
and will fetch the SOAP and REST configurations directly from this context. You don't need extra
wiring to connect pring and CXF, CXF uses the Spring context automatically as a meeting point
for server and service definitions.

Features:
* Standard Java web application.
* CXF REST + SOAP frontends.
* Spring configuration (annotation based).

Notes:
* At least Java 1.6 needed for the Spring annotations.
* In Spring +3.1 @ComponentScan becoms available, so you do not need to create the beans explicitly.
* You should run it as a Tomcat application. It was tested with Tomcat 6 and 7.
* Following URL's should be available:
   + CXF services page: "http://localhost:8080/"
   + REST service: "http://localhost:8080/rest/hello?name=Bruno" (parameter is optional)
   + SOAP service: "http://localhost:8080/soap/hello?name=Bruno" (parameter is optional)

Files:
./
   * README.txt -- This file.
   * pom.xml -- The Maven configuration file.
             -- Spring core + web.
             -- CXF core + SOAP front end + REST front end.
./src/main/java/com/sdicons/
   * AppConfig.java -- The Spring configuration class replacing the XML configuration.
                    -- It produces all the application instances.
   * RestService.java -- A plain JAX-RS 'hello' service.
   * SoapService.java -- A plain JAX-WS 'hello' service.
./src/main/webapp/WEB-INF
   * web.xml -- Standard Java web application.
             -- CXF Servlet configuration.
             -- Spring context setup to pick up our AppConfig class to initialize the context.