# opentmf-641-v4-model

**TMF-641 Service Ordering Management API** — concrete model classes implementing the `I*` API from **opentmf-641-v4-api**.

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>opentmf-641-v4-model</artifactId>
    <version>4.1.0.11</version>
</dependency>
```

Call `Tmf641JacksonConfig.registerExtensions` on your `JsonMapper` builder for `@type` / subtype handling; it chains dependent modules automatically.
