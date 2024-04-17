package com.chuonghoang.service01.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import com.chuonghoang.service01.common.response.Message;
import com.chuonghoang.service01.common.response.ResponseWrapper;
import com.chuonghoang.service01.dto.response.UserResponse;
import com.chuonghoang.service01.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@ResponseWrapper
public class UserController {
    private final UserService userService;


//    @GetMapping("/list")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseData<List<UserResponse>> getAllUser() {
//
//
//        return new ResponseData<>(HttpStatus.CREATED.value(), "xx");
//    }
//
//    @PutMapping("/update")
//    public String updateUser(@RequestParam int userId, @RequestBody UserRequest user) {
//        return "Toi da update thanh cong";
//
//    }


    @GetMapping()
    @Operation(summary = "Get user detail by id")
    @Message(value = "xxxxx")
    public UserResponse getUserDetail(@RequestParam long id) {
        return userService.getUserDetail(id);
    }
}
