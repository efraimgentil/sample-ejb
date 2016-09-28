## SAMPLEJEE CORE IMPL ( EJB Implementations )

This project was made to show some features of EJB 3.1 and to self study

## What is EJB 

Enterprise Java Beans is a standard java framework, it encapsulates the business logic of the application in the server side, it is intended to handle the commons concerns such as persistence, transaction integrity and security in a standard way.

There is two types of beans, Session beans and Message Drive beans.


## Session Beans

There are three types of Session beans , Stateless , Stateful and Singleton, each with their particularities. Also each session bean can be @Local and @Remote. The @Local can be accessed in the same JVM and same ecapsuled resource, the specification also says that some implementations may support the injection of a @Local resource in a diferente application, but in the same JVM. The @Remote can be accessed through different JVMs. 

All beans supports asynchronous executions. 


**Stateless**

The Stateless Session bean, are business objects that doesn't have an state associated to then, so the the state of instance variables are not guaranteed between calls, it also can be backed by a pool of instances for easy handle multiple calls for the same bean.

```java
//Assume that are diferent files
@Local \\@Remote
public interface HelloWorld{

	String helloWorld();
	
}
//Assume that are diferent files
@Stateless
public class HelloWorldImpl implements HelloWorld {

	public String helloWorld() {
		return "Hello world local";
	}

}
```

To create a asynchronous , you just need to annotate your method with the @Asynchronous
```java
@LocalBean
@Stateless
public class AsyncLocalBean {

	@Asynchronous
	public Future<String> asyncHello() throws InterruptedException{
		Thread.sleep(10000L);
		System.out.println("OK ?");
		return new AsyncResult<>("Hello");
	}
	
}
```


**Stateful**
The Stateful session bean, as the name suggests, maintains state, they keep track of the client through session, only one client can access the bean at time, also these beans can be passivated by the container, if they are not accessed for a long time, with that freeing some memory

```java
//Assume that are diferent files
@Local
public interface StatefulHelloWorld{

	String helloWorld();
	
}
//Assume that are diferent files
@Stateful
public class StatefulHelloWorldImpl implements StatefulHelloWorld {
	
	private Integer callCount = 0;
	
	public String helloWorld() {
		return "Hello world local " + (++callCount);
	}

}
```


