package com.ankit.controller;

import com.ankit.domain.Message;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ankit07 on 8/28/16.
 */
@RestController
public class MessageController {

    @RequestMapping("/hello/{player}")
    public Message message(@PathVariable String player){
        Message mgs = new Message(player,"HELLO " + player);
        return mgs;
    }
}
