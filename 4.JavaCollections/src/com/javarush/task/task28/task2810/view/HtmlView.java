package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class HtmlView implements View {
    private final String filePath = "./4.JavaCollections/src/" + this.getClass().getPackage().getName().replace(".", "/") + "/vacancies.html";
    private Controller controller;


    @Override
    public void update(List<Vacancy> vacancies) {
        updateFile(getUpdatedFileContent(vacancies));
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies) {
        try {
            Document doc = getDocument();
            Element element = doc.getElementsByClass("template").first();
            Element elemTemplate = element.clone();
            elemTemplate.removeAttr("style");
            elemTemplate.removeClass("template");

            for (Element e : doc.select("tr.vacancy")) {
                if (e.className().equals("vacancy")) e.remove();
            }

            for(Vacancy vacancy:vacancies){
                Element elemVacancy = elemTemplate.clone();
                elemVacancy.getElementsByClass("city").first().text(vacancy.getCity());
                elemVacancy.getElementsByClass("companyName").first().text(vacancy.getCompanyName());
                elemVacancy.getElementsByClass("salary").first().text(vacancy.getSalary());
                elemVacancy.select("a").first().text(vacancy.getTitle());
                elemVacancy.select("a").first().attr("href", vacancy.getUrl());
                doc.select("[class=vacancy template]").before(elemVacancy.outerHtml());
                int i = 0;
            }
            return doc.html();
        } catch (Exception e) {
            e.printStackTrace();
            return "Some exception occurred";
        }
    }

    private void updateFile(String str) {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("Odessa");
    }

    protected Document getDocument() throws IOException {
        return Jsoup.parse(new File(filePath), "UTF-8");
    }
}
