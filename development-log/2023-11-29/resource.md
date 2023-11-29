# Resource
Resource is data or input to the application, which need to be accessed.
Files, Configuration data, images, etc. are the types of resource.

## Resource Interface
package: org.springframework.core.io

types of handled resource : url, classpath, file, etc.

ResourceLoader is the interface for obtaining resource instances.
ApplicationContext extends ResourceLoader, allowing any Spring-managed bean to load resources.

### Example
~~~java
public class Main{
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("conf/appContext.xml");
        
        Bear bear = (Bear) ctx.getBean("bear");
    }
}
~~~
- ApplicationContext : Used as a ResourceLoader.
- conf/appContext.xml : The resource which need to be accessed.
- ctx.getBean("bear) : A method to get the data which is the purpose of the resource access process.