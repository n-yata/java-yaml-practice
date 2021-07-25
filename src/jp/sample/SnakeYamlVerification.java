package jp.sample;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.yaml.snakeyaml.Yaml;

import jp.sample.entities.Person;

public class SnakeYamlVerification {
    public void dump() {
        final Person p = new Person();
        p.setFirstName("John");
        p.setFamiryName("Key");
        p.setNationality("UK");
        p.setAge(28);
        final Yaml y = new Yaml();
        System.out.println(y.dump(p));
    }

    public void dumpList() {
        final List<Person> people = Arrays.asList(
                new Person("Jhon", "Kay", "UK", 28),
                new Person("Don", "Hall", "US", 28),
                new Person("Ken", "Rodriguez", "AR", 28));

        final Yaml y = new Yaml();
        System.out.println(y.dump(people));
    }

    public void load() {
        final Yaml y = new Yaml();
        final Person loaded = (Person) y
                .load("!!jp.sample.entities.Person {age: 28, famiryName: Key, firstName: John, natonality: UK}");
        System.out.println(loaded.toString());
    }

    public void loadList() {
        final Yaml y = new Yaml();
        final List<Person> loaded = y.loadAs(
                "- !!jp.sample.entities.Person {age: 28, famiryName: Kay, firstName: Jhon, nationality: UK}\r\n"
                        + "- !!jp.sample.entities.Person {age: 28, famiryName: Hall, firstName: Don, nationality: US}\r\n"
                        + "- !!jp.sample.entities.Person {age: 28, famiryName: Rodriguez, firstName: Ken, nationality: AR}",
                List.class);

        loaded.forEach(p -> System.out.println(p.toString()));
    }

    public void read() {
        final Yaml y = new Yaml();
        try (final InputStream in = Files.newInputStream(
                Paths.get("mypc-path\\people.yaml"))) {
            final List<Person> loaded = y.loadAs(in, List.class);
            loaded.forEach(p -> System.out.println(p.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
