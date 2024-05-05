package com.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
public class GoalController {

  private static final String VIEW_NAME = "index";
  private static final String GOAL_NAME = "goal";

  @GetMapping(value = {"", "/"})
  public String index(Model model, HttpServletRequest request) {
    Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
    if (inputFlashMap != null) {
      model.addAttribute(GOAL_NAME, inputFlashMap.get(GOAL_NAME));
    } else {
      model.addAttribute(GOAL_NAME, "Learn Docker!");
    }
    return VIEW_NAME;
  }

  @PostMapping(value = {"/store-goal"})
  public String addGoal(@RequestParam(name = "goal") String goal,
      RedirectAttributes redirectAttributes) {
    redirectAttributes.addFlashAttribute(GOAL_NAME, goal);
    return "redirect:/";
  }
}
