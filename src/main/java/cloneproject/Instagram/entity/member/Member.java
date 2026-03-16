package cloneproject.Instagram.entity.member;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    private String website; // JPA가 매팽해주는 컬럼명 그대로 사용.

    @Lob // DB에서 일반 VARCHAR(255) 대신 TEXT나 CLOB 타입으로 매핑 -> 프로필 소개는 내용이 김.
    private String introduce;

    private String email;

    private String phone;

    @Enumerated(EnumType.STRING) // enum의 값을 DB에 저장할 때, 문자열 그대로 저장하라는 의미.
    private Gender gender;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "image_type")
    private String imageType;

    @Column(name = "image_name")
    private String imageName;

    @Column(name = "image_uuid")
    private String imageUUID;

}
