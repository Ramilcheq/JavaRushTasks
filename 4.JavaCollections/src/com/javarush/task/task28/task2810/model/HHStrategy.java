package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";
    private static final String ADDITIONAL_VALUE = "Kiev";
    private static final int PAGE_VALUE = 3;

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        ArrayList<Vacancy> vacancies = new ArrayList<>();
        Document doc = null;
        int i = 0;
        String siteName = "http://hh.ua";
        Elements elements;
        do {
            try {
                doc = getDocument(searchString, i);
            } catch (IOException e) {
                break;
            }
            elements = doc.select("[data-qa=vacancy-serp__vacancy]");
            for (Element element : elements) {
                Vacancy vacancy = new Vacancy();
                vacancy.setTitle(element.select("div.title").text());
                vacancy.setSalary(element.select("[data-qa=vacancy-serp__vacancy-compensation]").text());
                vacancy.setCity(element.select("[data-qa=vacancy-serp__vacancy-address]").text());
                vacancy.setCompanyName(element.select("[data-qa=vacancy-serp__vacancy-employer]").text());
                vacancy.setSiteName(siteName);
                vacancy.setUrl(element.select("[data-qa=vacancy-serp__vacancy-title]").attr("href"));
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
