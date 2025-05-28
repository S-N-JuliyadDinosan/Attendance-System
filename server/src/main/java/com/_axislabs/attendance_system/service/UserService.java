package com._axislabs.attendance_system.service;

import com._axislabs.attendance_system.dto.LoginRequestDto;

public interface UserService {
    String login(LoginRequestDto loginDto);
}
