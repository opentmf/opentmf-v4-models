# opentmf-general-v4-model

Shared **model** types for the **General** group (referenced by many TMF modules). Group membership follows TM Forum’s official Open API portfolio grouping — see [Open APIs](https://www.tmforum.org/open-digital-architecture/open-apis).


- TMF-621: Trouble Ticket Management API, version: 4.0.0
- TMF-649: Performance Thresholding Management API, version: 4.0.0
- TMF-655: Change Management API, version: 4.0.0
- TMF-662: Entity Catalog Management API, version: 4.0.0
- TMF-667: Document Management API, version: 4.0.0
- TMF-673: Geographic Address Management API, version: 4.0.0
- TMF-674: Geographic Site Management API, version: 4.0.0
- TMF-675: Geographic Location Management API, version: 4.0.0
- TMF-681: Communication Management API, version: 4.0.0
- TMF-686: Topology API, version: 4.0.0
- TMF-688: Event Management API, version: 4.0.0
- TMF-691: Federated ID Management API, version: 4.0.0
- TMF-701: Process Flow Management API, version: 4.1.0
- TMF-703: Entity Inventory Management API, version: 4.0.0
- TMF-704: Test Case Management API, version: 4.0.0
- TMF-705: Test Environment Management API, version: 4.0.0
- TMF-706: Test Data Management API, version: 4.0.0
- TMF-707: Test Result Management API, version: 4.0.0
- TMF-708: Test Execution Management API, version: 4.0.0
- TMF-709: Test Scenario Management API, version: 4.0.0
- TMF-710: General Test Artifact Management API, version: 4.0.0
- TMF-714: Work Qualification Management, version: 4.0.0
- TMF-715: Warranty Management, version: 4.0.0
- TMF-720: Digital Identity Management API, version: 4.0.0
- TMF-724: Incident Management API, version: 4.0.0
- TMF-725: Metadata Catalog Management API, version: 4.0.0
- TMF-728: Dunning Case Management, version: 4.0.0
- TMF-915: AI Management API, version: 4.0.0
- TMF-921: Intent Management API, version: 4.0.0

Usually pulled in transitively. To depend explicitly:

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>opentmf-general-v4-model</artifactId>
    <version>4.1.0.0</version>
</dependency>
```

For JSON polymorphism, register `TmfGeneralJacksonConfig` on your `ObjectMapper` (see root README).
