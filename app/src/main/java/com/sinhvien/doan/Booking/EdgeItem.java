package com.sinhvien.doan.Booking;

public class EdgeItem extends AbstractItem {

    public EdgeItem(String label) {
        super(label);
    }



    @Override
    public int getType() {
        return TYPE_EDGE;
    }

}
