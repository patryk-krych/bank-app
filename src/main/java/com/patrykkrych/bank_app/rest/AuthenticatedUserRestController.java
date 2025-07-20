package com.patrykkrych.bank_app.rest;

import com.patrykkrych.bank_app.dto.AccountDTO;
import com.patrykkrych.bank_app.dto.TransactionDTO;
import com.patrykkrych.bank_app.dto.UserDTO;
import com.patrykkrych.bank_app.entity.Account;
import com.patrykkrych.bank_app.entity.Transaction;
import com.patrykkrych.bank_app.entity.User;
import com.patrykkrych.bank_app.repository.UserRepository;
import com.patrykkrych.bank_app.security.JwtUtil;
import com.patrykkrych.bank_app.service.AccountService;
import com.patrykkrych.bank_app.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * API for authenticated user operations (e.g., login, user details).
 * Contains all REST controllers used by the frontend application.
 */

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
    @Autowired
    private TransactionService transactionService;

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

    @PostMapping("/transfer")
    public void Transfer(
            @RequestHeader("Authorization") String authHeader,
            @RequestBody TransactionDTO theTransaction) {


        String token = authHeader.replace("Bearer ", "");
        String userIdStr = jwtUtil.extractUsername(token);

        User user = userRepository.findById(Integer.parseInt(userIdStr))
                .orElseThrow(() -> new RuntimeException("User not found"));



        List<Account> senderAccounts = accountService.findByUser(user);
        Account senderAccount = senderAccounts.getFirst();

        Account receiverAccount = accountService.findById(theTransaction.getToAccount());

        if(BigDecimal.valueOf(theTransaction.getAmount()).compareTo(senderAccount.getBalance()) < 0){
            senderAccount.setBalance(senderAccount.getBalance().subtract(BigDecimal.valueOf(theTransaction.getAmount())));
            receiverAccount.setBalance(receiverAccount.getBalance().add(BigDecimal.valueOf(theTransaction.getAmount())));
            accountService.save(senderAccount);
            accountService.save(receiverAccount);

            Transaction dbTransaction = new Transaction(senderAccount, receiverAccount, theTransaction.getAmount(),
                    theTransaction.getCurrency(), theTransaction.getDate(), theTransaction.getTitle());
            transactionService.save(dbTransaction);

        }
        else {
            throw new RuntimeException("Insufficient balance for the transaction");
        }

    }

}
