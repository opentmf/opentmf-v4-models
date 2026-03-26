# opentmf-691-v4-model

**TMF-691 Federated ID Management API** — concrete model classes implementing the `I*` API from **opentmf-691-v4-api**.

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>opentmf-691-v4-model</artifactId>
    <version>4.0.0.5</version>
</dependency>
```

Call `Tmf691JacksonConfig.registerExtensions` on your `JsonMapper` builder for `@type` / subtype handling; it chains dependent modules automatically.
