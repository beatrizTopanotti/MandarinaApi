package com.ecommerce.Mandarinit.utils;

import java.util.ArrayList;
import java.util.List;

public class MandarinException extends Exception{
    private List<String> messageList = new ArrayList<>();

    public MandarinException(List<String> mensagens) {
        this.messageList = mensagens;
    }

    public MandarinException(String mensagem) {
        super(mensagem);
    }

    public List<String> getMessages() {
        if(messageList.isEmpty()){
            messageList.add(super.getMessage());
        }

        return messageList;
    }

    public String getMessage() {
        if(messageList.isEmpty()) {
            return super.getMessage();
        }
        return messageList.toString();
    }

}
