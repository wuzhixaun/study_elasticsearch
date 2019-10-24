package com.wuzx.fun.study_elasticsearch;

import com.wuzx.fun.study_elasticsearch.dao.NBAPlayerDao;
import com.wuzx.fun.study_elasticsearch.model.NBAPlayer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudyElasticsearchApplicationTests {

    @Autowired
    NBAPlayerDao dao;
    @Test
    void contextLoads() {

        List<NBAPlayer> nbaPlayers = dao.ListNBAPlayers();

        System.out.println(nbaPlayers);
    }

}
