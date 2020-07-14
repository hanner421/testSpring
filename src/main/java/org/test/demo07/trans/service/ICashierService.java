package org.test.demo07.trans.service;

import org.test.demo07.trans.exception.AccountException;
import org.test.demo07.trans.exception.BookStockException;

import java.util.List;

public interface ICashierService {

    //客户的结账
    public void cash(String username, List<Integer> bookIds) throws AccountException, BookStockException;
}