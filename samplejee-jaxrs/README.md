## SAMPLEJEE JAX-RS

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
Getting started with a simple resource, it will responds to the url: "${your_host/projectName}/rest/hello", notice the annotation @GET it specifies that this method will only respond to HTTP get method, besides the @GET there is also @POST,@PUT,@HEAD,@DELETE and @OPTIONS each representing an HTTP method

```java
@Path("/hello")
public class HelloResource {
	
	@GET
	public String helloWorld(){
		return "Hello darkness my old friend";
	}
	
}
```

You also can respond with different content-types for the same url, the decision which type will be used will use the header "Accept" that is sent in the request, if no producer is found it will try to respond with the best suited one. (  Remember to add the related content-type providers libraries  )

Obs: You can use DHC to do the request tests 

```java
@Path("/hello")
public class HelloResource {
	
	private String message = "Hello darkness my old friend"; 
	
	@GET
	@Produces( MediaType.TEXT_PLAIN )
	public String helloWorld(){
		return message;
	}
	
	@GET
	@Produces( MediaType.APPLICATION_XML )
	public Message helloWorldXml(){
		return new Message( message );
	}
	
	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public Map<String, Object> helloWorldJson(){
		Map<String, Object> map = new HashMap<>();
		map.put("message", message );
		return map;
	}
	
	// ...
}
```

  
