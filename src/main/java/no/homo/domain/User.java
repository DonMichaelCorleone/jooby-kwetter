/*
 * Copyright 2017 Loek.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package no.homo.domain;

import java.util.List;

/**
 *
 * @author Loek
 */
public class User {

    private String userName;
    private String password;
    private List<User> following;

    public User(String userName, String password, List<User> following) {
        this.userName = userName;
        this.password = password;
        this.following = following;
        DataBaas.getInstance().addUser(this);
        
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<User> getFollowing() {
        return following;
    }

    public void setFollowing(List<User> following) {
        this.following = following;
    }

    /*
    return false if user already exist in the following list and removes user
    return true if user is added to the followers
    */
    public boolean updateFollowing(User user) {
        if (following.contains(user)) {
            following.remove(user);
            return false;
        } else {
            following.add(user);
            return true;
        }
    }

}
