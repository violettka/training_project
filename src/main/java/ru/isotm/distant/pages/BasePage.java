package ru.isotm.distant.pages;

import ru.isotm.distant.utils.PropertiesLoader;

public class BasePage {
    public static String basicURL = PropertiesLoader.loadProperty("url");

}
