package com.xlx.shiro.DeptDemo;

import com.xlx.shiro.Mapper.DeptMapper;
import com.xlx.shiro.entity.Dept;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * 测试类
 *
 * @author xielx on 2019/7/7
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DeptTest {

  @Resource
  private DeptMapper deptMapper;

  @Test
  public void testDept(){
    System.out.println("===========selectAll method test================");
    List<Dept> deptList = deptMapper.selectList(null);
    Assert.assertEquals(9,deptList.size());
    deptList.forEach(System.out::println);
  }

}

