# opentmf-620-v4-model

**TMF-620 Product Catalog Management API** — concrete model classes implementing the `I*` API from **opentmf-620-v4-api**.

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>opentmf-620-v4-model</artifactId>
    <version>4.1.0.5</version>
</dependency>
```

Call `Tmf620JacksonConfig.registerExtensions` on your `JsonMapper` builder for `@type` / subtype handling; it chains dependent modules automatically.
