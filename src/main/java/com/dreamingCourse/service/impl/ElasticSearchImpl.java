package com.dreamingCourse.service.search.impl;

import com.dreamingCourse.entity.search.SearchElastic;
import com.dreamingCourse.mapper.search.ElasticMapper;
import com.dreamingCourse.service.search.ElasticService;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Bulk;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Service
public class ElasticSearchImpl implements ElasticService {

//    private static final Logger LOGGER = LoggerFactory.getLogger(ElasticSearchImpl.class);
    @Resource
    private ElasticMapper elasticMapper;
    @Autowired
    private JestClient jestClient;
    @Override
    public List<SearchElastic> findall() {
        List<SearchElastic> searchElastics = elasticMapper.findall();
        return searchElastics;
    }

    @Override
    public void save(List<SearchElastic> eslist) {
        Bulk.Builder bulk = new Bulk.Builder();
        for(SearchElastic searchElastic : eslist) {
            Index index = new Index.Builder(searchElastic).index(SearchElastic.INDEX).type(SearchElastic.ORDER_TYPE).id(searchElastic.getId()).build();
            bulk.addAction(index);
        }
        try {
            jestClient.execute(bulk.build());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<SearchElastic> searches(String keyword) {

        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        if (keyword != null) {
            boolQueryBuilder.should(QueryBuilders.commonTermsQuery("id",keyword));
            boolQueryBuilder.should(QueryBuilders.commonTermsQuery("name", keyword));
            boolQueryBuilder.should(QueryBuilders.commonTermsQuery("subtitle", keyword));
            boolQueryBuilder.should(QueryBuilders.commonTermsQuery("detail", keyword));
            boolQueryBuilder.should(QueryBuilders.commonTermsQuery("main_images", keyword));
            boolQueryBuilder.should(QueryBuilders.commonTermsQuery("price", keyword));
            boolQueryBuilder.should(QueryBuilders.commonTermsQuery("tag_id", keyword));
        }

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        searchSourceBuilder.query(boolQueryBuilder).size(20); //需要检索的数据条数，这里可以设计为分页
        Search search = new Search.Builder(searchSourceBuilder.toString())
                .addIndex(SearchElastic.INDEX).addType(SearchElastic.ORDER_TYPE).build();
        try {
            JestResult result = jestClient.execute(search);
            return result.getSourceAsObjectList(SearchElastic.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}

