package com.ftsl.product;

import java.math.BigDecimal;

/**
 * Created by Karl on 05/07/2016.
 */
public enum FruitItem implements IItem {

    APPLE("APPLE", new BigDecimal("0.35")),
    BANANA("BANANA", new BigDecimal("0.20")),
    LEMON("LEMON", new BigDecimal("0.25")),
    PEACH("PEACH", new BigDecimal("0.15")),
    ORANGE("ORANGE", new BigDecimal("0.40"));

    private final String name;
    private final BigDecimal cost;

    FruitItem(String name, BigDecimal cost) {
        this.name = name;
        this.cost = cost;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getCost() {
        return cost;
    }

    public static FruitItem fromString(String text) {
        if (text != null) {
            for (FruitItem item : FruitItem.values()) {
                if (text.equalsIgnoreCase(item.name)) {
                    return item;
                }
            }
        }
        return null;
    }
}

