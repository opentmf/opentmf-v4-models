# opentmf-683-v4-model

**TMF-683 Party Interaction Management API** — concrete model classes implementing the `I*` API from **opentmf-683-v4-api**.

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>opentmf-683-v4-model</artifactId>
    <version>4.0.0.5</version>
</dependency>
```

Call `Tmf683JacksonConfig.registerExtensions` on your `JsonMapper` builder for `@type` / subtype handling; it chains dependent modules automatically.
