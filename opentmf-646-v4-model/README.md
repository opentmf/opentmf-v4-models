# opentmf-646-v4-model

**TMF-646 Appointment Management API** — concrete model classes implementing the `I*` API from **opentmf-646-v4-api**.

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>opentmf-646-v4-model</artifactId>
    <version>4.0.0.11</version>
</dependency>
```

Call `Tmf646JacksonConfig.registerExtensions` on your `JsonMapper` builder for `@type` / subtype handling; it chains dependent modules automatically.
