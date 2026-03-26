# opentmf-657-v4-model

**TMF-657 Service Quality Management Management API** — concrete model classes implementing the `I*` API from **opentmf-657-v4-api**.

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>opentmf-657-v4-model</artifactId>
    <version>4.0.0.5</version>
</dependency>
```

Call `Tmf657JacksonConfig.registerExtensions` on your `JsonMapper` builder for `@type` / subtype handling; it chains dependent modules automatically.
