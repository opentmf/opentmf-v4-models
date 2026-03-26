# opentmf-727-v4-model

**TMF-727 Service Usage Management API** — concrete model classes implementing the `I*` API from **opentmf-727-v4-api**.

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>opentmf-727-v4-model</artifactId>
    <version>4.0.0.10</version>
</dependency>
```

Call `Tmf727JacksonConfig.registerExtensions` on your `JsonMapper` builder for `@type` / subtype handling; it chains dependent modules automatically.
