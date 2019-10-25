package com.wuzx.fun.study_elasticsearch.service;

import com.wuzx.fun.study_elasticsearch.model.NBAPlayer;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface NBAPlayerService {

    /**
     * 增加索引文档
     */
    public Boolean addPlayer(NBAPlayer nbaPlayer, String id) throws IOException;

    /**
     * 修改索引
     */
    public Boolean updatePlayer(NBAPlayer nbaPlayer,String id) throws IOException;

    /**
     * 删除文档信息
     */
    public Boolean deletePlayer(String id) throws IOException;

    /**
     * 获取一个文档信息
     */
    public Map<String, Object> getPlayer(String id) throws IOException;


    /**
     * 删除所有的文档信息
     */
    public Boolean deleteAllPlayer() throws IOException;


    /**
     * 导入mysql数据到elasticsearch
     */
    public Object importNbaPlayerToES() throws IOException;


    /**
     * 通过field 和对于的值匹配球员
     * @param key
     * @param value
     * @return
     * @throws IOException
     */
    public List<NBAPlayer> searchMatch(String key, String value) throws IOException;


    /**
     * 通过词条查询
     * @param key
     * @param value
     * @return
     * @throws IOException
     */
    public List<NBAPlayer> searchByTerm(String key, String value) throws IOException;


    /**
     * 通过字母查询球员(任意字母的首字以xx开头)
     * @param key
     * @param value
     * @return
     * @throws IOException
     */
    public List<NBAPlayer> searchByPrefix(String key, String value) throws IOException;
}
