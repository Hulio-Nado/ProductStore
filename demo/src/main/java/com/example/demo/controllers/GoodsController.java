package com.example.demo.controllers;

import com.example.demo.fromViews.CreateGood;
import com.example.demo.models.Goods;
import com.example.demo.services.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class GoodsController {
    GoodsService goodsService;

    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @GetMapping("/all")
    public String showAllGoods(Model model){
        var list = goodsService.findAll();
        model.addAttribute("all", list);
        return "views/all";
    }

    @GetMapping("/create")
    public String createOneGood(Model model){
        CreateGood createGood = new CreateGood();
        model.addAttribute("create", createGood);
        return "views/form";
    }

    @PostMapping("/create")
    public String createGood(Model model, @ModelAttribute CreateGood createGood){
        goodsService.save(new Goods(createGood));
        return "redirect:/all";
    }

    @GetMapping("/update/{id}")
    public String updateOneGood(Model model, @PathVariable int id){
        var good = goodsService.findById(id).get();
        model.addAttribute("create", good);
        return "views/formupdate";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute CreateGood createGood){
        Optional<Goods> good = goodsService.findById(createGood.getId());


        return "redirect:/all";
    }
}
