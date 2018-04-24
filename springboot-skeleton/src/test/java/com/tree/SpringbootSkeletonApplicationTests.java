package com.tree;

import com.alibaba.fastjson.JSON;
import com.tree.util.SpringContextHolder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootSkeletonApplicationTests {
    @Autowired
    private SpringContextHolder holder ;

	@Test
	public void contextLoads() {
        System.err.println("aaaaaaa:"+JSON.toJSONString(SpringContextHolder.getBeanNames()));
        System.err.println("bbbbbbb:"+JSON.toJSONString(holder.getBeanNames()));

	}

}
