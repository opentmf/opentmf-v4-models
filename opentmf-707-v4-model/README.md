# opentmf-707-v4-model

**TMF-707 Test Result Management API** — concrete model classes implementing the `I*` API from **opentmf-707-v4-api**.

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>opentmf-707-v4-model</artifactId>
    <version>4.0.0.10</version>
</dependency>
```

Call `Tmf707JacksonConfig.registerExtensions` on your `JsonMapper` builder for `@type` / subtype handling; it chains dependent modules automatically.
