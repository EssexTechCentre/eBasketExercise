package com.ftsl.basket;

import com.ftsl.calculation.ICalculationEngine;
import com.ftsl.product.IItem;

/**
 * Created by Karl on 05/07/2016.
 */
public interface IBasket extends ICalculationEngine {

    void add(IItem item, Integer quantity);
    void add(IItem item);
    Integer totalCount();
    boolean isEmpty();
}
