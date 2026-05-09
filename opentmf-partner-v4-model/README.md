# opentmf-partner-v4-model

Shared **model** types for the **Partner** group (referenced by many TMF modules). Group membership follows TM Forum’s official Open API portfolio grouping — see [Open APIs](https://www.tmforum.org/open-digital-architecture/open-apis).

- TMF-632: Party Management API, version: 4.0.0
- TMF-644: Privacy Management API, version: 4.0.0
- TMF-651: Agreement Management API, version: 4.0.0
- TMF-666: Account Management API, version: 4.0.0
- TMF-668: Partnership Type, version: 4.0.0
- TMF-669: Party Role Management API, version: 4.0.0
- TMF-672: User Role Permission Management API, version: 4.0.0
- TMF-683: Party Interaction Management API, version: 4.0.0
- TMF-700: Shipping Order Management API, version: 4.0.0
- TMF-711: Shipment Management Management API, version: 4.0.0
- TMF-713: Work Management, version: 4.0.0

Usually pulled in transitively. To depend explicitly:

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>opentmf-partner-v4-model</artifactId>
    <version>4.0.0.11</version>
</dependency>
```

For JSON polymorphism, register `TmfPartnerJacksonConfig` on your `JsonMapper` (see root README).
