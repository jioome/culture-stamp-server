package com.culturestamp.back.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@ToString(exclude = "reviewId")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode( of = {"id","review_id"} )
public class Image {
    @Id
    @GeneratedValue
    @Column(name = "image_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "review_id")
    private Review review;

    @Column(nullable = false)
    private String imagePath;

    @Column(nullable = false)
    private String imageName;

    @Column(nullable = false)
    private String imageType;

    @Column(nullable = false)
    private boolean thumbnailFlag; // TODO Boolean이 아니고 int로 하는 게 맞나?

    @Column(nullable = false)
    private String originalImageName;

    // Review 정보 저장
    public void setReview( Review review ){
        this.review = review;

        // 리뷰글에 현재 이미지가 존재하지 않는다면
        if( !review.getImages().contains(this) ){
            review.getImages().add( this ); // 파일 추가
        }
    }
}
