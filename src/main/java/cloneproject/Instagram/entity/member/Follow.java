package cloneproject.Instagram.entity.member;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter // 모든 필드의 getter 메서드를 자동 생성. 모든 데이터 속성 변경은 엔티티 내 메서드를 통해서만 가능
@Entity // 테이블 생성, DB 조작을 가능하게 하는 Entity 객체 생성
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA에서 데이터를 응답할 때는 먼저 기본 생성자를 통해 객체를 생성하고 속성 값을 주입.
@Table(name = "follows") // 테이블 이름을 설정 (커스터마이징)
public class Follow {

    @Id
    @Column(name = "follow_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id") // follow.getMember()를 호출하면 JPA가 follows 테이블의 member_id 값을 확인하고, 그 값으로 member 테이블에서 해당 회원을 찾아서 Member 객체로 돌려줌.
    private Member member;

    @ManyToOne
    @JoinColumn(name = "follow_member_id")
    private Member followMember;

    @Builder
    public Follow(Member member, Member followMember) {
        this.member = member;
        this.followMember = followMember;
    }
}
