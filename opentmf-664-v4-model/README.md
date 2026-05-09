# opentmf-664-v4-model

**TMF-664 Resource Function Activation Management API** — concrete model classes implementing the `I*` API from **opentmf-664-v4-api**.

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>opentmf-664-v4-model</artifactId>
    <version>4.0.0.11</version>
</dependency>
```

Call `Tmf664JacksonConfig.registerExtensions` on your `JsonMapper` builder for `@type` / subtype handling; it chains dependent modules automatically.
