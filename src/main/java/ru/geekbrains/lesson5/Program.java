package ru.geekbrains.lesson5;

import ru.geekbrains.lesson5.models.TableModel;
import ru.geekbrains.lesson5.presenters.BookingPresenter;
import ru.geekbrains.lesson5.views.BookingView;

import java.util.Date;

public class Program {

    public static void main(String[] args) {
        TableModel tableModel = new TableModel();
        BookingView bookingView = new BookingView();
        BookingPresenter bookingPresenter = new BookingPresenter(tableModel, bookingView);
        bookingPresenter.loadTables();
        bookingPresenter.updateView();

        bookingView.reservationTable(new Date(), 3, "Станислав");

        int newReservationNo = bookingPresenter.changeReservationTable(1001, new Date(), 2, "Станислав");
        if (newReservationNo > 0) {
            System.out.printf("Бронь успешно изменена. Новый номер брони: #%d\n", newReservationNo);
        } else {
            System.out.println("Ошибка изменения брони.");
        }
    }
}