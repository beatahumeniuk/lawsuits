package pl.beatahumeniuk.core.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Configuration
public class GlobalSerializerConfiguration {
    private static final DateTimeFormatter DATE_TIME_FORMATTER_DESERIALIZER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S][XXX][X]");
    private static final DateTimeFormatter DATE_TIME_FORMATTER_SERIALIZER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX").withZone(ZoneOffset.UTC);

    @Bean
    public ObjectMapper serializingObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.registerModules(/* JDK 8 */ new ParameterNamesModule(), new Jdk8Module(), new JavaTimeModule(), /* END JDK 8 */
                stringModule(), offsetDateTimeModule());
        configureNullAsEmptyDeserialization(objectMapper, List.class, Set.class);

        objectMapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        objectMapper.enable(MapperFeature.USE_BASE_TYPE_AS_DEFAULT_IMPL);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);


        return objectMapper;
    }

    private SimpleModule stringModule() {
        SimpleModule module = new SimpleModule("stringModule");
        module.addDeserializer(String.class, new EmptyStringDeserializer(String.class));
        return module;
    }

    private SimpleModule offsetDateTimeModule() {
        SimpleModule module = new SimpleModule("offsetDateTimeModule");
        module.addDeserializer(OffsetDateTime.class, new OffsetDateTimeDeserializer());
        module.addSerializer(OffsetDateTime.class, new OffsetDateTimeSerializer());
        return module;
    }

    private void configureNullAsEmptyDeserialization(ObjectMapper objectMapper, Class... classes) {
        Arrays.stream(classes).forEach(clazz ->
                objectMapper.configOverride(clazz)
                        .setSetterInfo(JsonSetter.Value.forValueNulls(Nulls.AS_EMPTY, Nulls.AS_EMPTY))
        );
    }

    public static class EmptyStringDeserializer extends StdDeserializer<String> {
        EmptyStringDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            String result = StringDeserializer.instance.deserialize(p, ctxt);
            if (StringUtils.isEmpty(result)) {
                return null;
            }
            return result;
        }
    }

    public static class OffsetDateTimeSerializer extends JsonSerializer<OffsetDateTime> {
        @Override
        public void serialize(OffsetDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(DATE_TIME_FORMATTER_SERIALIZER.format(value));
        }
    }

    public static class OffsetDateTimeDeserializer extends JsonDeserializer<OffsetDateTime> {
        @Override
        public OffsetDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            return OffsetDateTime.parse(p.getValueAsString(), DATE_TIME_FORMATTER_DESERIALIZER);
        }
    }
}
