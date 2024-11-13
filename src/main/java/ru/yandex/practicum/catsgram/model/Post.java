package ru.yandex.practicum.catsgram.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class Post {
    private Long id;
    private long authorId;
    private String description;
    private Instant postDate;
}
