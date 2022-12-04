package com.culturestamp.back.entity;

import com.culturestamp.back.auth.oauth.entity.ProviderType;
import com.culturestamp.back.auth.oauth.entity.RoleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
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

    // TODO: UNIQUE 설정
    @Column(unique = true, length=64)
//    @Size(max = 100)
    private String loginId;

    @Column
    private String nickname;


    // TODO: added, needed to explain
    @Column
    private ProviderType providerType;

//    TODO: added, needed to explain
//    @Column
//    private String providerId;



    @Column(nullable = false)
    private String email;

    // TODO: edited, needed to explain
    @Column
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleType roleType;

    // TODO: 변경 설명(RESPONSE 까지)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginAt;

    @Column
    private int failCount;

//    @Builder
//    public User(String nickname, String loginId, ProviderType providerType, String email, String password, RoleType roleType, LocalDateTime lastLoginAt, int failCount) {
//        this.nickname = nickname;
//        this.loginId = loginId;
//        this.providerType = providerType;
//        //  this.providerId = providerId;
//        this.email = email;
//        this.password = password;
//        this.roleType = roleType;
//        this.lastLoginAt = lastLoginAt;
//        this.failCount = failCount;
//    }

    public User update(String name) {
        this.nickname = name;
        return this;
    }


}
