package ru.pepsxx.spring.boot.help.pep_pro_spring_boot_help;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.Resource;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.context.event.EventListener;
import org.springframework.context.event.EventListenerMethodProcessor;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import ru.pepsxx.spring.boot.help.pep_pro_spring_boot_help.v001.TestBean1;
import ru.pepsxx.spring.boot.help.pep_pro_spring_boot_help.v002.TestBean2;
import ru.pepsxx.spring.boot.help.pep_pro_spring_boot_help.v003.TestBean3Prototype;
import ru.pepsxx.spring.boot.help.pep_pro_spring_boot_help.v003.TestBean3Singleton;
import ru.pepsxx.spring.boot.help.pep_pro_spring_boot_help.v004.TestBean4Prototype;
import ru.pepsxx.spring.boot.help.pep_pro_spring_boot_help.v004.TestBean4Singleton;
import ru.pepsxx.spring.boot.help.pep_pro_spring_boot_help.v005.Music5;
import ru.pepsxx.spring.boot.help.pep_pro_spring_boot_help.v005.Music5Con;
import ru.pepsxx.spring.boot.help.pep_pro_spring_boot_help.v005.Music5Fab;
import ru.pepsxx.spring.boot.help.pep_pro_spring_boot_help.v005.Music5Set;
import ru.pepsxx.spring.boot.help.pep_pro_spring_boot_help.v006.Player6Const;
import ru.pepsxx.spring.boot.help.pep_pro_spring_boot_help.v006.Player6Field;
import ru.pepsxx.spring.boot.help.pep_pro_spring_boot_help.v006.Player6Seter;
import ru.pepsxx.spring.boot.help.pep_pro_spring_boot_help.v008.entity.Person8;
import ru.pepsxx.spring.boot.help.pep_pro_spring_boot_help.v008.repository.TestRepository8;

