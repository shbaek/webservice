package com.shbaek.webservice.domain;

import com.shbaek.webservice.domain.posts.Posts;
import com.shbaek.webservice.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시물저장_불러오기() {

        // arrange
        postsRepository.save(Posts.builder()
                .title("첫게시물")
                .content("첫 게시물 내용!!!")
                .author("shbaek")
                .build());

        // action
        List<Posts> postsList = postsRepository.findAll();


        // assert
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle(), is("첫게시물"));
        assertThat(posts.getContent(), is("첫 게시물 내용!!!"));

    }

    @Test
    public void BaseTimeEntity_등록(){

        // arrange
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder()
                .title("테스트 게시물")
                .content("테스트 게스글")
                .author("shbaek@google.com")
                .build());

        // action
        List<Posts> postsList = postsRepository.findAll();


        // assert
        Posts posts = postsList.get(0);
        assertTrue(posts.getCreateDate().isAfter(now));
        assertTrue(posts.getUpdateDate().isAfter(now));

    }
}
