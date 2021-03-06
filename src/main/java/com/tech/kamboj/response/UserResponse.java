package com.tech.kamboj.response;

import com.tech.kamboj.common.BaseResponse;
import com.tech.kamboj.dtos.UserDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse extends BaseResponse {
    private UserDto userDto;
}
