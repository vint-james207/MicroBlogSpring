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

    ArrayList<Message> messages = new ArrayList<>();

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        String username = (String) session.getAttribute("username");
        model.addAttribute("messages", messages);
        model.addAttribute("username", username);
        return "home";
    }
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(String username, HttpSession session) {
        session.setAttribute("username", username);
        return "redirect:/";
    }

    @RequestMapping(path = "/addmessage", method = RequestMethod.POST)
    public String addMessage(String text) {
        Message message = new Message((messages.size()+1), text);
        messages.add(message);
        return "redirect:/";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping(path = "/deletemessage", method = RequestMethod.POST)
    public String delete(Integer id) {
        messages.remove(id-1);
        return "redirect:/";
    }
}
