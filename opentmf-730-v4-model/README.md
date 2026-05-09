# opentmf-730-v4-model

**TMF-730 Software And Compute Management API** — concrete model classes implementing the `I*` API from **opentmf-730-v4-api**.

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>opentmf-730-v4-model</artifactId>
    <version>4.0.0.11</version>
</dependency>
```

Call `Tmf730JacksonConfig.registerExtensions` on your `JsonMapper` builder for `@type` / subtype handling; it chains dependent modules automatically.
