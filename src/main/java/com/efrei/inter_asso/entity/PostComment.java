package com.efrei.inter_asso.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "ia_post_comment")
public class PostComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_comment_id")
    private int postCommentId;

    @Column(name = "content",nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;
}
