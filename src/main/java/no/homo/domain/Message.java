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
import no.homo.domain.User;

/**
 *
 * @author Loek
 */
public class Message {
    
    private String content;
    private User author;

    public Message(String content, User author) {
        this.content = content;
        this.author = author;
        DataBaas.getInstance().addMessage(this);
    }

    public String getContent() {
        return content;
    }

    public boolean setContent(String content) {
        if(content.length() <=  99){
            this.content = content;
            return true;
        }else{
            return false;
        }                
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
    
}
