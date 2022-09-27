# Project Structure
    - pom.xml : Dependency file. For each of the time maven changes we should rebuild the project, by clicking 
        on maven tab.
    - src -> test : For the testing purposes.
    - src -> main -> java: The base source file system for our springboot application.
    - src -> main -> resources: Contains applications.properties where we can add the aplication properties. 
        The static and templates is where we add web components like HTML, CSS, JS etc..
    - The maven lifecycle can be build using maven lifecycle.(install,clean etc..)
    - @SpringbootConfiguration in base file.
    - The base file contains @EnableAutoConfiguration to include all the depedency changes auto.
    - The @Component annotation scan all compoenents and find depedency and tell spring to maintain memory manage.
# Important Annotations
    - @Bean : Method level annotation, used to return a srping bean.
    - @Autowired: Variable level annotation, Dependency injection on one instance of object in other class.
    - @Configuration: Class level annotation, where the bean is defined. And make class as singleton bean.
    - @ComponentScan : Scan all singleton beans in a package.
    - @Service - To declare the service class.
    - @RequestMapping: Map the request URL to a method.
    - @GetMapping, @PostMapping, @PutMapping, @DeleteMapping, @PatchMapping
    - @RequestParam, @RequestHeader: Used to get the request data. 
# SpringBootRest
    - We use SringIntiliazr web application to generate the springbbot application or else we can
        use the plugin of SpringBoot Initializr in IntelliJ to build a springboot app project.
    - We can add the configuration , names, dependencies (Web, JPA, Mysql/NoSQL server etc..) in prior 
        to the build application.
# Dependency Change
    - Change in project dependency pom.xml file, we need to reload the project, by right click on pom.xml and reload
        project in maven option.
    - And run project again. Or we can actually rebuild the project again from mavan sidebar tab.
# Starting Server
    - The base file or starting point will be the class with the annotation @SpringBootApplication.
    - Run the file to run the springboot application.
    - In order to run application the springboot itself starts a tomcat server.
    - If we need to stop application running, just stop the Tomcat server.

# Create Simple Rest API
    - Add the REST controller, with annotation for the class @RestController. This makes the corresponding class a
        REST Endpoint class.
    - We can add other annotation @GetMapping, so when hitting the server it will give us a data in accordance with the
        endpoint URL.
    - Now the restarted server will have the endpoint API will be active.

# Spring Container
    - The spring provides a container,  like "JVM" for the Java. Inside JVM we have spring container.
    - The objects is contained in the spring container, called spring bean. Each having scopes of singleton prototype.
    - Inorder to make any class an spring bean we use annotation @Component. So we can do a dependency inject on
         this class.
    - Spring will be create the object of classes mentioned as the @Component on the start of the application.
        Since it uses a singleton design.
# Scope Prototype For Components
     - Since if we use a @Component class, spring will deal it in Singleton way. And if we need object for each call
        of dependency injection we will add another annotation @Scope(value="prototype").
    - So if we add above annotation on each depedency injection it will create an object each time.
# Dependency Injection
    - Using the Inversion controll technique, make code loosely coupled by dependency injection through constructor.
        Eg: class Employee{
            Address address;
            Employee(Address address){
                this.address = address;
            }
        }
    - The run method of 'SpringBootApplication' will give a configurable context.
    - Inorder to make any class an spring bean we use annotation @Component.
    - To generate object of the class with the dependency injection. We can use context.getBean(Classname.class), 
        thereby we could attain an object of the class.
# Autowire
    - A spring bean component that is depended on other spring bean component @Component, can get its reference
        without creating its object.
    - We can use the annotation @Autowire, to literally wire one spring bean component to other spring bean component.
        So that one will get the object reference of other.
    - Thus simply use the other component methods, variables etc..
# Qualifier & Other lookup name for component
    - We can change the search name of component like this,  @Component("newName").
    - Since the lookup name is changed spring will look only for same name for autowired reference,
        so we need to use,  @Qualifier("newName").

# Create REST API layers
    - GET, POST, PUT, DELETE each of them have the different implementation.
    - We can create a rest endpoint by creating a controller class with annotation @RestController.
    - And the class can use @RequestMapping(path = "api/v1/student"), to define mapping of rest url.
    - For default get mapping of class we use annotation @GetMapping for the method.

# Create Service Layer
    - The service layer is mainly used for the bussiness logics implementation.
    - We use the service classes in other classes like REST Controller class etc.. to implement each classes complex
        bussiness logics. 
    - The dependency injection of service class is done in the usage class constructor, 
        @Autowired (with final variable) and service class as @Service (as same as @Component).

# Application properties file
    - Contains set of keys that spring can use the configuration to do some logics.
    - For example we can add the mvc.view.prefix as the prefix path for the view return in the controllers.
    - Different items like, data source url, jpa properties etc.. can be added.
    - Server port can be changed by server.port=8888 etc...
    - spring.datasource.url - with jdbc url 'jdbc:mysql://localhost:3306'
    - For JPA:
        spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
        spring.jpa.hibernate.ddl-auto=update
        spring.jpa.show-sql=true
        spring.jpa.properties.hibernate.format_sql=true
        spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL57InnoDBDialect

# MySQL Install & MySQL in Intellij
    - We can download MySQL server and can use that.
    - We can use the database driver of MySql to connect to specific db.
    - Add DataSource -> Mysql -> with username, password.
    - We can use the plugin for database, to do operrations on DB.

# Create Database Access Layer 
    - Used to access data sources.
    - Map Database class we  add the annotation, @Entity.

# Create Web Application
    - We can create the HTML pages, CSS in resource static folder in src->resources
    - Controller as the entry point, so we can add @Controller annotation for controller class.
        Eg: localhost:8000/home will be point to the Home controller.
# RequestMapping
    - We use @RequestMapping("home") to a method to load when the request matches the string.
    - We use @ResponseBody annotation to return the static response (like string, json, HTML etc..).
    - Inorder to return an HTML page we will return the file name as string eg: return "home.html" as return of method.
    - We use @ResponseBody annotation to return the HTML page as eg: return "home".
# Accepting the client data
    - The method can accept the HttpServletRequest parameter, so the request in URL/ client data can be accepted.
    - Example the localhost:8000/home?name="Himesh", in 
        home(String name, HttpSession session)
            session.setAttribute("name", name);
        OR

        ModelAndView home(@RequestParam("name') String name)
            ModelAndView mv = new ModelAndView();
            mv.addObject("name", name);
            mv.setViewName("home");
            session.setAttribute("name", name);
            return mv
        
        OR

        home(HttpServletRequest request){
            String name  = request.getParameter("name');
            request.setAttribute("name", name);
        }
    We can simply use ModelAndView mv = new ModelAndView(), to return the view with data. SInce the disptacher servlet
    need view and model(data) to render the view on request response.
    Or we can use HttpSession object to store the attribute value.
    Since the request dispatcher servlet is used by Java to render the HTML page we can use same object to pass
    data to html page.
    In HTML page we can refer, ${name}.
# Model in MVC
    - Used to implement the bussiness logics for the MVC pattern web app.
    - Instead of accept the RequestParam in RequestMapping method one by one. We can use the Model as 
        param of method here. And model should contain the variables name as same in RequestUrl.
    -  ModelAndView home(Model md){
            ModelAndView mv = new ModelAndView();
            mv.addObject("model", md);
            mv.setViewName("home");
            session.setAttribute("name", name);
            return mv
        In HTML page we can refer, ${model.name}, ${model.id} etc...