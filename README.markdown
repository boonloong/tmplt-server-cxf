# CXF REST/SOAP
## Description

The goal of this template is to have a basic CXF server, ready to be run in Tomcat.
Both REST service and SOAP service based on standard JAX-RS and JAX-WS using the Apache CXF framework.
The Spring configuration is based on annotations, no XML context files!

The special thing about the CXFServlet is that it detects the presence of the Spring context
and will fetch the SOAP and REST configurations directly from this context. You don't need extra
wiring to connect Spring and CXF, CXF uses the Spring context automatically as a meeting point
for server and service definitions.

## Usage
### Adding a service

* Create the service. Don't forget to register it in the JAXRSServerFactoryBean in the AppConfig.java.
CXF does not scan the packages to find the resources.
* If you have new JAXB annotated classes that will be used in the REST interface, you have to
register these JAXB classes explicitly in the provider list in AppConfig.java. By default CXF provides
 a mechanism to create a MessageBodyReader/Writer for each JAXB annotated class.

## Features

* Standard Java web application.
* CXF REST + SOAP frontends.
* Spring configuration (annotation based).

## Notes

* At least Java 1.6 needed for the Spring annotations.
* In Spring +3.1 @ComponentScan becomes available, so you do not need to create the beans explicitly.
* You should run it as a Tomcat application. It was tested with Tomcat 6 and 7.

## Links

+ CXF services page: ["http://localhost:8080/"](http://localhost:8080/)
+ REST service: ["http://localhost:8080/rest/hello?name=Bruno"]("http://localhost:8080/rest/hello?name=Bruno") (parameter is optional)
+ SOAP service: ["http://localhost:8080/soap/hello?name=Bruno"](http://localhost:8080/soap/hello?name=Bruno) (parameter is optional)

## Files

* **/README.txt**: This file.
* **/pom.xml**: The Maven configuration file.
   1. Spring core + web.
   1. CXF core + SOAP front end + REST front end.
* **/src/main/java/com/sdicons/AppConfig.java**: The Spring configuration class
replacing the XML configuration. It produces all the application instances.
* **/src/main/java/com/sdicons/Message.java**: A JAXB annotated class that can be rendered
to JSON or to XML.
* **/src/main/java/com/sdicons/RestService.java**: A plain JAX-RS 'hello' service.
* **/src/main/java/com/sdicons/SoapService.java**: A plain JAX-WS 'hello' service.
* **/src/main/webapp/WEB-INF/web.xml**: Standard Java web application.
   1. CXF Servlet configuration.
   1. Spring context setup to pick up our AppConfig class to initialize the context.

## Conclusion

The CXF servlet integrates well with Spring. You can rely on it that future versions will do this as well.

It is a plus that the CXF servlet integrates both SOAP as REST services in similar ways.

It can be a burden to register all resource, provider and JAXB class each time. But on the other hand
it is a transparent system that you could modify or extend. There is no hidden mechanism in here it
follows the JAXRS standard.
