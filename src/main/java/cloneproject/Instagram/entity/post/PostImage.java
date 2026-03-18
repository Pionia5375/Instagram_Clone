package cloneproject.Instagram.entity.post;

import cloneproject.Instagram.vo.Image;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "post_images")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_image_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) // fetch = FetchType.LAZY를 설정하고 comment.getPost()를 호출하면, 처음엔 데이터가 비어있는 **껍데기 객체(Proxy)**가 반환됩니다. comment.getPost().getTitle() 처럼 실제로 그 객체의 내부 필드를 사용하는 시점에 JPA가 DB에 슬쩍 SQL을 날려서 데이터를 채워넣습니다.
    @JoinColumn(name = "post_id") // 상대 테이블의 pk를 외래키로 설정할 때, "post_id"로 이름 설정.
    private Post post;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "imageUrl", column = @Column(name = "post_image_url")), // Image 객체 안의 imageURL 변수를 post_image_url이라는 컬럼에 저장
            @AttributeOverride(name = "imageType", column = @Column(name = "post_image_type")),
            @AttributeOverride(name = "imageName", column = @Column(name = "post_image_name")),
            @AttributeOverride(name = "imageUUID", column = @Column(name = "post_image_uuid"))
    })
    private Image image;

    @CreatedDate
    private LocalDateTime uploadDate;

    @Builder
    public PostImage(Post post, Image image) {
        this.post = post;
        this.image = image;
    }
}
