# opentmf-671-v4-model

**TMF-671 Promotion Management API** — concrete model classes implementing the `I*` API from **opentmf-671-v4-api**.

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>opentmf-671-v4-model</artifactId>
    <version>4.1.0.10</version>
</dependency>
```

Call `Tmf671JacksonConfig.registerExtensions` on your `JsonMapper` builder for `@type` / subtype handling; it chains dependent modules automatically.
