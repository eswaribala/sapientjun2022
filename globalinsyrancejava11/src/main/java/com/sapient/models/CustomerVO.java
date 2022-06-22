package com.sapient.models;

import com.sapient.exceptions.PasswordException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerVO {
    private String userName;
    private String password;

    public void setUserName(String userName) {
        this.userName = userName;
    }
    //check business validations

    public void setPassword(String password) {

        String regex="^(?=.*[0-9])"
                   +"(?=.*[a-z])(?=.*[A-Z])"
                   +"(?=.*[@#$%^&+=])"
                   +"(?=\\S+$).{2,8}$";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher= pattern.matcher(password);
        if(matcher.find())
            this.password=password;
        else
            throw new PasswordException("Password not matching to required pattern");
    }
}
