package com.wuzx.fun.study_elasticsearch.dao;

import com.wuzx.fun.study_elasticsearch.model.NBAPlayer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NBAPlayerDao {

    public List<NBAPlayer> ListNBAPlayers();
}
