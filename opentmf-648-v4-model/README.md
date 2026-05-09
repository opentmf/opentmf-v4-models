# opentmf-648-v4-model

**TMF-648 Quote Management API** — concrete model classes implementing the `I*` API from **opentmf-648-v4-api**.

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>opentmf-648-v4-model</artifactId>
    <version>4.0.0.11</version>
</dependency>
```

Call `Tmf648JacksonConfig.registerExtensions` on your `JsonMapper` builder for `@type` / subtype handling; it chains dependent modules automatically.
