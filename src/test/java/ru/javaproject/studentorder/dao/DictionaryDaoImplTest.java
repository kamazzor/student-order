package ru.javaproject.studentorder.dao;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.javaproject.studentorder.domain.CountryArea;
import ru.javaproject.studentorder.domain.PassportOffice;
import ru.javaproject.studentorder.domain.RegisterOffice;
import ru.javaproject.studentorder.domain.Street;
import ru.javaproject.studentorder.exception.DaoException;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;

public class DictionaryDaoImplTest {

    //Метод, запускающийся 1 раз перед запуском всех тестов из этого класса
    //Метод, инициализирующий и заполняющий БД
    @BeforeClass
    public static void startUp() throws Exception {
        DBInit.StartUp();
    }

    //Unit-тесты для таблиц-справочников
    @Test
    public void testStreet() throws DaoException {
        List<Street> d = new DictionaryDaoImpl().findStreets("про");
        //Проверяем результаты теста
        Assert.assertTrue(d.size() == 2);
    }

    @Test
    public void testPassportOffice() throws DaoException {
        List<PassportOffice> po = new DictionaryDaoImpl().findPassportOffices("010020000000");
        //Проверяем результаты теста
        Assert.assertTrue(po.size() == 2);
    }

    @Test
    public void testRegisterOffice() throws DaoException {
        List<RegisterOffice> ro = new DictionaryDaoImpl().findRegisterOffices("010010000000");
        //Проверяем результаты теста
        Assert.assertTrue(ro.size() == 2);
    }

    @Test
    public void testArea() throws DaoException {
        List<CountryArea> ca1 = new DictionaryDaoImpl().findAreas("");
        Assert.assertTrue(ca1.size() == 2);
        List<CountryArea> ca2 = new DictionaryDaoImpl().findAreas("020000000000");
        Assert.assertTrue(ca2.size() == 2);
        List<CountryArea> ca3 = new DictionaryDaoImpl().findAreas("020010000000");
        Assert.assertTrue(ca3.size() == 2);
        List<CountryArea> ca4 = new DictionaryDaoImpl().findAreas("020010010000");
        Assert.assertTrue(ca4.size() == 2);
    }
}