# opentmf-638-v4-model

**TMF-638 Service Inventory Management API** — concrete model classes implementing the `I*` API from **opentmf-638-v4-api**.

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>opentmf-638-v4-model</artifactId>
    <version>4.0.0.11</version>
</dependency>
```

Call `Tmf638JacksonConfig.registerExtensions` on your `JsonMapper` builder for `@type` / subtype handling; it chains dependent modules automatically.
