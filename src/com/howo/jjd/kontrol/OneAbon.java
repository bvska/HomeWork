package com.howo.jjd.kontrol;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class OneAbon extends Abonement{
    public OneAbon(String regD, String finD, Owner owner) {
        super(regD, finD, owner);
        if (!finDate.isEqual(regDate))
            throw new IllegalArgumentException("дата регистрации должна быть раньше даты окончания");
    }


}
