package com.example.demo;

import com.example.demo.pojo.UserInfo;
import com.example.demo.repository.UserRepository;
import org.elasticsearch.client.ElasticsearchClient;
import org.elasticsearch.client.security.user.User;
import org.elasticsearch.index.query.QueryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Resource
    private UserRepository userRepository;

    @Resource
    private ElasticsearchTemplate template;

    @Test
    public void testInsert(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("lili");
        userInfo.setAddress("beijing");
        userInfo.setNick("11111");
        userInfo.setPhone(13256565656L);
        userInfo.setPrice(BigDecimal.valueOf(3.245));
        userRepository.save(userInfo);
    }

    @Test
    public void testSelect(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("lili");
        userInfo.setAddress("beijing");
        userInfo.setNick("11111");
        userInfo.setPhone(13256565656L);
        userInfo.setPrice(BigDecimal.valueOf(3.245));
//        userRepository.(userInfo);
        Criteria criteria = Criteria.where("address").startsWith("bei");
        CriteriaQuery criteriaQuery = CriteriaQuery.fromQuery(criteria);
        QueryBuilder queryBuilder = QueryBuilder.EMPTY_PARAMS.param()
        SearchQuery searchQuery = new NativeSearchQuery();
        List<UserInfo> userInfoList =  template.queryForList(criteriaQuery,UserInfo.class);
    }
}
