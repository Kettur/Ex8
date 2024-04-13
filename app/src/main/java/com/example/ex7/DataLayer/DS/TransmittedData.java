package com.example.ex7.DataLayer.DS;

public class TransmittedData {
    private static TransmittedData instance;
    private String characterName, jobName, bufferCharacterName;
    public static TransmittedData getInstance(){
        if (instance == null){
            instance = new TransmittedData();
        }
        return instance;
    }
    private TransmittedData(){
        characterName = "Choose character";
        jobName = "Choose job";
        bufferCharacterName = "";
    }

    public String getBufferCharacterName() {
        return bufferCharacterName;
    }

    public String getCharacterName() {
        return characterName;
    }

    public String getJobName() {
        return jobName;
    }

    public void setBufferCharacterName(String bufferCharacterName) {
        this.bufferCharacterName = bufferCharacterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
}
