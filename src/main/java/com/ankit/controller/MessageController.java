package com.ankit.controller;

import com.ankit.domain.Message;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by ankit07 on 8/28/16.
 */
@RestController
public class MessageController {

    private static final Logger log = Logger.getLogger(MessageController.class);

    @RequestMapping("/hello/{player}")
    public Message message(@PathVariable String player){
        Message mgs = new Message(player,"HELLO " + player);
        log.info("-- Send Hello message to " + player);

        return mgs;
    }
}
