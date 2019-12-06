package com.example.demo.repository;

import com.example.demo.pojo.UserInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

public interface UserRepository extends ElasticsearchCrudRepository<UserInfo,String> {

}
