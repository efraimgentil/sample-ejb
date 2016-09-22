## SAMPLEJEE JSF

This project was made to show some features of JSF 2.2 and to self study

## What is JSF

Java Server Faces is a standard java framework, it  uses  component based  approach to develop Java Web pages and it firmily follows the Model-View-Controller(MVC) design pattern.

## How it works

Every request is processed by the FacesServlet, that loads the request view model, and construct the component tree, process the events , and presents the response normally as a HTML. Each component state, user interface  and other marked objects are saved in the end of each request , this process is called stateSaving, and the state is restored in the next request of the same view, objects and states can be saved in both sides client and server

## Configuration of the FacesServlet

You need to configure the FacesServlet so it can handle every request of ".jsf" pages (the jsf sufix is not a obligation you can use diferent sufixes like .html or .mypages"


```xml
<web-app>
 ...
  <!-- web.xml !-->
  <servlet>
    <servlet-name>FacesServlet</servlet-name>
    <servlet-class>javax.faces.webapp.FacesServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>FacesServlet</servlet-name>
    <url-pattern>*.jsf</url-pattern>
  </servlet-mapping>
  ...
 </web-app>
```

You also need to create a file named faces-config.xml in you WEB-INF directory, it is not realy necessary to run the application
but you will see this file often with some configuration related to jsf.

```xml
<?xml version="1.0"?>
<faces-config version="2.2" xmlns="http://xmlns.jcp.org/xml/ns/javaee"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-facesconfig_2_2.xsd">
</faces-config>
```

To work with JSF you will be using .xhtml files, is the same of html files but with more rigid rules about the tags, to create a simple page see

```xml
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:ui="http://java.sun.com/jsf/facelets"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:h="http://java.sun.com/jsf/html"> 
<h:head></h:head> 
<body> 
	<h:outputText value=" Hello " />
</body> 
</html>
```
 