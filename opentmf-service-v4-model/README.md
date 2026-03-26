# opentmf-service-v4-model

Shared **model** types for the **Service** group (referenced by many TMF modules). Group membership follows TM Forum’s official Open API portfolio grouping — see [Open APIs](https://www.tmforum.org/open-digital-architecture/open-apis).


- TMF-633: Service Catalog Management API, version: 4.0.0
- TMF-638: Service Inventory Management API, version: 4.0.0
- TMF-640: Service Activation Management API, version: 4.0.0
- TMF-641: Service Ordering Management API, version: 4.1.0
- TMF-645: Service Qualification Management API, version: 4.0.0
- TMF-653: Service Test Management API, version: 4.2.0
- TMF-657: Service Quality Management Management API, version: 4.0.0
- TMF-727: Service Usage Management API, version: 4.0.0

Usually pulled in transitively. To depend explicitly:

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>opentmf-service-v4-model</artifactId>
    <version>4.2.0.0</version>
</dependency>
```

For JSON polymorphism, register `TmfServiceJacksonConfig` on your `ObjectMapper` (see root README).
