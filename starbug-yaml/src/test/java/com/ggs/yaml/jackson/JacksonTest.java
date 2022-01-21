package com.ggs.yaml.jackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.ggs.yaml.entity.Person;
import com.ggs.yaml.entity.SinglePerson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author lianghaohui
 * @Date 2022/1/21 11:27
 * @Description
 */
public class JacksonTest {

    @Test
    public void read() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        InputStream is = new ClassPathResource("snake1.yml").getInputStream();
        Person person = objectMapper.readValue(is, Person.class);
        System.out.println(person);
    }

    @Test
    public void write() throws IOException {
        Map<String, Object> map = new HashMap<>();
        SinglePerson person1 = new SinglePerson("Trunks", "male");
        SinglePerson person2 = new SinglePerson("Goten", "male");
        Person person = new Person(person1, person2);
        map.put("person", person);
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        File file = new File("jackson-gen.yml");
        if (!file.exists()) {
            file.createNewFile();
        }
        objectMapper.writeValue(file, map);
    }

    @Test
    public void lsjdf() {
        System.out.println(this.getClass().getClassLoader().getResource("./").getPath());
        System.out.println(new File("").getAbsolutePath());
    }

    /**
     * json转yaml
     */
    @Test
    public void test2() throws IOException {
        File jsonFile = new File(this.getClass().getResource("/test_jsonToYaml.json").getFile());

        ObjectMapper jsonMapper = new ObjectMapper();
        YAMLMapper yamlMapper = new YAMLMapper();

        // Read file as JsonNode
        JsonNode jsonNode = jsonMapper.readTree(jsonFile);
        // Convert it into YAML String
        String yamlOutput = yamlMapper.writeValueAsString(jsonNode);
        System.out.println(yamlOutput);
    }

    /**
     * yaml转json
     * {
     *     "cat": "info",
     *     "dog": "info",
     *     "info": {
     *         "legs": "4 legs",
     *         "type": "pet"
     *     }
     * }
     */
    @Test
    public void test3() throws IOException {
        InputStream is = new ClassPathResource("test_YamlToJson.yml").getInputStream();
        YAMLMapper yamlMapper = new YAMLMapper();
        JsonNode jsonNode = yamlMapper.readTree(is);
        System.out.println(jsonNode);
    }

    /**
     * yaml转json  使用snakeyaml，功能更加完善
     * {
     *   "info": {
     *     "legs": "4 legs",
     *     "type": "pet"
     *   },
     *   "dog": {
     *     "legs": "4 legs",
     *     "type": "pet"
     *   },
     *   "cat": {
     *     "legs": "4 legs",
     *     "type": "pet"
     *   }
     * }
     */
    @Test
    public void test4() throws IOException {
        InputStream is = new ClassPathResource("test_YamlToJson.yml").getInputStream();
        Yaml yaml = new Yaml();
        Object loadedYaml = yaml.load(is);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(loadedYaml, LinkedHashMap.class);
        System.out.println(json);
    }

}
