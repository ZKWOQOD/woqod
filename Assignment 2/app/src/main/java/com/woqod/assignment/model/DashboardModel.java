package com.woqod.assignment.model;

public class DashboardModel {

    String id;
    String itemname;
    String selectedval;


    public DashboardModel(String id, String itemname, String selectedval) {
        this.id = id;
        this.itemname = itemname;
        this.selectedval = selectedval;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getSelectedval() {
        return selectedval;
    }

    public void setSelectedval(String selectedval) {
        this.selectedval = selectedval;
    }


    @Override
    public String toString() {
        return "DashboardModel{" +
                "id='" + id + '\'' +
                ", itemname='" + itemname + '\'' +
                ", selectedval='" + selectedval + '\'' +
                '}';
    }


}
