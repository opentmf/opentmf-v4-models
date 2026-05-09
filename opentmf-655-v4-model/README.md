# opentmf-655-v4-model

**TMF-655 Change Management API** — concrete model classes implementing the `I*` API from **opentmf-655-v4-api**.

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>opentmf-655-v4-model</artifactId>
    <version>4.0.0.11</version>
</dependency>
```

Call `Tmf655JacksonConfig.registerExtensions` on your `JsonMapper` builder for `@type` / subtype handling; it chains dependent modules automatically.
