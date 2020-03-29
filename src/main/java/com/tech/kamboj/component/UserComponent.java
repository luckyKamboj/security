package com.tech.kamboj.component;

import com.mysql.cj.jdbc.util.BaseBugReport;
import com.tech.kamboj.common.BaseResponse;
import com.tech.kamboj.common.DozerMapper;
import com.tech.kamboj.dtos.UserDto;
import com.tech.kamboj.entities.User;
import com.tech.kamboj.exception.UserNotFoundException;
import com.tech.kamboj.request.UserRequest;
import com.tech.kamboj.response.UserResponse;
import com.tech.kamboj.response.UsersInfoResponse;
import com.tech.kamboj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class UserComponent {
    @Autowired
    UserService userService;

    public UserResponse findUserById(Long id, UserRequest userRequest) {
        UserResponse userResponse = new UserResponse();
        UserDto userDto = userService.findUserById(id, userRequest.getUserDto());
        if (Objects.nonNull(userDto)) {
        } else {
            userResponse.setStatus(ResponseCode.NO_CONTENT);
            userResponse.setResponseCode(ResponseCode.NO_CONTENT_CODE);
        }
        return userResponse;
    }

    public UserResponse save(UserDto userDto) {
        UserResponse userResponse = new UserResponse();
        User user = userService.save(DozerMapper.map(userDto, User.class));
        if (Objects.nonNull(user)) {
            userResponse.setUserDto(userDto);
            userResponse.setStatus(ResponseCode.OK);
            userResponse.setResponseCode(ResponseCode.OK_CODE);
            userResponse.setResponseMsg(ResponseMsg.SUCCESS);
        } else {
            userResponse.setStatus(ResponseCode.ERROR_IN_SAVE);
            userResponse.setResponseCode(ResponseCode.ERROR_IN_SAVE_CODE);
        }
        return userResponse;
    }

    public UsersInfoResponse findAllUsers() {
        UsersInfoResponse userResponse = new UsersInfoResponse();
        List<UserDto> users = userService.findAllUsers().stream().map(p -> DozerMapper.map(p, UserDto.class)).collect(Collectors.toList());
        if (users.isEmpty()) {
            userResponse.setStatus(ResponseCode.NO_CONTENT);
            userResponse.setResponseCode(ResponseCode.NO_CONTENT_CODE);
            return userResponse;
        }
        userResponse.setUserDtoList(users);
        userResponse.setStatus(ResponseCode.OK);
        userResponse.setResponseCode(ResponseCode.OK_CODE);
        userResponse.setResponseMsg(ResponseMsg.SUCCESS);
        return userResponse;
    }

    public UserResponse findUserById(Long id) {
        UserResponse userResponse = new UserResponse();
        UserDto userDto = userService.findUserById(id).map(u -> DozerMapper.map(u, UserDto.class))
                .orElseThrow(() -> new UserNotFoundException("User Searched Not Found", id));
        if (Objects.isNull(userDto)) {
            userResponse.setStatus(ResponseCode.NO_CONTENT);
            userResponse.setResponseCode(ResponseCode.NO_CONTENT_CODE);
            return userResponse;
        }
        userResponse.setUserDto(userDto);
        userResponse.setStatus(ResponseCode.OK);
        userResponse.setResponseCode(ResponseCode.OK_CODE);
        userResponse.setResponseMsg(ResponseMsg.SUCCESS);
        return userResponse;
    }

    public BaseResponse findUser(Long id) {
        BaseResponse baseResponse = new BaseResponse();
       return userService.findUserById(id).map(record -> {
            userService.deleteUserById(id);
            return sendResponse(baseResponse);
        }).orElseThrow(() -> new UserNotFoundException("User To Delete Not Found", id));

    }

    private BaseResponse sendResponse(BaseResponse baseResponse) {
        baseResponse.setStatus(ResponseCode.OK);
        baseResponse.setResponseCode(ResponseCode.OK_CODE);
        baseResponse.setResponseMsg(ResponseMsg.SUCCESS);
        return baseResponse;
    }
}
