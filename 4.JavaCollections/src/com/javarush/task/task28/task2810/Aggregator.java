package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.*;
import com.javarush.task.task28.task2810.view.HtmlView;
import com.javarush.task.task28.task2810.view.View;

public class Aggregator {
    public static void main(String[] args) {
        HHStrategy HH = new HHStrategy();
        MoikrugStrategy MK = new MoikrugStrategy();
        Provider pHH = new Provider(HH);
        Provider pMK = new Provider(MK);

        HtmlView view = new HtmlView();
        Model model = new Model(view, pMK, pHH);
        Controller controller = new Controller(model);
        view.setController(controller);
        view.userCitySelectEmulationMethod();
    }
}
