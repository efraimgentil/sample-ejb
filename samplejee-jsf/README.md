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

To work with JSF you will be using .xhtml files, is the same of html files but with more rigid rules about the tags, to create a simple page see the next example,
be aware about the tag "h:head" instead of "head" it is used so jsf can include some of their javascript libraries as needed

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
 
## Managed Beans

With JSF you can create ManagedBeans to control your views and maintain states or control the view flow, in the same view you can have one or more managedBean, the beans can have diferents scopes like RequestScoped live for one request, ViewScoped live while in the same view, SessionScoped live while in the same session or  ApplicationScoped lives for the entire application life time.
Be aware of that in JSF 2.2 you should use the @Named annotation to mark your beans, and use the annotations of the package "javax.enterprise.context" to say the scope of your bean, except for the @ViewScoped annotation that the package is "javax.faces.view.ViewScoped"

**if you try to use the annotations of the package "javax.faces.bean" with the @Named annotation it will not works as spected**	

```java
//...
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class MyManagedBean implements Serializable { //ViewScoped and SessionScoped should be serializable
	//...
	private String name;
	
	public String getName(){ return name; }
	public void setName(String name ){ this.name = name; }
}
``` 

The beans also respects the java bean rules, so to access or set an attribute you need the public get/set  methods

```xml
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:ui="http://java.sun.com/jsf/facelets"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:h="http://java.sun.com/jsf/html"> 
<h:head></h:head> 
<body> 
	<!-- To access the bean in the xhtml file you use the name of the bean if u didn't specify any name in the annotation, the bean name will be the class name with the first letter in lowercase -->
	<h:outputText value=" Hello #{myManagedBean.name}" />
	<!-- it will use the getName method to access the attribute -->
</body> 
</html>
```


## JSF Lifecycle

The jsf application life cycle consist of six phases
- Restore view phase
- Apply request value phase; process events
- Process validations phase; process events
- Update model values phase; process events
- Invoke application phase; process events
- Render response phase

** Restore view phase **: Begins as soon as JSF Servlet receives a request, during this phase, the JSF builds the view , wires event handlers and validators to UI components and saves the view in the FacesContext instance. The FacesContext instance will now contains all the information required to process the request.

** Apply request value phase **: After the component tree is created/restored, each component in component tree uses decode method to extract its new value from the request parameters. Component stores this value. If the conversion fails, an error message is generated and queued on FacesContext. This message will be displayed during the render response phase, along with any validation errors.
If any decode methods / event listeners called renderResponse on the current FacesContext instance, the JSF moves to the render response phase.

** Process validations phase **: During this phase, the JSF processes all validators registered on component tree. It examines the component attribute rules for the validation and compares these rules to the local value stored for the component.
If the local value is invalid, the JSF adds an error message to the FacesContext instance, and the life cycle advances to the render response phase and display the same page again with the error message.

** Update model values phase **: After the JSF checks that the data is valid, it walks over the component tree and set the corresponding server-side object properties to the components' local values. The JSF will update the bean properties corresponding to input component's value attribute.
If any updateModels methods called renderResponse on the current FacesContext instance, the JSF moves to the render response phase.

** Invoke application phase **:During this phase, the JSF handles any application-level events, such as submitting a form, execution a action/action listener or linking to another page.

** Render response phase **: During this phase, the JSF asks container/application server to render the page if the application is using JSP pages. For initial request, the components represented on the page will be added to the component tree as the JSP container executes the page. If this is not an initial request, the component tree is already built so components need not to be added again. In either case, the components will render themselves as the JSP container/Application server traverses the tags in the page.
After the content of the view is rendered, the response state is saved so that subsequent requests can access it and it is available to the restore view phase.

Reference: https://www.tutorialspoint.com/jsf/jsf_life_cycle.htm

You can configure a listener to monitor the phases, you just need creating a class that implements the javax.faces.event.PhaseListener interface, and configure the listener in the faces-config.xml

```java
public class MyRestoreViewPhaseListener implements PhaseListener {

	@Override
	public void afterPhase(PhaseEvent event) {
		System.out.println("View restored");
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		System.out.println("Restoring the view");
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW; //Here you specify with phase it will listen
	}

}
```

```xml
<?xml version="1.0"?>
<faces-config version="2.2" xmlns="http://xmlns.jcp.org/xml/ns/javaee"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-facesconfig_2_2.xsd">
	...
	<lifecycle>
		<phase-listener>me.efraimgentil.samplejeejsf.listener.MyRestoreViewPhaseListener</phase-listener>
		<phase-listener>me.efraimgentil.samplejeejsf.listener.MyRenderResponsePhaseListener</phase-listener>
	</lifecycle>
	...
</faces-config>
``` 
