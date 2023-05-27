package com.T07.compExec.api.model;

public class CompExecResults {

    private int idResult;
    private String resMessage;

    public CompExecResults () {
        this.idResult = -1;
        this.resMessage = "";
    }

    public CompExecResults (int idResult, String errMessage) {
        this.idResult = idResult;
        this.resMessage = errMessage;
    }

    public int getIdResult () {
        return idResult;
    }

    public void setIdResult (int idResult) {
        this.idResult = idResult;
    }

    public String getResMessage () {
        return resMessage;
    }

    public void setResMessage (String errMessage) {
        this.resMessage = errMessage;
    }

}
