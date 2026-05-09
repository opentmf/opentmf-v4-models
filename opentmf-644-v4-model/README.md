# opentmf-644-v4-model

**TMF-644 Privacy Management API** — concrete model classes implementing the `I*` API from **opentmf-644-v4-api**.

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>opentmf-644-v4-model</artifactId>
    <version>4.0.0.11</version>
</dependency>
```

Call `Tmf644JacksonConfig.registerExtensions` on your `JsonMapper` builder for `@type` / subtype handling; it chains dependent modules automatically.
