package services;

import models.Staffs;

public interface StaffDataSource {
    Staffs getStaffsData();

    void setStaffsData(Staffs staffs);
}
