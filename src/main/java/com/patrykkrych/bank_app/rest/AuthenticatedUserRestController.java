package com.patrykkrych.bank_app.rest;

import com.patrykkrych.bank_app.dto.AccountDTO;
import com.patrykkrych.bank_app.dto.UserDTO;
import com.patrykkrych.bank_app.entity.Account;
import com.patrykkrych.bank_app.entity.User;
import com.patrykkrych.bank_app.repository.UserRepository;
import com.patrykkrych.bank_app.security.JwtUtil;
import com.patrykkrych.bank_app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", allowCredentials = "true")
public class AuthenticatedUserRestController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountService accountService;

    @GetMapping("/me")
    public UserDTO getCurrentUser(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.replace("Bearer ", "");
        String userIdStr = jwtUtil.extractUsername(token);

        User user = userRepository.findById(Integer.parseInt(userIdStr))
                .orElseThrow(() -> new RuntimeException("User not found"));

        return new UserDTO(user.getId(), user.getFirstName(), user.getLastName());
    }

    @GetMapping("/accounts")
    public List<AccountDTO> getUserAccounts(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.replace("Bearer ", "");
        String userIdStr = jwtUtil.extractUsername(token);

        User user = userRepository.findById(Integer.parseInt(userIdStr))
                .orElseThrow(() -> new RuntimeException("User not found"));

        return accountService.findByUser(user).stream()
                .map(account -> new AccountDTO(
                        account.getAccountId(),
                        account.getBalance(),
                        account.getCurrency()
                ))
                .toList();
    }
}
