# opentmf-635-v4-model

**TMF-635 Usage Management API** — concrete model classes implementing the `I*` API from **opentmf-635-v4-api**.

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>opentmf-635-v4-model</artifactId>
    <version>4.0.0.11</version>
</dependency>
```

Call `Tmf635JacksonConfig.registerExtensions` on your `JsonMapper` builder for `@type` / subtype handling; it chains dependent modules automatically.
