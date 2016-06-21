package com.james;

import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    UserRepository users;

    @Autowired
    MessageRepository messages;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "login";
        }
        else {
            Iterable<Message> msg = messages.findAll();
            model.addAttribute("messages", msg);
            return "home";
        }
    }
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(String username, String password, HttpSession session) throws Exception {
        User user = users.findByName(username);
        if (user == null) {
            user = new User(username, password);
            users.save(user);
        }
        else if (!user.password.equals(password)) {
            throw new Exception("Incorrect password!!");
        }
        session.setAttribute("username", username);
        return "redirect:/";
    }

    @RequestMapping(path = "/addmessage", method = RequestMethod.POST)
    public String addMessage(String text) {
        Message message = new Message(text);
        messages.save(message);
        return "redirect:/";
    }

    @RequestMapping(path = "/editmessage", method = RequestMethod.POST)
    public String editMessage(Integer id, String text) {
        Message message = new Message(id, text);
        messages.save(message);
        return "redirect:/";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping(path = "/deletemessage", method = RequestMethod.POST)
    public String delete(Integer id) {
        messages.delete(id);
        return "redirect:/";
    }
}
