# opentmf-product-v4-model

Shared **model** types for the **Product** group (referenced by many TMF modules). Group membership follows TM Forum’s official Open API portfolio grouping — see [Open APIs](https://www.tmforum.org/open-digital-architecture/open-apis).


- TMF-620: Product Catalog Management API, version: 4.1.0
- TMF-635: Usage Management API, version: 4.0.0
- TMF-637: Product Inventory Management API, version: 4.0.0
- TMF-658: Loyalty, version: 4.0.0
- TMF-671: Promotion Management API, version: 4.1.0
- TMF-677: Usage Consumption Management API, version: 4.0.0
- TMF-679: Product Offering Qualification Management API, version: 4.0.0

Usually pulled in transitively. To depend explicitly:

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>opentmf-product-v4-model</artifactId>
    <version>4.1.0.10</version>
</dependency>
```

For JSON polymorphism, register `TmfProductJacksonConfig` on your `JsonMapper` (see root README).
