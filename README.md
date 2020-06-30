# spring-aop

#What is AOP?
 Spring AOP enables Aspect-Oriented Programming in spring applications.
 A cross-cutting concern is a concern that can affect the whole application and should be centralized in one location in code as possible, such as transaction management, authentication, logging, security etc.
 
 AOP provides the way to dynamically add the cross-cutting concern before, after or around the actual logic using simple pluggable configurations.
 
#What is the difference between concern and cross-cutting concern in Spring AOP?

Concern is behavior which we want to have in a module of an application. Concern may be defined as a functionality we want to implement to solve a specific business problem. E.g. in any eCommerce application different concerns (or modules) may be inventory management, shipping management, user management etc.

Cross-cutting concern is a concern which is applicable throughout the application (or more than one module). e.g. logging , security and data transfer are the concerns which are needed in almost every module of an application, hence they are termed as cross-cutting concerns.

# What are the different advice types in spring?
An advice is the implementation of cross-cutting concern which you are interested in applying on other modules of your application. Advices are of mainly 5 types :

* Before advice : Advice that executes before a join point, but which does not have the ability to prevent execution flow proceeding to the join point (unless it throws an exception). To use this advice, use @Before annotation.
* After returning advice : Advice to be executed after a join point completes normally. For example, if a method returns without throwing an exception. To use this advice, use @AfterReturning annotation.
* After throwing advice : Advice to be executed if a method exits by throwing an exception. To use this advice, use @AfterThrowing annotation.
* After advice : Advice to be executed regardless of the means by which a join point exits (normal or exceptional return). To use this advice, use @After annotation.
* Around advice : Advice that surrounds a join point such as a method invocation. This is the most powerful kind of advice. To use this advice, use @Around annotation.

# What is Spring AOP Proxy?

A proxy is a well-used design pattern. To put it simply, a proxy is an object that looks like another object, but adds special functionality behind the scene.

Spring AOP is proxy-based. AOP proxy is an object created by the AOP framework in order to implement the aspect contracts in runtime.

Spring AOP defaults to using standard JDK dynamic proxies for AOP proxies. This enables any interface (or set of interfaces) to be proxied. Spring AOP can also use CGLIB proxies. This is necessary to proxy classes, rather than interfaces.

CGLIB is used by default if a business object does not implement an interface.


# What is Introduction?

Introductions enable an aspect to declare that advised objects implement any additional interface(s) which they don’t have in real, and to provide an implementation of that interface on behalf of those objects.

An introduction is made using the @DeclareParents annotation.

# what is PointCut
Pointcut is a predicate or expression that matches join points.

# What will happened if we throw exception on @before Advice?
 =>> The original flow will be break i.e. the origin method invocation will not happen.
 

# Can you ordered the Advice execution on same joint-point?

=>> Yes we can ordered the execution of advice execution
    1. we have to keep advice on seperated Aspect
    2. The Aspect can be ordered by implementing Ordered inteface or using @Order(2)
