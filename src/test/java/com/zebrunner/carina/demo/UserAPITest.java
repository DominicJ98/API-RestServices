package com.zebrunner.carina.demo;

import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.demo.api.DeleteUserMethod;
import com.zebrunner.carina.demo.api.GetUserMethods;
import com.zebrunner.carina.demo.api.PostUserMethod;
import com.zebrunner.carina.demo.api.PutUserMethod;
import org.testng.annotations.Test;

public class UserAPITest {

    @Test
    public void testCreateUser() {
        PostUserMethod postUser = new PostUserMethod();
        postUser.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        postUser.callAPI();
        postUser.validateResponse();
    }

    @Test
    public void testGetAllUsers() {
        GetUserMethods getAllUsers = new GetUserMethods();
        getAllUsers.expectResponseStatus(HttpResponseStatusType.OK_200);
        getAllUsers.callAPI();
        getAllUsers.validateResponse();
    }

    @Test
    public void testGetSpecificUser() {
        GetUserMethods getSpecificUser = new GetUserMethods("2");
        getSpecificUser.expectResponseStatus(HttpResponseStatusType.OK_200);
        getSpecificUser.callAPI();
        getSpecificUser.validateResponse();
    }

    @Test
    public void testUpdateUser() {
        PutUserMethod updateUser = new PutUserMethod("2");
        updateUser.expectResponseStatus(HttpResponseStatusType.OK_200);
        updateUser.callAPI();
        updateUser.validateResponse();
    }

    @Test
    public void testDeleteUser() {
        DeleteUserMethod deleteUser = new DeleteUserMethod("2");
        deleteUser.expectResponseStatus(HttpResponseStatusType.NO_CONTENT_204);
        deleteUser.callAPI();
    }
}
