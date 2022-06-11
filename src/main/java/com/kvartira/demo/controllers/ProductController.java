package com.kvartira.demo.controllers;

import com.kvartira.demo.models.Product;
import com.kvartira.demo.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/AddBoard")
    public String OrderingMain(Model model) {
        Iterable<Product> products = productRepository.findAll();
        model.addAttribute("adverts",products);
        return "AddBoard";
    }

    @GetMapping("/newAdd")
    public String newAdd(Model model) {
        return "newAdd";
    }

    @GetMapping("/newAddDone")
    public String newAddDone(Model model) {
        return "newAddDone";
    }

    @PostMapping ("/newAdd")
    public String newAddPost(@RequestParam String title,@RequestParam int price ,Model model) {
        Product advert = new Product(title,price);
        productRepository.save(advert);
        return "redirect:/newAddDone";
    }

    @GetMapping("/AddBoard/{id}")
    public String addDetails(@PathVariable(value="id") long id,Model model) {
        Optional<Product> advert = productRepository.findById(id);
        ArrayList<Product> res =new ArrayList();
        advert.ifPresent(res::add);
        model.addAttribute("advert",res);


        return "addDetails";
    }

    @GetMapping("/AddBoard/{id}/edit")
    public String addEdit(@PathVariable(value="id") long id,Model model) {
        Optional<Product> advert = productRepository.findById(id);
        ArrayList<Product> res =new ArrayList();
        advert.ifPresent(res::add);
        model.addAttribute("advert",res);

        return "addEdit";
    }

    @PostMapping ("/AddBoard{id}/edit")
    public String newAddUpdate(@PathVariable(value="id") long id,@RequestParam String title,@RequestParam int price ,Model model) {
        Product advert = productRepository.findById(id).orElseThrow();
        advert.setName(title);
        advert.setPrice(price);
        productRepository.save(advert);

        return "redirect:/newAddDone";
    }

    @PostMapping ("/AddBoard/{id}/remove")
    public String newAddDelete(@PathVariable(value="id") long id,Model model) {
        Product advert = productRepository.findById(id).orElseThrow();
        productRepository.delete(advert);



        return "redirect:/newAddDone";
    }











}
