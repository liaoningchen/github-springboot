package com.springboot.elasticsearch.service;
import com.springboot.elasticsearch.bean.UserES;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface UserESRepository extends ElasticsearchRepository<UserES, Long> {}