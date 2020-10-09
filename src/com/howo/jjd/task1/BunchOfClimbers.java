package com.howo.jjd.task1;

import java.util.Arrays;

public class BunchOfClimbers {


    private Boolean access = true;
    private Climber[] bunchOfClimber;
    private Mountain mountain;



    public void setAccess(Boolean access) {
        this.access = access;
    }
    public Boolean getAccess() {
        return access;
    }


    public BunchOfClimbers(int count, Boolean access, Mountain mountain) {
        if (count < 2)
            throw new IllegalArgumentException("меньше 2х это уже не группа");
        bunchOfClimber = new Climber[count];
        this.mountain = mountain;
        setAccess(access);
    }

        public void addBunchOfClimber(Climber group) {
            if (access) {
                for (int i = 0; i < bunchOfClimber.length; i++) {
                    if (bunchOfClimber[i] == null) {
                        bunchOfClimber[i] = group;

                        return;
                    }
                }
            }
        }
        public String getInfo(){
            StringBuilder sb = new StringBuilder();
            for (Climber group : bunchOfClimber){
                if (group != null)
                    sb.append(group.getNameClimber())
                            .append(" ")
                            .append(group.getAddressClimber())
                            .append(" ")
                            .append(mountain.getNameMountain())
                            .append("\n");


            }
            return sb.toString();
        }





 }
