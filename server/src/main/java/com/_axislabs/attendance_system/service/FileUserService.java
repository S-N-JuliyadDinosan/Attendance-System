package com._axislabs.attendance_system.service;

import com._axislabs.attendance_system.entity.User;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service
public class FileUserService {
    private final Map<String, String> users = new HashMap<>();

    public FileUserService() {
        try (
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(
                                new ClassPathResource("users.txt").getInputStream(), StandardCharsets.UTF_8
                        )
                )
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    users.put(parts[0], parts[1]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User findByUsername(String username) {
        if (users.containsKey(username)) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(users.get(username));
            return user;
        }
        return null;
    }
}