import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class PepProSpringBootHelpApplication {

    public static void main(String[] args) throws SQLException {

        System.out.println("""
                --------------------------------------------------
                
                v001_start
                """);
        // Получение контекста
        ConfigurableApplicationContext context =
                SpringApplication.run(PepProSpringBootHelpApplication.class, args);

        TestBean1 testBean1 = context.getBean("testBean1", TestBean1.class);
        System.out.println("testBean1 = " + testBean1);

        System.out.println("""
                --------------------------------------------------
                
                v002_property
                1:  В Spring Boot не требуется прописывать имена файлов 
                    - @PropertySource("classpath:application.yml") в @Configuration
                    но файлы в "resources" должны иметь имена:
                    "application.properties" и "application.yml"
                2:  Для внедрения в поле поставить аннотацию @Value с именем настройки
                    @Value("${name}")
                """);
        TestBean2 testBean2 = context.getBean("testBean2", TestBean2.class);
        System.out.println("testBean2.getNamePro() = " + testBean2.getNamePro());
        System.out.println("testBean2.getNameYml() = " + testBean2.getNameYml());

        System.out.println("""
                --------------------------------------------------
                
                v003_scope
                Scope задается аннотацией @Scope
                @Scope(BeanDefinition.SCOPE_SINGLETON) - Возвращается всё врем я один и тот же бин
                @Scope(BeanDefinition.SCOPE_PROTOTYPE) - Возвращается каждый раз новый бин
                """);

        TestBean3Singleton testBean3Singleton1 = context.getBean("testBean3Singleton", TestBean3Singleton.class);
        TestBean3Singleton testBean3Singleton2 = context.getBean("testBean3Singleton", TestBean3Singleton.class);
        TestBean3Prototype testBean3Prototype1 = context.getBean("testBean3Prototype", TestBean3Prototype.class);
        TestBean3Prototype testBean3Prototype2 = context.getBean("testBean3Prototype", TestBean3Prototype.class);

        System.out.println("testBean3Singleton1 = " + testBean3Singleton1);
        System.out.println("testBean3Singleton2 = " + testBean3Singleton2);
        System.out.println("testBean3Prototype1 = " + testBean3Prototype1);
        System.out.println("testBean3Prototype2 = " + testBean3Prototype2);

        System.out.println("""
                --------------------------------------------------
                
                v004_pre_post""");

        TestBean4Singleton testBean4Singleton1 = context.getBean("testBean4Singleton", TestBean4Singleton.class);
        TestBean4Singleton testBean4Singleton2 = context.getBean("testBean4Singleton", TestBean4Singleton.class);
        TestBean4Prototype testBean4Prototype1 = context.getBean("testBean4Prototype", TestBean4Prototype.class);
        TestBean4Prototype testBean4Prototype2 = context.getBean("testBean4Prototype", TestBean4Prototype.class);

        System.out.println("testBean4Singleton1 = " + testBean4Singleton1);
        System.out.println("testBean4Singleton2 = " + testBean4Singleton2);
        System.out.println("testBean4Prototype1 = " + testBean4Prototype1);
        System.out.println("testBean4Prototype2 = " + testBean4Prototype2);

        System.out.println("""
                --------------------------------------------------
                
                v005_bean_creat
                Автоматическое создание бина:
                @Component
                Есть 3 способа ручного создания бина:
                1:  С помощью конструктора (свойства объекта задаются в конструкторе).
                2:  С помощью сеттеров (свойства объекта задаются через сеттеры).
                3:  С помощью фабричного метода (объект с свойствами создаётся через фабричный метод).
                """);

        Music5 music5 = context.getBean("music5", Music5.class);
        Music5Con music5Con = context.getBean("music5Con", Music5Con.class);
        Music5Set music5Set = context.getBean("music5Set", Music5Set.class);
        Music5Fab mu5FabCon = context.getBean("mu5FabCon", Music5Fab.class);
        Music5Fab mu5FabSet = context.getBean("mu5FabSet", Music5Fab.class);

        System.out.println("music5    = " + music5.getName());
        System.out.println("music5Con = " + music5Con.getName());
        System.out.println("music5Set = " + music5Set.getName());
        System.out.println("mu5FabCon = " + mu5FabCon.getName());
        System.out.println("mu5FabSet = " + mu5FabSet.getName());

        System.out.println("""
                --------------------------------------------------
                
                v006_autowired_qualifier
                Для автоматического внедрение зависимости(другого бина) на место которого подходит несколько экземпляров
                Требуется указать конкретный @Qualifier
                
                @Autowired может стоять над:
                1:  Полем
                2:  Сеттером
                3:  Конструктором
                """);

        Player6Field player6Field = context.getBean("player6Field", Player6Field.class);
        Player6Seter player6Seter = context.getBean("player6Seter", Player6Seter.class);
        Player6Const player6Const = context.getBean("player6Const", Player6Const.class);

        player6Field.playMusic();
        player6Seter.playMusic();
        player6Const.playMusic();

        System.out.println("""
                --------------------------------------------------
                
                v007_environment
                Environment для получение настроек из файлов конфигурации
                """);

        Environment environment = context.getEnvironment();

        String s1 = environment.getProperty("yml.name");
        String s2 = environment.getProperty("name");

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);

        System.out.println("""
                --------------------------------------------------
                
                v008_data_jpa
                Зависимости:
                1.  spring-boot-starter-data-jpa
                2.  postgresql
                Настройки:
                spring:
                    datasource:
                        username: admin                               # Имя администратора db
                        password: qQ111111                            # Пароль администратора db
                        driver-class-name: org.postgresql.Driver      # Драйвер db
                        url: jdbc:postgresql://localhost:40554/pep_db # url db
                Необязательные настройки:
                spring:
                    jpa:
                        show-sql: true
                        properties.hibernate.format_sql: true
                """);

        TestRepository8 testRepository = context.getBean(TestRepository8.class);

        Person8 person1 = testRepository.findById(1L);
        System.out.println("person1 = " + person1);
        System.out.println("--------------------------------------------------");

        List<Person8> personList2 = testRepository.findByName("Billi");
        personList2.forEach(System.out::println);
        System.out.println("--------------------------------------------------");

        List<Person8> personList3 = testRepository.findAllBy();
        personList3.forEach(System.out::println);

        System.out.println("""
                --------------------------------------------------
                
                v009_order_of_resolution_of_requests
                Spring Data
                порядок разрешения запросов
                
                1
                Аннотация @Query в репозитории
                @Query("FROM Person p WHERE p.id = 10")
                List<Person> findAllBy();
                
                2
                Аннотация @NamedQuery в классе-сущности
                Над entity:
                @NamedQuery(
                name = "Person.findAllBy",
                query = "FROM Person p WHERE p.id = 20")
                +
                В репозитории:
                List<Person> findAllBy();
                
                3
                Волшебные методы
                List<Person> findAllBy();""");

        System.out.println("""
                --------------------------------------------------
                
                v010_compose
                Зависимости:
                1.  spring-boot-docker-compose
                
                Настройки в compose.yml:
                name: pep_pro_spring_boot_help-40554        # Имя compose stack
                services:
                    my_name:                                # Имя ?
                        container_name: PostgresSQL-40554   # Имя container в stack
                        image: postgres                     # Название образа на котором основан контейнер
                        ports:
                            - "40554:5432"                  # forwarding port
                        environment:
                            POSTGRES_USER: admin            # Имя администратора db
                            POSTGRES_PASSWORD: qQ111111     # Пароль администратора db
                            POSTGRES_DB: pep_db             # Имя db""");

        System.out.println("""
                --------------------------------------------------
                
                v011_liquibase
                Зависимости:
                1.  liquibase-core
                
                Настройки в resources/db/changelog:
                1.  db.changelog-master.yaml
                2.  db.changelog-1.0.sql
                3.  ...
                
                1:
                databaseChangeLog:
                    - include:
                        file: db/changelog/db.changelog-1.0.sql
                
                2:
                --liquibase formatted sql
                --changeset pep_sxx:1
                CREATE TABLE Person
                (
                    id   BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                    name VARCHAR NOT NULL
                );""");

        System.out.println("""
                --------------------------------------------------
                
                close
                """);

        context.close();


    }

}
