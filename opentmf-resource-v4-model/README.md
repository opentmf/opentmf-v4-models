# opentmf-resource-v4-model

Shared **model** types for the **Resource** group (referenced by many TMF modules). Group membership follows TM Forum’s official Open API portfolio grouping — see [Open APIs](https://www.tmforum.org/open-digital-architecture/open-apis).

- TMF-634: Resource Catalog Management API, version: 4.1.0
- TMF-639: Resource Inventory Management API, version: 4.0.0
- TMF-642: Alarm Management API, version: 4.0.0
- TMF-652: Resource Order Management API, version: 4.0.0
- TMF-664: Resource Function Activation Management API, version: 4.0.0
- TMF-687: Stock Management API, version: 4.0.0
- TMF-702: Resource Activation Management API, version: 4.0.0
- TMF-716: ResourceReservation, version: 4.0.0
- TMF-730: Software And Compute Management API, version: 4.0.0
- TMF-908: IoT Agent and Device Management API, version: 4.0.0

Usually pulled in transitively. To depend explicitly:

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>opentmf-resource-v4-model</artifactId>
    <version>4.1.0.11</version>
</dependency>
```

For JSON polymorphism, register `TmfResourceJacksonConfig` on your `JsonMapper` (see root README).
