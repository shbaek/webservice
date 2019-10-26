package com.shbaek.webservice.service;

import com.shbaek.webservice.domain.posts.Posts;
import com.shbaek.webservice.domain.posts.PostsRepository;
import com.shbaek.webservice.dto.posts.PostsSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsServiceTest {

    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void dto데이터가_posts테이블에저장된다(){
        //arrange
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .author("asdf")
                .content("테스트")
                .title("타이틀")
                .build();

        //action
        postsService.save(dto);

        //assert
        Posts post = postsRepository.findAll().get(0);
        assertThat(post.getAuthor()).isEqualTo(dto.getAuthor());
        assertThat(post.getContent()).isEqualTo(dto.getContent());
        assertThat(post.getTitle()).isEqualTo(dto.getTitle());
    }
}
