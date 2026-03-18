package cloneproject.Instagram.entity.post;

import cloneproject.Instagram.entity.member.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "bookmarks")
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 자동으로 만들어주는 코드의 접근 권한을 protected로 설정
public class Bookmark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookmark_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @Builder
    public Bookmark(Member member, Post post) {
        this.member = member;
        this.post = post;
    }
}
