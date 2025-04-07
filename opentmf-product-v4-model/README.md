# opentmf-product-v4-model

This artifact holds the TMF v4 model classes for the Product portfolio.

Common classes that are referenced from the following TMF artifacts:
- TMF-620: Product Catalog Management API, version: 4.1.0
- TMF-622: Product Ordering Management API, version: 4.0.0
- TMF-637: Product Inventory Management API, version: 4.0.0
- TMF-648: Quote Management API, version: 4.0.0
- TMF-663: Shopping Cart Management API, version: 4.0.0

## Usage
This model library is automatically included from the Product portfolio TMF model
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
#### Import opentmf-product-v4-model Module
```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>opentmf-product-v4-model</artifactId>
</dependency>
```

### 2. Configure the ObjectMapper
In order to benefit dynamic type resolving, you need to provide a primary ObjectMapper bean within
your microservice and call the registerExtensions method of this tmf-product-model library.

```java
@Configuration
public class JacksonConfig {

  @Bean
  @Primary
  public ObjectMapper objectMapper() {
    var objectMapper = JacksonUtil.getDefaultObjectMapper();
    TmfProductJacksonConfig.registerExtensions(objectMapper);
    return objectMapper;
  }
}
```
