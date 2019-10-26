package com.shbaek.webservice.web;

import com.shbaek.webservice.domain.posts.Posts;
import com.shbaek.webservice.domain.posts.PostsRepository;
import com.shbaek.webservice.dto.posts.PostsSaveRequestDto;
import com.shbaek.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsService postsService;

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto){
        postsService.save(dto);
    }
}
