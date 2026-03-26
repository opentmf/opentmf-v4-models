# opentmf-622-v4-model

**TMF-622 Product Ordering Management API** — concrete model classes implementing the `I*` API from **opentmf-622-v4-api**.

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>opentmf-622-v4-model</artifactId>
    <version>4.0.0.10</version>
</dependency>
```

Call `Tmf622JacksonConfig.registerExtensions` on your `JsonMapper` builder for `@type` / subtype handling; it chains dependent modules automatically.
