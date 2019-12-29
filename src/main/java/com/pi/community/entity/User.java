package com.pi.community.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author Mendax
 * @date 2019/12/29
 **/
@Data
public class User {
    private Long id;
    private String name;
    private String accountId;
    private String token;
    private Date createTime;
    private Date updateTime;

}
