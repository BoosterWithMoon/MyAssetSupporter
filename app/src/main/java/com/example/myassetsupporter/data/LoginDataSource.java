package com.example.myassetsupporter.data;

import android.widget.Toast;

import com.example.myassetsupporter.data.model.LoggedInUser;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {

        /*try {
            // TODO: handle loggedInUser authentication
            //LoggedInUser fakeUser = new LoggedInUser(java.util.UUID.randomUUID().toString(),"Jane Doe");
            if(username=="admin" && password=="123456"){
                //LoggedInUser user = new LoggedInUser(java.util.UUID.randomUUID().toString(), "Daniel Kim");

            }
            return new Result.Success<>(user);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
        */
        if(username=="admin" && password=="123456"){
            LoggedInUser user = new LoggedInUser(java.util.UUID.randomUUID().toString(), "Daniel Kim");
            return new Result.Success<>(user);
        }else{
            return new Result.Error(new IOException());
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}
