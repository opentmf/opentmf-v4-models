# opentmf-674-v4-model

**TMF-674 Geographic Site Management API** — concrete model classes implementing the `I*` API from **opentmf-674-v4-api**.

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>opentmf-674-v4-model</artifactId>
    <version>4.0.0.11</version>
</dependency>
```

Call `Tmf674JacksonConfig.registerExtensions` on your `JsonMapper` builder for `@type` / subtype handling; it chains dependent modules automatically.
