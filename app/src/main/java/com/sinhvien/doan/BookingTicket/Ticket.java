package com.sinhvien.doan.BookingTicket;

public class Ticket {
    String Quanlity, Start, Stop, Total, Seat, Id, Route, Date;

    public Ticket() {
    }

    public Ticket(String Quanlity, String Start, String Stop, String Total, String Seat, String Id, String Route, String Date) {
        this.Id = Id;
        this.Quanlity = Quanlity;
        this.Start = Start;
        this.Stop = Stop;
        this.Total = Total;
        this.Seat = Seat;
        this.Route = Route;
        this.Date = Date;
    }

    public String getQuanlity() {
        return Quanlity;
    }
    public String getDate() {
        return Date;
    }

    public String getStart() {
        return Start;
    }

    public String getStop() {
        return Stop;
    }

    public String getTotal() {
        return Total;
    }

    public String getSeat() {
        return Seat;
    }
    public String getID() {
        return Id;
    }
    public String getRoute() {
        return Route;
    }


    public void setQuanlity(String Quanlity) {
        this.Quanlity = Quanlity;
    }

    public void setRoute(String Route) {
        this.Quanlity = Route;
    }
    public void setDate(String Date) {
        this.Quanlity = Date;
    }
    public void setStart(String Start) {
        this.Start = Start;
    }

    public void setStop(String Stop) {
        this.Stop = Stop;
    }

    public void setTotal(String Total) {
        this.Total = Total;
    }

    public void setSeat(String Seat) {
        this.Seat = Seat;
    }
    public void setID(String Id) {
        this.Id = Id;
    }

}
