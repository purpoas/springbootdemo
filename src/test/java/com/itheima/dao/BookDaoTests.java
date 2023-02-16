package com.itheima.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class BookDaoTests {
    @Autowired
    private BookDao bookDao;

    @Test
    void testSelect() {
        Book book01 = bookDao.selectById(1);
        System.out.println(book01);
    }

    @Test
    void testInsert() {
        Book book = new Book();
        book.setType("Horror");
        book.setName("Love Trilogy");
        book.setDescription("When lust meets sincerity");
        bookDao.insert(book);
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(4);
        book.setName("The lost Autumn leaf");
        bookDao.updateById(book);
    }

    @Test
    void testDelete() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(2);
        integers.add(4);
        bookDao.deleteBatchIds(integers);
    }

    @Test
    void testSelectAll() {
        for (Book book : bookDao.selectList(null)) {
            System.out.println(book);
        }
    }

    @Test
    void testGetPage() {
        IPage<Book> page = new Page<>(2, 1);
        bookDao.selectPage(page, null);
        for (Book book : page.getRecords()) {
            System.out.println(book);
        }
    }

    @Test
    void testByConditions() {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "angel");
        System.out.println(bookDao.selectList(queryWrapper));
    }

    @Test
    void testByLambdaConditions() {
        String name = null;
        LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(Strings.isNotEmpty(name), Book::getName, "angel");
        System.out.println(bookDao.selectList(queryWrapper));
    }

    @Test
    void testCase() {
        Book book = new Book();
        book.setName("ai");
        int insert = bookDao.insert(book);
        System.out.println(insert);
    }
}
