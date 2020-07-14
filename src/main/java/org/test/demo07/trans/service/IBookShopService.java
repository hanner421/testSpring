package org.test.demo07.trans.service;

import org.test.demo07.trans.exception.AccountException;
import org.test.demo07.trans.exception.BookStockException;

public interface IBookShopService {

    //通过账户名及书号购买书
    public void purchase(String username, int bookId) throws BookStockException, AccountException;
}
