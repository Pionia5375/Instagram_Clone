package cloneproject.Instagram.vo;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Objects;

@Getter
@Builder
@Embeddable
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Image {

    @Lob
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    private ImageType imageType;

    private String imageName;

    private String imageUUID;

    @Override // 자바의 모든 클래스는 Object라는 최상위 클래스를 상속함. Object에 이미 hashCode()와 equals()가 구현되어 있음.
    public int hashCode() {
        return Objects.hash(getImageUUID());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Image image = (Image) obj;
        return Objects.equals(getImageUUID(), image.getImageUUID());
    }

}

