package cloneproject.Instagram.entity.post;

import cloneproject.Instagram.entity.member.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Getter
@Entity
@Table(name = "post_mentions")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostMention {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @Builder
    public PostMention(Member member, Post post) {
        this.member = member;
        this.post = post;
    }


}
