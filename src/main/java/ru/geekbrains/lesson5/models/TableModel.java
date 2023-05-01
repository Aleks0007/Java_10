package ru.geekbrains.lesson5.models;

import ru.geekbrains.lesson5.presenters.Model;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TableModel implements Model {

    private Collection<Table> tables;

    public Collection<Table> loadTables() {
        if (tables == null) {
            tables = new ArrayList<>();
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }
        return tables;
    }

    public int reservationTable(Date reservationDate, int tableNo, String name) {
        for (Table table : tables) {
            if (table.getNo() == tableNo) {
                Reservation reservation = new Reservation(reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        return -1;
    }

    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        Reservation oldRes = null;
        Table oldTable = null;

        for (Table table : tables) {
            for (Reservation reservation : table.getReservations()) {
                if (reservation.getId() == oldReservation) {
                    oldRes = reservation;
                    oldTable = table;
                    break;
                }
            }
            if (oldRes != null) {
                break;
            }
        }

        if (oldRes != null && oldTable != null) {
            oldTable.getReservations().remove(oldRes);
            return reservationTable(reservationDate, tableNo, name);
        } else {
            return -1;
        }
    }
}