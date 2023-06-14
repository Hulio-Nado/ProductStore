package com.example.demo.controllers;

import com.example.demo.fromViews.CreateGood;
import com.example.demo.models.Goods;
import com.example.demo.services.GoodsJDBCService;
import com.example.demo.services.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class GoodsController {
    GoodsService goodsService;
    @Autowired
    GoodsJDBCService goodsJDBCService;

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
        Goods good = null;
        try {
            good = goodsService.findById(id).get();
        }catch (NoSuchElementException t){
            System.out.println("invalid id");
            return "redirect:/all";
        }
        model.addAttribute("create", good);
        return "views/formupdate";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute Goods good){
        Goods goodToBeUpdated = goodsService.findById(good.getId()).get();

        goodToBeUpdated.setName(good.getName());
        goodToBeUpdated.setPrice(good.getPrice());

        goodsService.save(goodToBeUpdated);

        return "redirect:/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteOneGood(Model model, @PathVariable int id){
        Goods good = null;
        try {
            good = goodsService.findById(id).get();
        }catch (NoSuchElementException t){
            System.out.println("invalid id");
            return "redirect:/all";
        }
        goodsService.delete(good);
        return "redirect:/all";
    }

    @GetMapping("/all2")
    public String getAll(Model model){
        var goods = goodsJDBCService.getAll();
        model.addAttribute("all", goods);
        return "views/all2";
    }

    @ResponseBody
    @GetMapping("/all2/{id}")
    public String getbyId(Model model, @PathVariable int id){
        var goods = goodsJDBCService.getById(id);
        model.addAttribute("one", goods);
        return goods.toString();
    }

}
