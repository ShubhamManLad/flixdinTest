package com.example.flixdintest.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApplicantCall {

    @SerializedName("callid")
    @Expose
    private String callid;
    @SerializedName("applicant")
    @Expose
    private String applicant;

    public String getCallid() {
        return callid;
    }

    public void setCallid(String callid) {
        this.callid = callid;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

}