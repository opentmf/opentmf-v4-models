# opentmf-v4-models

Concrete **TM Forum data model** classes (Lombok, Jackson, validation) generated from the official OpenAPI specs. Each class implements the matching getter-only interface from **opentmf-v4-api**.

Multi-module layout: shared types live in common-group modules; TMF-specific types live in per-TMF modules. **Common-group boundaries** follow the official portfolio grouping published by TM Forum — see [Open APIs](https://www.tmforum.org/open-digital-architecture/open-apis).

Modules covered:

- [TMF-620](opentmf-620-v4-model/README.md) Product Catalog Management API
- [TMF-621](opentmf-621-v4-model/README.md) Trouble Ticket Management API
- [TMF-622](opentmf-622-v4-model/README.md) Product Ordering Management API
- [TMF-629](opentmf-629-v4-model/README.md) Customer Management API
- [TMF-632](opentmf-632-v4-model/README.md) Party Management API
- [TMF-633](opentmf-633-v4-model/README.md) Service Catalog Management API
- [TMF-634](opentmf-634-v4-model/README.md) Resource Catalog Management API
- [TMF-635](opentmf-635-v4-model/README.md) Usage Management API
- [TMF-637](opentmf-637-v4-model/README.md) Product Inventory Management API
- [TMF-638](opentmf-638-v4-model/README.md) Service Inventory Management API
- [TMF-639](opentmf-639-v4-model/README.md) Resource Inventory Management API
- [TMF-640](opentmf-640-v4-model/README.md) Service Activation Management API
- [TMF-641](opentmf-641-v4-model/README.md) Service Ordering Management API
- [TMF-642](opentmf-642-v4-model/README.md) Alarm Management API
- [TMF-644](opentmf-644-v4-model/README.md) Privacy Management API
- [TMF-645](opentmf-645-v4-model/README.md) Service Qualification Management API
- [TMF-646](opentmf-646-v4-model/README.md) Appointment Management API
- [TMF-648](opentmf-648-v4-model/README.md) Quote Management API
- [TMF-649](opentmf-649-v4-model/README.md) Performance Thresholding Management API
- [TMF-651](opentmf-651-v4-model/README.md) Agreement Management API
- [TMF-652](opentmf-652-v4-model/README.md) Resource Order Management API
- [TMF-653](opentmf-653-v4-model/README.md) Service Test Management API
- [TMF-654](opentmf-654-v4-model/README.md) Prepay Balance Management API
- [TMF-655](opentmf-655-v4-model/README.md) Change Management API
- [TMF-657](opentmf-657-v4-model/README.md) Service Quality Management Management API
- [TMF-658](opentmf-658-v4-model/README.md) Loyalty
- [TMF-662](opentmf-662-v4-model/README.md) Entity Catalog Management API
- [TMF-663](opentmf-663-v4-model/README.md) Shopping Cart Management API
- [TMF-664](opentmf-664-v4-model/README.md) Resource Function Activation Management API
- [TMF-666](opentmf-666-v4-model/README.md) Account Management API
- [TMF-667](opentmf-667-v4-model/README.md) Document Management API
- [TMF-668](opentmf-668-v4-model/README.md) Partnership Type
- [TMF-669](opentmf-669-v4-model/README.md) Party Role Management API
- [TMF-670](opentmf-670-v4-model/README.md) Payment Method Management API
- [TMF-671](opentmf-671-v4-model/README.md) Promotion Management API
- [TMF-672](opentmf-672-v4-model/README.md) User Role Permission Management API
- [TMF-673](opentmf-673-v4-model/README.md) Geographic Address Management API
- [TMF-674](opentmf-674-v4-model/README.md) Geographic Site Management API
- [TMF-675](opentmf-675-v4-model/README.md) Geographic Location Management API
- [TMF-676](opentmf-676-v4-model/README.md) Payment Management API
- [TMF-677](opentmf-677-v4-model/README.md) Usage Consumption Management API
- [TMF-678](opentmf-678-v4-model/README.md) Customer Bill Management API
- [TMF-679](opentmf-679-v4-model/README.md) Product Offering Qualification Management API
- [TMF-680](opentmf-680-v4-model/README.md) Recommendation Management API
- [TMF-681](opentmf-681-v4-model/README.md) Communication Management API
- [TMF-683](opentmf-683-v4-model/README.md) Party Interaction Management API
- [TMF-686](opentmf-686-v4-model/README.md) Topology API
- [TMF-687](opentmf-687-v4-model/README.md) Stock Management API
- [TMF-688](opentmf-688-v4-model/README.md) Event Management API
- [TMF-691](opentmf-691-v4-model/README.md) Federated ID Management API
- [TMF-696](opentmf-696-v4-model/README.md) Risk Management API
- [TMF-699](opentmf-699-v4-model/README.md) Sales Management API
- [TMF-700](opentmf-700-v4-model/README.md) Shipping Order Management API
- [TMF-701](opentmf-701-v4-model/README.md) Process Flow Management API
- [TMF-702](opentmf-702-v4-model/README.md) Resource Activation Management API
- [TMF-703](opentmf-703-v4-model/README.md) Entity Inventory Management API
- [TMF-704](opentmf-704-v4-model/README.md) Test Case Management API
- [TMF-705](opentmf-705-v4-model/README.md) Test Environment Management API
- [TMF-706](opentmf-706-v4-model/README.md) Test Data Management API
- [TMF-707](opentmf-707-v4-model/README.md) Test Result Management API
- [TMF-708](opentmf-708-v4-model/README.md) Test Execution Management API
- [TMF-709](opentmf-709-v4-model/README.md) Test Scenario Management API
- [TMF-710](opentmf-710-v4-model/README.md) General Test Artifact Management API
- [TMF-711](opentmf-711-v4-model/README.md) Shipment Management Management API
- [TMF-713](opentmf-713-v4-model/README.md) Work Management
- [TMF-714](opentmf-714-v4-model/README.md) Work Qualification Management
- [TMF-715](opentmf-715-v4-model/README.md) Warranty Management
- [TMF-716](opentmf-716-v4-model/README.md) ResourceReservation
- [TMF-717](opentmf-717-v4-model/README.md) Customer360 Management API
- [TMF-720](opentmf-720-v4-model/README.md) Digital Identity Management API
- [TMF-724](opentmf-724-v4-model/README.md) Incident Management API
- [TMF-725](opentmf-725-v4-model/README.md) Metadata Catalog Management API
- [TMF-727](opentmf-727-v4-model/README.md) Service Usage Management API
- [TMF-728](opentmf-728-v4-model/README.md) Dunning Case Management
- [TMF-730](opentmf-730-v4-model/README.md) Software And Compute Management API
- [TMF-908](opentmf-908-v4-model/README.md) IoT Agent and Device Management API
- [TMF-915](opentmf-915-v4-model/README.md) AI Management API
- [TMF-921](opentmf-921-v4-model/README.md) Intent Management API

## Diagram

[PlantUML](opentmf-v4-models.puml) in the project root.

## Depends on

- **opentmf-v4-api** — `I*` interfaces (and enums when generated there).
- **opentmf-commons** — validation annotations, `JacksonUtil`, helpers.

## OpenTMF version alignment (BOM)

Import **`opentmf-versions`** in `<dependencyManagement>` so OpenTMF artifacts (models, APIs, commons, etc.) stay on aligned versions:

```xml
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>org.opentmf</groupId>
      <artifactId>opentmf-versions</artifactId>
      <version>LATEST</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>
```

**Replace `LATEST` with a fixed `opentmf-versions` release** (e.g. the current line you standardize on). Maven still resolves `LATEST` / `RELEASE` in some setups, but those keywords are **deprecated for reproducible builds** and are effectively **EOL** as a practice — **use a static version for build consistency** (CI, audits, and local builds should all see the same bill of materials).

## Jackson

Register polymorphic subtypes once per TMF module you use directly; each `Tmf*JacksonConfig.registerExtensions` chains parent commons.

```java
@Bean @Primary
public ObjectMapper objectMapper() {
  var b = JsonMapper.builder();
  Tmf622JacksonConfig.registerExtensions(b);
  return b.build();
}
```

## Requirements

Java 17+.
