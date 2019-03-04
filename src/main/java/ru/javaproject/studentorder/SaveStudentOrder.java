package ru.javaproject.studentorder;

import ru.javaproject.studentorder.dao.DictionaryDaoImpl;
import ru.javaproject.studentorder.dao.StudentOrderDao;
import ru.javaproject.studentorder.dao.StudentOrderDaoImpl;
import ru.javaproject.studentorder.domain.*;
import ru.javaproject.studentorder.exception.DaoException;

import java.time.LocalDate;
import java.util.List;

//Начальный класс программы
public class SaveStudentOrder {

    //Временная (старая) реализация сохранения студенческой заявки
    private static long saveStudentOrder(StudentOrder studentOrder) {
        long answer;
        answer = 199;
        System.out.println("saveStudentOrder");
        return answer;
    }

}
