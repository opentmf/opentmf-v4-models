# opentmf-908-v4-model

**TMF-908 IoT Agent and Device Management API** — concrete model classes implementing the `I*` API from **opentmf-908-v4-api**.

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>opentmf-908-v4-model</artifactId>
    <version>4.0.0.5</version>
</dependency>
```

Call `Tmf908JacksonConfig.registerExtensions` on your `JsonMapper` builder for `@type` / subtype handling; it chains dependent modules automatically.
