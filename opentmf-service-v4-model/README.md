# opentmf-service-v4-model

This artifact holds the TMF v4 model classes for the Service portfolio.

Common classes that are referenced from the following TMF artifacts:
- TMF-633: Service Catalog Management API, version: 4.0.0
- TMF-638: Service Inventory Management API, version: 4.0.0
- TMF-641: Service Ordering Management API, version: 4.1.0

## Usage
This model library is automatically included from the Service portfolio TMF model
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
#### Import opentmf-service-v4-model Module
```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>opentmf-service-v4-model</artifactId>
</dependency>
```

### 2. Configure the ObjectMapper
In order to benefit dynamic type resolving, you need to provide a primary ObjectMapper bean within
your microservice and call the registerExtensions method of this tmf-service-model library.

```java
@Configuration
public class JacksonConfig {

  @Bean
  @Primary
  public ObjectMapper objectMapper() {
    var objectMapper = JacksonUtil.getDefaultObjectMapper();
    TmfServiceJacksonConfig.registerExtensions(objectMapper);
    return objectMapper;
  }
}
```
