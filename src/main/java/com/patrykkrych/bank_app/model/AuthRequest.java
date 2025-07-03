package com.patrykkrych.bank_app.model;

import lombok.Data;

@Data
public class AuthRequest {
    private String userId;
    private String password;
}
