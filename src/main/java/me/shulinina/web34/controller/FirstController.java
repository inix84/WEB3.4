package me.shulinina.web34.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
@RestController
public class FirstController {
    @GetMapping("/")
    public String helloWorld() {
        return "Hello, web!";
    }

    @GetMapping("/info")
    public String info(String nameStudent,
                       String nameProject,
                       LocalDate dateProject,
                       String descriptionProject){
        nameStudent = "Marina";
        nameProject = "Рецепты";
        dateProject = LocalDate.now();
        descriptionProject = "Веб приложение для рецептов";
        return "Приложение запущено " + " / "
                + nameStudent + " / "
                + nameProject + " / "
                + dateProject +" / "
                + descriptionProject;
    }
}