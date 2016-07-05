package com.ftsl.basket;

import com.ftsl.product.FruitItem;
import org.junit.Before;
import org.junit.Test;
import java.math.BigDecimal;
import static org.junit.Assert.*;

/**
 * Created by Karl on 05/07/2016.
 */
public class BasketTest {

    IBasket basket = new Basket();
    BigDecimal totalCost;

    @Before
    public void setUp() {
        basket.add(FruitItem.APPLE, 1);
        basket.add(FruitItem.BANANA, 1);
        basket.add(FruitItem.PEACH, 1);
        basket.add(FruitItem.ORANGE, 1);
        basket.add(FruitItem.LEMON, 1);
    }

    @Test
    public void testIsEmpty(){

        IBasket basket = new Basket();
        assertTrue(basket.isEmpty() == true);
    }

    @Test
    public void testAddQuantity(){

        IBasket basket = new Basket();
        basket.add(FruitItem.APPLE, 1);
        assertTrue(basket.isEmpty() == false);
    }

    @Test
    public void testAddSingle(){

        IBasket basket = new Basket();
        basket.add(FruitItem.APPLE);
        assertTrue(basket.isEmpty() == false);
    }

    @Test
    public void testCalculateTotalCost(){

        totalCost = basket.calculateTotalCost();
        assertTrue(totalCost.doubleValue() > 0);//assumes fruits are not free
    }

    @Test
    public void testParseList() {

        Basket basket = Basket.parse("Apple,Apple,Orange");
        assertEquals((long)basket.totalCount(), 3);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testParseListIllegalArgumentUnknownFruit() {

        Basket.parse("Pear");
    }

    @Test(expected=IllegalArgumentException.class)
    public void testParseListIllegalArgumentBadFormatting() {

        Basket.parse("apple.apple");
    }

    @Test(expected=IllegalArgumentException.class)
    public void testParseListIllegalArgumentEmptyString() {

        Basket.parse("");
    }

}

