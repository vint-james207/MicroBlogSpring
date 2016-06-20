package com.james;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by jamesyburr on 6/20/16.
 */

@Controller
public class MicroBlogController {

    ArrayList<Message> messages;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session, String username) {
    String user = (String) session.getAttribute("username");
    model.addAttribute("username", user);
        return "";
    }
}
