package com._axislabs.attendance_system.controller;

import com._axislabs.attendance_system.dto.LoginRequestDto;
import com._axislabs.attendance_system.enums.RestApiResponseStatusCodes;
import com._axislabs.attendance_system.service.UserService;
import com._axislabs.attendance_system.util.EndpointBundle;
import com._axislabs.attendance_system.util.ResponseWrapper;
import com._axislabs.attendance_system.util.ValidationMessages;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(EndpointBundle.USER)
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(EndpointBundle.LOGIN_USER)
    public ResponseEntity<ResponseWrapper<String>> login(@Valid @RequestBody LoginRequestDto loginDto) {
        try {
            String token = userService.login(loginDto);

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper<>(
                    RestApiResponseStatusCodes.SUCCESS.getCode(),
                    ValidationMessages.LOGIN_SUCCESSFUL,
                    token
            ));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseWrapper<>(
                    RestApiResponseStatusCodes.BAD_REQUEST.getCode(),
                    e.getMessage(),
                    null
            ));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseWrapper<>(
                    RestApiResponseStatusCodes.BAD_REQUEST.getCode(),
                    ValidationMessages.INVALID_CREDENTIAL,
                    null
            ));
        }
    }
}
