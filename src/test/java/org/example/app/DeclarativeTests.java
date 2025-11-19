package org.example.app;


import com.zebrunner.carina.core.IAbstractTest;
import org.testng.annotations.Test;

public class DeclarativeTests implements IAbstractTest {

    @Test
    public void testGetPost() {
        GetUserMethods getPost = new GetUserMethods();
        getPost.callAPIExpectSuccess();
        getPost.validateResponse();
    }

    @Test
    public void testCreatePost() {
        PostUserMethod postPost = new PostUserMethod();
        postPost.callAPIExpectSuccess();
        postPost.validateResponse();
    }

    @Test
    public void testUpdatePost() {
        PutUserMethod putPost = new PutUserMethod();
        putPost.callAPIExpectSuccess();
        putPost.validateResponse();
    }

    @Test
    public void testDeletePost() {
        DeleteUserMethod deletePost = new DeleteUserMethod();
        deletePost.callAPIExpectSuccess();
        deletePost.validateResponse();
    }

    @Test
    public void testGetInvalidPost() {
        GetInvalidUserMethod getInvalidPost = new GetInvalidUserMethod();
        getInvalidPost.callAPIExpectSuccess();
        getInvalidPost.validateResponse();
    }










}
