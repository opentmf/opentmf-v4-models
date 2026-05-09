# opentmf-673-v4-model

**TMF-673 Geographic Address Management API** — concrete model classes implementing the `I*` API from **opentmf-673-v4-api**.

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>opentmf-673-v4-model</artifactId>
    <version>4.0.0.11</version>
</dependency>
```

Call `Tmf673JacksonConfig.registerExtensions` on your `JsonMapper` builder for `@type` / subtype handling; it chains dependent modules automatically.
