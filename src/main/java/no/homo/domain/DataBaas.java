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
import javax.inject.Singleton;

/**
 *
 * @author Loek
 */
@Singleton
public class DataBaas {

    private List<User> users;
    private List<Message> messages;
    private static DataBaas instance = null;

    protected DataBaas() {
        // Exists only to defeat instantiation.
    }

    public static DataBaas getInstance() {
        if (instance == null) {
            instance = new DataBaas();
        }
        return instance;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public boolean addUser(User u) {
        if (!this.users.contains(u)) {
            this.users.add(u);
            return true;
        } else {
            return false;
        }
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    
    public boolean addMessage(Message m) {
        if (!this.messages.contains(m)) {
            this.messages.add(m);
            return true;
        } else {
            return false;
        }
    }
}
