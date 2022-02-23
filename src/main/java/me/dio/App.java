package me.dio;

import me.dio.domain.Bootcamp;
import me.dio.domain.Course;
import me.dio.domain.Developer;
import me.dio.domain.Mentorship;

import java.time.LocalDateTime;

public class App {

    public static void main(String[] args) {

        var course01 = Course
                .create()
                .title("Curso de Java")
                .description("Aprenda Java com Boas práticas de programação!")
                .workload(8);

        var course02 = Course
                .create()
                .title("Inteligência Artificial com Python")
                .description("""
                        Aprenda na prática sobre os algoritmos de Machine Learning para classificação, regressão, regras de associação e agrupamento!
                        """)
                .workload(60);

        var mentorship = Mentorship.create()
                .title("Mentoria Java")
                .description("Duas horas de mentoria com desconto exclusivo e conteúdo avançado!")
                .dateTime(LocalDateTime.of(2022, 4, 18, 18, 0));

        var bootcamp = Bootcamp
                .create()
                .name("Bootcamp Java Developer")
                .description("Aprenda por meio de boas práticas de codificação!");

        bootcamp.add(course01);
        bootcamp.add(course02);
        bootcamp.add(mentorship);

        var devCamila = Developer
                .create()
                .name("Camila")
                .subscribeIn(bootcamp);

        System.out.printf("Conteúdos Inscritos %s: %s\n", devCamila.name(), devCamila.subscribedContent());
        devCamila.progress(course01);
        devCamila.progress(course02);

        System.out.println("-");
        System.out.printf("Conteúdos Inscritos %s: %s\n", devCamila.name(), devCamila.subscribedContent());
        System.out.printf("Conteúdos Concluidos %s: %s\n", devCamila.name(), devCamila.completedContent());
        System.out.println("XP:" + devCamila.totalXP());

        System.out.println("-------");

        var devThiago = Developer
                .create()
                .name("Thiago Bandeira")
                .subscribeIn(bootcamp);

        System.out.printf("Conteúdos Inscritos %s: %s\n", devThiago.name(), devThiago.subscribedContent());
        devThiago.progress(course01);
        devThiago.progress(course02);
        devThiago.progress(mentorship);

        System.out.println("-");
        System.out.printf("Conteúdos Inscritos %s: %s\n", devThiago.name(), devThiago.subscribedContent());
        System.out.printf("Conteúdos Concluidos %s: %s\n", devThiago.name(), devThiago.completedContent());
        System.out.println("XP:" + devThiago.totalXP());

    }

}
