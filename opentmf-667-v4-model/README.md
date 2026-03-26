# opentmf-667-v4-model

**TMF-667 Document Management API** — concrete model classes implementing the `I*` API from **opentmf-667-v4-api**.

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>opentmf-667-v4-model</artifactId>
    <version>4.0.0.10</version>
</dependency>
```

Call `Tmf667JacksonConfig.registerExtensions` on your `JsonMapper` builder for `@type` / subtype handling; it chains dependent modules automatically.
