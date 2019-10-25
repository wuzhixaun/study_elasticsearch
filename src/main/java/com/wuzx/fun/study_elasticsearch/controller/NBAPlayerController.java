package com.wuzx.fun.study_elasticsearch.controller;

import com.wuzx.fun.study_elasticsearch.model.NBAPlayer;
import com.wuzx.fun.study_elasticsearch.service.NBAPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/nba")
public class NBAPlayerController {

    @Autowired
    private NBAPlayerService nbaPlayerService;

    @RequestMapping("/addPlayer")
    public Boolean addPlayer(NBAPlayer nbaPlayer, String id) throws IOException {
        System.out.println(id);
        return nbaPlayerService.addPlayer(nbaPlayer, id);
    }

    @RequestMapping("/updatePlayer")
    public Object updatePlayer(NBAPlayer nbaPlayer, String id) throws IOException {
        return nbaPlayerService.updatePlayer(nbaPlayer, id);
    }

    @RequestMapping("/deletePlayer")
    public Object deletePlayer(String id) throws IOException {
        return nbaPlayerService.deletePlayer(id);
    }

    @RequestMapping("/getPlayer")
    public Map<String, Object> getPlayer(String id) throws IOException {
        return nbaPlayerService.getPlayer(id);
    }

    @RequestMapping("/deleteAllPlayer")
    public boolean deleteAllPlayer() throws IOException {
        return nbaPlayerService.deleteAllPlayer();
    }

    @RequestMapping("/importNbaPlayerToES")
    public Object importNbaPlayerToES() {
        try {
            return nbaPlayerService.importNbaPlayerToES();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }


    @RequestMapping("/searchMatch")
    public List<NBAPlayer> searchMatch(String key, String value) throws IOException {
        return nbaPlayerService.searchMatch(key, value);
    }

    @RequestMapping("/searchByTerm")
    public List<NBAPlayer> searchByTerm(String key, String value) throws IOException {
        return nbaPlayerService.searchByTerm(key, value);
    }

    @RequestMapping("/searchByPrefix")
    public List<NBAPlayer> searchByPrefix(String key, String value) throws IOException {
        return nbaPlayerService.searchByPrefix(key, value);
    }
}
