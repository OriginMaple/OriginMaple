package com.maple.originmapleapp.dao;

import com.maple.originmapleapp.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper // Mybatis 사용할때 필요한 어노테이션
@Repository // JPA 사용시 필요한 어노테이션
public interface AuthDao {

    MemberDto login(String Email);

}



