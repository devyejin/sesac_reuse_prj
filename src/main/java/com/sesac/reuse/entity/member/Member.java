package com.sesac.reuse.entity.member;

import com.sesac.reuse.base.BaseEntity;

import com.sesac.reuse.entity.board.Board;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@ToString
@Setter
public class Member extends BaseEntity {

    @Id
    @Column(name="member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String pw;
    private String nickname;

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.LAZY)
    private Set<MemberRole> roleSet = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private MEMBER_STATUS isActive; //탈퇴여부

    @Enumerated(EnumType.STRING)
    private SocialSignUpInfo social;

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Board> boardList;

    public Member(String email, String nickname) {
        this.email = email;
        this.nickname = nickname;
    }

    public Member() {

    }

    public void encrptyPassword(String encryptedPw) {
        this.pw = encryptedPw;
    }

    public void addRole(MemberRole memberRole) {
        this.roleSet.add(memberRole);
    }

    public void setSocial(SocialSignUpInfo social) {
        this.social = social;
    }

    public void setIsActive(MEMBER_STATUS isActive) {
        this.isActive = isActive;
    }

    public void changeNickname(String nickname) {

        this.nickname = nickname;
    }

    public void changePw(String encoedPw) {
        this.pw = encoedPw;
    }
}