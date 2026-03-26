# opentmf-675-v4-model

**TMF-675 Geographic Location Management API** — concrete model classes implementing the `I*` API from **opentmf-675-v4-api**.

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>opentmf-675-v4-model</artifactId>
    <version>4.0.0.5</version>
</dependency>
```

Call `Tmf675JacksonConfig.registerExtensions` on your `JsonMapper` builder for `@type` / subtype handling; it chains dependent modules automatically.
