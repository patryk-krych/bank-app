package com.patrykkrych.bank_app.rest;

import com.patrykkrych.bank_app.dto.UserDTO;
import com.patrykkrych.bank_app.entity.User;
import com.patrykkrych.bank_app.repository.UserRepository;
import com.patrykkrych.bank_app.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", allowCredentials = "true")
public class AuthenticatedUserRestController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/me")
    public UserDTO getCurrentUser(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.replace("Bearer ", "");
        String userIdStr = jwtUtil.extractUsername(token);

        User user = userRepository.findById(Integer.parseInt(userIdStr))
                .orElseThrow(() -> new RuntimeException("User not found"));

        // mapujemy User na UserDTO
        return new UserDTO(user.getId(), user.getFirstName(), user.getLastName());
    }
}
