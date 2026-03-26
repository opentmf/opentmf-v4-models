# opentmf-677-v4-model

**TMF-677 Usage Consumption Management API** — concrete model classes implementing the `I*` API from **opentmf-677-v4-api**.

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>opentmf-677-v4-model</artifactId>
    <version>4.0.0.10</version>
</dependency>
```

Call `Tmf677JacksonConfig.registerExtensions` on your `JsonMapper` builder for `@type` / subtype handling; it chains dependent modules automatically.
