package com.xlx.shiro.entity;

import lombok.Data;

/**
 * 部门
 *
 * @author xielx on 2019/7/7
 */
@Data
public class Dept {

  private Long deptId;
  private String deptName;
  private Long parentId;
  private String parentIds;
  private Boolean available = Boolean.FALSE;
  private Long gmtCreate;
  private Long gmtModified;

}
