package com.geekbrains.lesson2.launcher;

import java.net.URL;
import java.security.ProtectionDomain;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class Launcher {
    // Домашнее задание:
    // 1. Заменить студентов на продукты
    // 2. Добавить возможность:
    // - Добавления нового продукта через форму
    // - Отображение списка всех продуктов
    // - Отображение информации о продукте по его id
    // - * Переход со списка товаров на страницу конкретного продукта
    // - с возможностью его изменения

    public static void main(String[] args) throws Exception {
        Server server = new Server(8189);

        ProtectionDomain domain = Launcher.class.getProtectionDomain();
        URL location = domain.getCodeSource().getLocation();

        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath("/app");
        webAppContext.setWar(location.toExternalForm());

        server.setHandler(webAppContext);
        server.start();
        server.join();
    }
}
