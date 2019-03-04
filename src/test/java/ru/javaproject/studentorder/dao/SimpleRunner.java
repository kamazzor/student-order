package ru.javaproject.studentorder.dao;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

//Простой, убогий заменитель JUnit для примера
public class SimpleRunner {
    public static void main(String[] args) {
        SimpleRunner sr = new SimpleRunner();
        
        sr.runTests();
    }

    //Запускаем тесты
    private void runTests() {
        try {
            //Получаем описание нужного метода: названия класса,
            // всех его полей, методов и их входных и выходных параметров и т.д.
            Class cl = Class.forName("ru.javaproject.studentorder.dao.DictionaryDaoImplTest");

            //Получаем конструктор класса по умолчанию
            Constructor cst = cl.getConstructor();
            //С помощью полученного описания конструктора создаем сущность (объект) какого-то класса,
            //т.е не задавая тип этой сущности как DictionaryDaoImplTest
            Object entity = cst.newInstance();

            //Получаем описания всех методов из класса DictionaryDaoImplTest
            Method[] methods = cl.getMethods();
            for (Method m : methods) {
                //Проверяем, есть ли у метода m аннотация @Test
                //и если она есть, то запускаем метод
                Test annotation = m.getAnnotation(Test.class);
                if (annotation != null) {
                    //Вызываем метод у класса entity не через точку,
                    //а передавая entity как параметр
                    m.invoke(entity);
                }
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
