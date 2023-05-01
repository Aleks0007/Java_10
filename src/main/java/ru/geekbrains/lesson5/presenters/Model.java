package ru.geekbrains.lesson5.presenters;

import ru.geekbrains.lesson5.models.Table;

import java.util.Collection;
import java.util.Date;

public interface Model {

    /**
     * Получение всех доступных столиков
     * @return столики
     */
    Collection<Table> loadTables();

    /**
     * Бронирование столика
     * @param reservationDate дата бронирования
     * @param tableNo номер столика
     * @param name имя клиента
     * @return номер брони
     */
    int reservationTable(Date reservationDate, int tableNo, String name);

    /**
     * Изменение бронирования столика
     * @param oldReservation идентификатор старого бронирования
     * @param reservationDate новая дата бронирования
     * @param tableNo номер столика
     * @param name имя клиента
     * @return номер нового бронирования
     */
    int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name);
}