package com.tianyi.hermeseventbus;


import com.tianyi.hermeseventbus.annotion.ClassId;

/**
 * Created by Xiaofei on 16/4/25.
 */

@ClassId("com.tianyi.hermeseventbus.UserManager")
public class UserManager implements IUserManager {
    Person person;
    private static UserManager sInstance = null;

    private UserManager() {

    }
//约定这个进程A  单例对象的     规则    getInstance()
    public static synchronized UserManager getInstance() {
        if (sInstance == null) {
            sInstance = new UserManager();
        }
        return sInstance;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
