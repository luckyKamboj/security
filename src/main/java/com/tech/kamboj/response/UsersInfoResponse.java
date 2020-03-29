package com.tech.kamboj.response;

import com.tech.kamboj.common.BaseResponse;
import com.tech.kamboj.dtos.UserDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UsersInfoResponse extends BaseResponse {
    List<UserDto> userDtoList;
}
