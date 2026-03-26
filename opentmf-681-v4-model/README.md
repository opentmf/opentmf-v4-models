# opentmf-681-v4-model

**TMF-681 Communication Management API** — concrete model classes implementing the `I*` API from **opentmf-681-v4-api**.

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>opentmf-681-v4-model</artifactId>
    <version>4.0.0.5</version>
</dependency>
```

Call `Tmf681JacksonConfig.registerExtensions` on your `JsonMapper` builder for `@type` / subtype handling; it chains dependent modules automatically.
