# opentmf-715-v4-model

**TMF-715 Warranty Management** — concrete model classes implementing the `I*` API from **opentmf-715-v4-api**.

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>opentmf-715-v4-model</artifactId>
    <version>4.0.0.11</version>
</dependency>
```

Call `Tmf715JacksonConfig.registerExtensions` on your `JsonMapper` builder for `@type` / subtype handling; it chains dependent modules automatically.
