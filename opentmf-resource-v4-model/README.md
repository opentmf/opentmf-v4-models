# opentmf-resource-v4-model

This artifact holds the TMF v4 model classes for the Resource portfolio.

Common classes that are referenced from the following TMF artifacts:
- TMF-634: Resource Catalog Management API, version: 4.1.0
- TMF-639: Resource Inventory Management API, version: 4.0.0
- TMF-652: Resource Order Management API, version: 4.0.0

## Usage
This model library is automatically included from the Resource portfolio TMF model
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
#### Import opentmf-resource-v4-model Module
```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>opentmf-resource-v4-model</artifactId>
</dependency>
```

### 2. Configure the ObjectMapper
In order to benefit dynamic type resolving, you need to provide a primary ObjectMapper bean within
your microservice and call the registerExtensions method of this tmf-resource-model library.

```java
@Configuration
public class JacksonConfig {

  @Bean
  @Primary
  public ObjectMapper objectMapper() {
    var objectMapper = JacksonUtil.getDefaultObjectMapper();
    TmfResourceJacksonConfig.registerExtensions(objectMapper);
    return objectMapper;
  }
}
```
