package com.example.front.app;

import org.json.JSONObject;

import java.sql.Date;

public class ScoreTable {
    int id, studentId, audioId, finalScore, intonation, loudness, phrasing, pronunciation, rhythm, speed;
    String intonationCommand, loudnessCommand, phrasingCommand, pronunciationCommand, rhythmCommand, speedCommand;

    Date createTime;
    Helper helper = Helper.getHelper();

    public ScoreTable(int studentId, int audioId, int finalScore, int intonation, int loudness, int phrasing, int pronunciation, int rhythm, int speed, String intonationCommand, String loudnessCommand, String phrasingCommand, String pronunciationCommand, String rhythmCommand, String speedCommand) {
        this.studentId = studentId;
        this.audioId = audioId;
        this.finalScore = finalScore;
        this.intonation = intonation;
        this.loudness = loudness;
        this.phrasing = phrasing;
        this.pronunciation = pronunciation;
        this.rhythm = rhythm;
        this.speed = speed;
        this.intonationCommand = intonationCommand;
        this.loudnessCommand = loudnessCommand;
        this.phrasingCommand = phrasingCommand;
        this.pronunciationCommand = pronunciationCommand;
        this.rhythmCommand = rhythmCommand;
        this.speedCommand = speedCommand;
        helper.createScore(this);
    }

    public  ScoreTable(int id, int finalScore, Date createTime) {
        this.id = id;
        this.finalScore = finalScore;
        this.createTime = createTime;

    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getAudioId() {
        return audioId;
    }

    public void setAudioId(int audioId) {
        this.audioId = audioId;
    }

    public int getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(int finalScore) {
        this.finalScore = finalScore;
    }

    public int getIntonation() {
        return intonation;
    }

    public void setIntonation(int intonation) {
        this.intonation = intonation;
    }

    public int getLoudness() {
        return loudness;
    }

    public void setLoudness(int loudness) {
        this.loudness = loudness;
    }

    public int getPhrasing() {
        return phrasing;
    }

    public void setPhrasing(int phrasing) {
        this.phrasing = phrasing;
    }

    public int getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(int pronunciation) {
        this.pronunciation = pronunciation;
    }

    public int getRhythm() {
        return rhythm;
    }

    public void setRhythm(int rhythm) {
        this.rhythm = rhythm;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getIntonationCommand() {
        return intonationCommand;
    }

    public void setIntonationCommand(String intonationCommand) {
        this.intonationCommand = intonationCommand;
    }

    public String getLoudnessCommand() {
        return loudnessCommand;
    }

    public void setLoudnessCommand(String loudnessCommand) {
        this.loudnessCommand = loudnessCommand;
    }

    public String getPhrasingCommand() {
        return phrasingCommand;
    }

    public void setPhrasingCommand(String phrasingCommand) {
        this.phrasingCommand = phrasingCommand;
    }

    public String getPronunciationCommand() {
        return pronunciationCommand;
    }

    public void setPronunciationCommand(String pronunciationCommand) {
        this.pronunciationCommand = pronunciationCommand;
    }

    public String getRhythmCommand() {
        return rhythmCommand;
    }

    public void setRhythmCommand(String rhythmCommand) {
        this.rhythmCommand = rhythmCommand;
    }

    public String getSpeedCommand() {
        return speedCommand;
    }

    public void setSpeedCommand(String speedCommand) {
        this.speedCommand = speedCommand;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public JSONObject getObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("finalScore", getFinalScore());
        jsonObject.put("intonation", getIntonation());
        jsonObject.put("loudness", getLoudness());
        jsonObject.put("phrasing", getPhrasing());
        jsonObject.put("pronunciation", getPronunciation());
        jsonObject.put("rhythm", getRhythm());
        jsonObject.put("speed", getSpeed());
        jsonObject.put("intonationCommand", getIntonationCommand());
        jsonObject.put("loudnessCommand", getLoudnessCommand());
        jsonObject.put("phrasingCommand", getPhrasingCommand());
        jsonObject.put("pronunciationCommand", getPronunciationCommand());
        jsonObject.put("rhythmCommand", getRhythmCommand());
        jsonObject.put("speedCommand", getSpeedCommand());
        if (getCreateTime() != null) jsonObject.put("createTime", getCreateTime().toString());
        return jsonObject;
    }
}

