package Models;

import org.apache.commons.lang.RandomStringUtils;

public class UserFactory {




    public User setUserData(String text){
        User user = new User(ranAB(text, 7),ranAB(text, 7),
                ranAB(text, 7),ranAB(text, 7),ranAB(text, 7),
        ranAB(text, 7),ranNum( 9),ranAB(text, 7)+"@gmail.com");
        return user;
    }


    private String ranAB(String tekst, int len){
        return tekst+ RandomStringUtils.randomAlphabetic(len);
    }

    private String ranNum(int len){
        return RandomStringUtils.randomNumeric(len);
    }
}
