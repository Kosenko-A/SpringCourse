package ru.geekbrains.demo;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Cart {

    private static List <Product> productsInCart = new ArrayList<>();

    public static void put(Product product) {
        productsInCart.add(product);
        System.out.println("Товар добавлен");
    }

    public static void delete(Product product) {
        if (!productsInCart.isEmpty()) {
            productsInCart.remove(product);
            System.out.println("Товар удален");
        } else {
            System.out.println("Корзина и так пуста");
        }
    }

    @Override
    public String toString() {
        return "Cart{" +
                productsInCart +
                '}';
    }
}
