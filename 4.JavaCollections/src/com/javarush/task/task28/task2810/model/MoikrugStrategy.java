package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoikrugStrategy implements Strategy {
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        ArrayList<Vacancy> vacancies = new ArrayList<>();
        Document doc = null;
        int i = 0;
        String siteName = "https://moikrug.ru";
        Elements elements;
        Elements elements2;
        do {
            try {
                doc = getDocument(searchString, i);
            } catch (IOException e) {
                break;
            }
            elements = doc.select("[class=job]");
            for (Element element : elements) {
                Vacancy vacancy = new Vacancy();
                vacancy.setTitle(element.select("div.title").text());
                vacancy.setSalary(element.select("div.count").text());
                vacancy.setCity(element.select("span.location").text());
                vacancy.setCompanyName(element.getElementsByAttributeValue("class", "company_name").text());
                vacancy.setSiteName(siteName);
                vacancy.setUrl(siteName + element.select("div.title").select("a").attr("href"));
                vacancies.add(vacancy);
            }
            elements2 = doc.select("[class=job marked]");
            for (Element element : elements2) {
                Vacancy vacancy = new Vacancy();
                vacancy.setTitle(element.select("div.title").text());
                vacancy.setSalary(element.select("div.count").text());
                vacancy.setCity(element.select("span.location").text());
                vacancy.setCompanyName(element.getElementsByAttributeValue("class", "company_name").text());
                vacancy.setSiteName(siteName);
                vacancy.setUrl(siteName + element.select("div.title").select("a").attr("href"));
                vacancies.add(vacancy);
            }
            i++;
        } while (!elements.isEmpty());
        return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        String link = String.format(URL_FORMAT, searchString, page);
        return Jsoup.connect(link)
                .userAgent("Chrome/65.0.3325.181")
                .referrer("no-referrer-when-downgrade")
                .get();
    }

}
