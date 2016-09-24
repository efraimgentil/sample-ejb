## SAMPLEJEE JSF

This project was made to show some features of JAX-RS (2.0) and to self study

## What is JAX-RS

Is a standard java API for developing RESTful web services according to the REST(Representational State Transfer) architectural pattern

## Getting started

First you need to configure you application path, jax-rs support annotation configuration or the configuration through web.xml

```java
@ApplicationPath(value="/rest")
public class JaxRsApplication extends Application {
	
}
```
or 

```xml
<web-app>
	<servlet>
		<servlet-name>Resteasy</servlet-name>
		<servlet-class>org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher</servlet-class>
	</servlet>

	<servlet-mapping>
		<servlet-name>Resteasy</servlet-name>
		<url-pattern>/rest/*</url-pattern>
	</servlet-mapping>
</web-app>
``` 

First resource

```java
@Path("/hello")
public class HelloResource {
	
	@GET
	public String helloWorld(){
		return "Hello darkness my old friend";
	}
	
}
```

  