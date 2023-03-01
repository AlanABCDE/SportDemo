package com.noob.sportsdemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.sql.Timestamp;

@TableName("tbl_playerdata")
public class Playerdata {
    private int PlayerID;
    private String SoldierName;
    private int GlobalRank;
    private String EAGUID;
    private String CountryCode;
    private Timestamp created_at;
    private Timestamp update_at;

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Timestamp update_at) {
        this.update_at = update_at;
    }

    public int getPlayerID() {
        return PlayerID;
    }

    public void setPlayerID(int playerID) {
        PlayerID = playerID;
    }

    public String getSoldierName() {
        return SoldierName;
    }

    public void setSoldierName(String soldierName) {
        SoldierName = soldierName;
    }

    public int getGlobalRank() {
        return GlobalRank;
    }

    public void setGlobalRank(int globalRank) {
        GlobalRank = globalRank;
    }

    public String getEAGUID() {
        return EAGUID;
    }

    public void setEAGUID(String EAGUID) {
        this.EAGUID = EAGUID;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }


    @Override
    public String toString() {
        return "User{" +
                "PlayerID=" + PlayerID +
                ", SoldierName='" + SoldierName + '\'' +
                ", GlobalRank=" + GlobalRank +
                ", EAGUID='" + EAGUID + '\'' +
                ", CountryCode='" + CountryCode + '\'' +
                '}';
    }
}
