package com.dkk.rxjava.samplerxjava.ui.interactor;

import android.text.TextUtils;

import com.dkk.rxjava.samplerxjava.models.User;
import com.dkk.rxjava.samplerxjava.models.dbmodels.DBUser;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * Created by deepak on 3/3/17.
 * Login Interactor implementation unit testing
 */

@RunWith(MockitoJUnitRunner.class)
public class LoginInteractorImplTestTest {

    @Mock
    LoginInteractor.LoginFinishedListener loginFinishedListener;

    @Mock
    DBUser user;

    private LoginInteractorImpl loginInteractor;
    @Before
    public void setUp() throws Exception {
        loginInteractor = new LoginInteractorImpl();
    }

    @Test
    public  void testIsValidUser() throws Exception {
        Class cls = Class.forName(LoginInteractorImpl.class.getName());
        Method method = cls.getDeclaredMethod("isValidData",new Class[]{User.class, LoginInteractor.LoginFinishedListener.class});
        method.setAccessible(true);
        Object object = cls.newInstance();
        User dbUser = new User();
        Boolean result = (Boolean) method.invoke(object,dbUser,loginFinishedListener);
        assertEquals(result,new Boolean(false));

    }
}