package ru.yandex.practicum.catsgram.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.model.Post;
import ru.yandex.practicum.catsgram.service.PostService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @GetMapping
    public List<Post> findAll(
            @RequestParam(name = "sort", defaultValue = "desc") String sort,
            @RequestParam(name = "from", defaultValue = "0") int from,
            @RequestParam(name = "size", defaultValue = "10") int size) {
        return postService.findAll(size, from, sort);
    }

    @PostMapping
    // указываем, что код успешного ответа должен быть 201 Created
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@RequestBody Post post) {
        return postService.create(post);
    }

    @PutMapping
    public Post update(@RequestBody Post newPost) {
        return postService.update(newPost);
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<Optional<Post>> getPost(@PathVariable Long postId) {
        Optional<Post> result = postService.findPostById(postId);
        // указываем нужные заголовки и их значения
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        // возвращаем ResponseEntity с настроенными телом, заголовками и кодом ответа
        return new ResponseEntity<>(result, headers, HttpStatus.OK);
    }
}