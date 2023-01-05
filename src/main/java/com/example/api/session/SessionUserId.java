package com.example.api.session;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class SessionUserId {
    @Getter
    private Long id;

    public static SessionUserId systemUser(){
        return new SessionUserId(1L);
    }
}
