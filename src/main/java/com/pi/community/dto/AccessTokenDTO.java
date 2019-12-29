package com.pi.community.dto;

import lombok.Data;

/**
 * @author Mendax
 * @date 2019/12/29
 **/
@Data
public class AccessTokenDTO {
    private String  clientId;
    private String clientSecret;
    private String code;
    private String redirectUri;
    private String state;
}
