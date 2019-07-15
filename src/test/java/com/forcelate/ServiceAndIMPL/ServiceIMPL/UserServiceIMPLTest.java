package com.forcelate.ServiceAndIMPL.ServiceIMPL;

import com.forcelate.DTO.ArticleDTO;
import com.forcelate.DTO.UserDTO;
import com.forcelate.ServiceAndIMPL.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceIMPLTest {

    @Mock
    private UserDTO user;

    @Mock
    private ArticleDTO article;

    @InjectMocks
    private UserService userService = new UserServiceIMPL();

    @Before
    public void initializeMockito(){
        MockitoAnnotations.initMocks(this);
    }



    @Test
    public void saveUser() {
        UserDTO user = new UserDTO("Name", 24);

        Assert.assertEquals(24, user.getAge());
        assertEquals("Name", user.getName());
    }


    @Test
    public void getAllUsers() {


    }

    @Test
    public void getAllUsersWhereAgeMore() {
    }

}