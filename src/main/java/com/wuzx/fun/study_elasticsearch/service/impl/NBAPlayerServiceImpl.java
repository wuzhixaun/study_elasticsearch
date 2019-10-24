package com.wuzx.fun.study_elasticsearch.service.impl;

import com.wuzx.fun.study_elasticsearch.dao.NBAPlayerDao;
import com.wuzx.fun.study_elasticsearch.model.NBAPlayer;
import com.wuzx.fun.study_elasticsearch.service.NBAPlayerService;
import com.wuzx.fun.study_elasticsearch.utils.BeanUtils;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class NBAPlayerServiceImpl implements NBAPlayerService {

    private static final String NBA_INDEX = "nba_latest";

    @Autowired
    private RestHighLevelClient client;

    @Autowired
    private NBAPlayerDao dao;

    @Override
    public Boolean addPlayer(NBAPlayer nbaPlayer, String id) throws IOException {
        //创建索引请求
        IndexRequest indexRequest = new IndexRequest(NBA_INDEX).id(id).source(BeanUtils.beanToMap(nbaPlayer));
        //发送请求
        IndexResponse index = client.index(indexRequest, RequestOptions.DEFAULT);

        System.out.println(index);
        return true;
    }

    @Override
    public Boolean updatePlayer(NBAPlayer nbaPlayer,String id ) throws IOException {
        //创建修改请求
        UpdateRequest updateRequest = new UpdateRequest(NBA_INDEX,id).doc(BeanUtils.beanToMap(nbaPlayer));
        UpdateResponse updateResponse = client.update(updateRequest, RequestOptions.DEFAULT);

        System.out.println(updateResponse);
        return true;
    }

    @Override
    public Boolean deletePlayer(String id) throws IOException {
        //创建删除索引
        DeleteRequest deleteRequest = new DeleteRequest(NBA_INDEX, id);

        DeleteResponse deleteResponse = client.delete(deleteRequest, RequestOptions.DEFAULT);

        System.out.println(deleteResponse);
        return true;
    }

    @Override
    public Map<String, Object> getPlayer(String id) throws IOException {
        //创建查找索引
        GetRequest getRequest = new GetRequest(NBA_INDEX,id);
        GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);

        System.out.println(getResponse);
        return getResponse.getSource();
    }

    @Override
    public Boolean deleteAllPlayer() throws IOException {
        DeleteByQueryRequest deleteByQueryRequest = new DeleteByQueryRequest(NBA_INDEX);

        BulkByScrollResponse bulkByScrollResponse = client.deleteByQuery(deleteByQueryRequest, RequestOptions.DEFAULT);

        System.out.println(bulkByScrollResponse);
        return true;
    }

    @Override
    public Object importNbaPlayerToES() throws IOException {

        //查询所有的球员信息
        List<NBAPlayer> nbaPlayers = dao.ListNBAPlayers();
        for (NBAPlayer player : nbaPlayers) {
            addPlayer(player, String.valueOf(player.getId()));
        }
        return nbaPlayers;
    }
}
