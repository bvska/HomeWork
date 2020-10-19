package com.howo.jjd.kontrol;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class FullAbon extends Abonement{
    public FullAbon(String regD, String finD, Owner owner) {
        super(regD, finD, owner);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FullAbon)) return false;

        Abonement abonement = (FullAbon) o;

        if (regDate != null ? !regDate.equals(abonement.regDate) : abonement.regDate != null) return false;
        if (finDate != null ? !finDate.equals(abonement.finDate) : abonement.finDate != null) return false;
        return owner != null ? owner.equals(abonement.owner) : abonement.owner == null;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
