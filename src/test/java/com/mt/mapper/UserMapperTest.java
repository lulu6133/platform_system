package com.mt.mapper;

import com.mt.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class UserMapperTest {

private SqlSession sqlSession;

    @Before
    public void before() throws IOException {
        sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("conf/MtMybatis.xml"))
                .openSession();
    }
    
    @Test
    public void findAll() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.findAll();
        users.forEach(e-> System.out.println(e));
    }

    @After
    public void after(){
        sqlSession.commit();
        sqlSession.close();
    }
}