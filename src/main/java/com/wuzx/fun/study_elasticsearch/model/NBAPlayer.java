package com.wuzx.fun.study_elasticsearch.model;

import lombok.Data;

import java.util.Date;

/**
 * @author wuzx
 * @version 1.0
 * @date 2019-07-12 20:05
 */
@Data
public class NBAPlayer {
    private Integer id;
    private String countryEn;
    private String country;
    private String code;
    private String displayAffiliation;
    private String displayName;
    private Integer draft;
    private String schoolType;
    private String weight;
    private Integer playYear;
    private String jerseyNo;
    private Long birthDay;
    private String birthDayStr;
    private String displayNameEn;
    private String position;
    private Double heightValue;
    private String playerId;
    private String teamCity;
    private String teamCityEn;
    private String teamName;
    private String teamNameEn;
    private String teamConference;
    private String teamConferenceEn;
    private Integer age;

}
