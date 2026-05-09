# opentmf-653-v4-model

**TMF-653 Service Test Management API** — concrete model classes implementing the `I*` API from **opentmf-653-v4-api**.

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>opentmf-653-v4-model</artifactId>
    <version>4.2.0.11</version>
</dependency>
```

Call `Tmf653JacksonConfig.registerExtensions` on your `JsonMapper` builder for `@type` / subtype handling; it chains dependent modules automatically.
