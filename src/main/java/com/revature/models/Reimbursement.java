package com.revature.models;


public class Reimbursement {

    private int reimb_id;
    private double reimb_amount;
    private String reimb_description;
    //private int reimb_type_id_fk;
    private int reimb_status_id_fk;
    private ReimbursementStatus reimb_status;
    private String user_name_fk;

    public Reimbursement(int reimb_id,
                         double reimb_amount,
                         String reimb_description,
                         //int reimb_type_id_fk,
                         int reimb_status_id_fk,
                         String user_name_fk,
                         ReimbursementStatus reimb_status
                         ) {
        this.reimb_id =
                reimb_id;
        this.reimb_amount =
                reimb_amount;
        this.reimb_description =
                reimb_description;
       /* this.reimb_type_id_fk =
                reimb_type_id_fk;*/
        this.reimb_status_id_fk =
                reimb_status_id_fk;
        this.user_name_fk =
                user_name_fk;
        this.reimb_status = reimb_status;
    }

    public int getReimb_id() {
        return reimb_id;
    }

    public void setReimb_id(int reimb_id) {
        this.reimb_id =
                reimb_id;
    }

    public double getReimb_amount() {
        return reimb_amount;
    }

    public void setReimb_amount(double reimb_amount) {
        this.reimb_amount =
                reimb_amount;
    }

    public String getReimb_description() {
        return reimb_description;
    }

    public void setReimb_description(String reimb_description) {
        this.reimb_description =
                reimb_description;
    }

    /*public int getReimb_type_id_fk() {
        return reimb_type_id_fk;
    }

    public void setReimb_type_id_fk(int reimb_type_id_fk) {
        this.reimb_type_id_fk =
            reimb_type_id_fk;
    }*/

    public int getReimb_status_id_fk() {
        return reimb_status_id_fk;
    }

    public void setReimb_status_id_fk(int reimb_status_id_fk) {
        this.reimb_status_id_fk =
                reimb_status_id_fk;
    }

    public ReimbursementStatus getReimb_status() {
        return reimb_status;
    }
    public void setReimb_status(ReimbursementStatus reimb_status){
        this.reimb_status = reimb_status;
    }
    public String getUser_name_fk() {
        return user_name_fk;
    }

    public void setUser_name_fk(String user_name_fk) {
        this.user_name_fk =
                user_name_fk;
    }

    @Override
    public String toString() {
        return "Reimbursements{" +
                "reimb_id = '" + reimb_id + '\'' +
                ", reimb_amount = '" + reimb_amount + '\'' +
                ", reimb_description = '"  + reimb_description + '\'' +
                ", reimb_status_id_fk = '" + reimb_status_id_fk + '\'' +
                ", reimb_status = '" + '\'' + reimb_status + '\'' +
                ", user_name_fk = '" + user_name_fk +'}';
    }

}
