package com.culturestamp.back.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
public class User extends BaseTimeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column
    private String nickname;

    @Column(nullable = false)
    private String loginId;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    // TODO: 변경 설명(RESPONSE 까지)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginAt;
    @Column
    private int failCount;


    @Builder
    public User(String loginId, String email, String password, Role role, int failCount) {
        this.loginId = loginId;
        this.email = email;
        this.password = password;
        this.role = role;
        this.failCount = failCount;
    }


    public User update(String name, String picture) {
        this.nickname = name;
        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }

}
