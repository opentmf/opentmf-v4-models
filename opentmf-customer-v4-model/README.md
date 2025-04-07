# opentmf-customer-v4-model

This artifact holds the TMF v4 model classes for the Customer portfolio.

Common classes that are referenced from the following TMF artifacts:
- TMF-629: Customer Management API, version: 4.0.0
- TMF-632: Party Management API, version: 4.0.0
- TMF-666: Account Management API, version: 4.0.0
- TMF-669: Party Role Management API, version: 4.0.0

## Usage
This model library is automatically included from the Customer portfolio TMF model
libraries. Hence, normally it is not necessary to explicitly specify a maven dependency.

If however, for edge use cases it becomes necessary to reference this library directly,
the following two steps needs to be carried out:

### 1. Add Maven Dependency
#### Import OpenTMF Commons Dependencies
```xml
<dependencyManagement>
  <dependency>
    <groupId>org.opentmf</groupId>
    <artifactId>opentmf-versions</artifactId>
    <version>RELEASE</version>
    <type>pom</type>
    <scope>import</scope>
  </dependency>
</dependencyManagement>
```
#### Import opentmf-customer-v4-model Module
```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>opentmf-customer-v4-model</artifactId>
</dependency>
```

### 2. Configure the ObjectMapper
In order to benefit dynamic type resolving, you need to provide a primary ObjectMapper bean within
your microservice and call the registerExtensions method of this tmf-customer-model library.

```java
@Configuration
public class JacksonConfig {

  @Bean
  @Primary
  public ObjectMapper objectMapper() {
    var objectMapper = JacksonUtil.getDefaultObjectMapper();
    TmfCustomerJacksonConfig.registerExtensions(objectMapper);
    return objectMapper;
  }
}
```
