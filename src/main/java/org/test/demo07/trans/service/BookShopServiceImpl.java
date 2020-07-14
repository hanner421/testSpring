package org.test.demo07.trans.service;


import org.test.demo07.trans.dao.IBookShopDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.test.demo07.trans.exception.AccountException;
import org.test.demo07.trans.exception.BookStockException;

import javax.annotation.Resource;
import java.io.IOException;
import java.sql.SQLException;

@Service("bookShopService")
public class BookShopServiceImpl implements IBookShopService {
    @Resource
    private IBookShopDao bookShopDao;


    //通过账户名及书号购买书
    //支持注解式事务管理
    /*@Transactional(propagation= Propagation.REQUIRES_NEW,
            isolation= Isolation.READ_COMMITTED,
            rollbackFor={IOException.class, SQLException.class},
            noRollbackFor={ArithmeticException.class},
            readOnly=false,
            timeout=3)*/
    @Transactional(propagation = Propagation.REQUIRES_NEW,
    isolation = Isolation.READ_COMMITTED,
    rollbackFor={IOException.class, SQLException.class},
    noRollbackFor={ArithmeticException.class},
    timeout = 3,
    readOnly = false)
    @Override
    public void purchase(String username, int bookId) throws BookStockException, AccountException {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int price = bookShopDao.selectPrice(bookId);
        //一旦添加了事务管理，当前两项操作要么都做，要么都不做
        //买书后，更新库存
        bookShopDao.updateStock(bookId);
        //根据提供会员信息，修改余额
        bookShopDao.updateBalance(username, price);
    }

}
