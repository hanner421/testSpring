package org.test.demo07.trans.test;

import org.test.demo07.trans.dao.IBookShopDao;
import org.test.demo07.trans.exception.AccountException;
import org.test.demo07.trans.exception.BookStockException;
import org.test.demo07.trans.service.IBookShopService;
import org.test.demo07.trans.service.ICashierService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;


public class TestSpringTrans {

    private ApplicationContext ac;
    private IBookShopDao bookShopDao;
    private IBookShopService bookShopService;
    private ICashierService cashierService;

    {
        ac = new ClassPathXmlApplicationContext("demo07_trans.xml");
        bookShopDao = (IBookShopDao)ac.getBean("bookShopDao");
        bookShopService = (IBookShopService)ac.getBean("bookShopService");
        cashierService = (ICashierService)ac.getBean("cashierService");
    }

    @Test
    public void testSelectPrice() {
        int price = bookShopDao.selectPrice(1);
        System.out.println(price);
    }

    @Test
    public void testUpdateStock() throws BookStockException {
        bookShopDao.updateStock(1);
    }

    @Test
    public void testUpdateBalance() throws AccountException {
        bookShopDao.updateBalance("张三", 40);
    }

    @Test
    public void testPurchase() throws AccountException, BookStockException {
        //未添加事务管理：可能会出现一个情况,当余额不足时购买书,将购买失败，余额没变,但库存依旧减少
        bookShopService.purchase("张三", 1);
    }

    @Test
    public void testCash() throws AccountException, BookStockException {
        //未正确添加事务管理：可能会出现一种情况,当余额不足购买所有书时,会事务回滚,一本书都买不成功
        cashierService.cash("张三", Arrays.asList(1,2));
    }

}