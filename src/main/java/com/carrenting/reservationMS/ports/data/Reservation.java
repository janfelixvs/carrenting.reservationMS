package com.carrenting.reservationMS.ports.data;

import java.util.Date;

public class Reservation {

    private Date startDate;
    private Date endDate;


    Reservation(Date startDate, Date endDate){
        this.startDate=startDate;
        this.endDate=endDate;
    }

    public Date getStartDate(){
        return startDate;
    }

    public Date getEndDate(){
        return endDate;
    }


}
