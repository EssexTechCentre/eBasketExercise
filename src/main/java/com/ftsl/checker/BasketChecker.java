package com.ftsl.checker;

import com.ftsl.basket.Basket;
import com.ftsl.basket.IBasket;
import com.ftsl.product.FruitItem;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Karl on 05/07/2016.
 */
public class BasketChecker {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        IBasket basket;

        System.out.println("Welcome to eBasket!");
        System.out.println("Please enter your comma separated list of items (i.e. Apple,Orange,Apple):");

        while (true) {
            try {
                basket = Basket.parse(in.nextLine());
                if (!basket.isEmpty())
                    break;
            } catch (IllegalArgumentException iae) {
                System.err.println("Unknown item found in basket '" + iae.getMessage() + "'");
                System.out.println("eBasket only sells - " + Arrays.asList(FruitItem.values()));
                System.out.println("Please re-enter your comma separated list of items:");
            }
        }

        System.out.println("Your total cost is: £" + basket.calculateTotalCost());
        System.out.println("Thank you for shopping at eBasket!");
    }
}
