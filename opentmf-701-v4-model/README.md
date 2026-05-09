# opentmf-701-v4-model

**TMF-701 Process Flow Management API** — concrete model classes implementing the `I*` API from **opentmf-701-v4-api**.

```xml
<dependency>
    <groupId>org.opentmf.model</groupId>
    <artifactId>opentmf-701-v4-model</artifactId>
    <version>4.1.0.11</version>
</dependency>
```

Call `Tmf701JacksonConfig.registerExtensions` on your `JsonMapper` builder for `@type` / subtype handling; it chains dependent modules automatically.
