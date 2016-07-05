package com.ftsl.basket;

import com.ftsl.product.FruitItem;
import com.ftsl.product.IItem;
import java.math.BigDecimal;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Karl on 05/07/2016.
 */
public class Basket implements IBasket {

    BigDecimal totalCost;
    private Map<IItem, Integer> basket;

    public Basket(){

        totalCost = new BigDecimal(0);
        basket = new HashMap<>();
    }

    @Override
    public boolean isEmpty() {
        return basket.isEmpty();
    }

    @Override
    public Integer totalCount() {

        int total = 0;
        for (Integer i : basket.values()) {
            total += i;
        }
        return total;
    }

    @Override
    public void add(IItem item){

        if(basket.containsKey(item))
            basket.put(item, basket.get(item) + 1);
        else
            basket.put(item, 1);
    }

    @Override
    public void add(IItem item, Integer quantity){

        basket.put(item, quantity);
    }

    @Override
    public BigDecimal calculateTotalCost() {

        Iterator it = basket.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            IItem item = (IItem) pair.getKey();
            totalCost = totalCost.add(item.getCost().multiply(new BigDecimal((Integer) pair.getValue())));
        }
        return totalCost;
    }

    public static Basket parse(String list) throws IllegalArgumentException {

        list.replaceAll("\\s+","");
        List<String> items = Arrays.asList(list.split("\\s*,\\s*"));
        Basket basket = new Basket();

        for(String item : items) {

            FruitItem item1 = FruitItem.fromString(item);
            if (item1 == null)
                throw new IllegalArgumentException(item);
            basket.add(item1);
        }

        return basket;
    }
}
