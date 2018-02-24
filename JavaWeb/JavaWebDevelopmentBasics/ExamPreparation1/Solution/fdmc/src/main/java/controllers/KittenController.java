package controllers;

import bindingModels.KittenAddBindingModel;
import entities.Kitten;
import org.softuni.broccolina.solet.HttpSoletRequest;
import org.softuni.summer.api.*;
import repositories.KittenRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Controller
public class KittenController {
    private KittenRepository kittenRepository;

    public KittenController() {
        this.kittenRepository = new KittenRepository();
    }

    @GetMapping(route = "/kittens/all")
    @PreAuthorize(loggedIn = true)
    public String allKittens(Model model) {
        Kitten[] allKittens = this.kittenRepository.getAllKittens();
        StringBuilder result = new StringBuilder();

        for (Kitten kitten : allKittens) {
            result.append(kitten.toString());
        }

        model.addAttribute("allKittens", result);
        return "template:/kittenAll";
    }

    @GetMapping(route = "/kittens/add")
    @PreAuthorize(loggedIn = true)
    public String addKitten() {
        return "template:kittenAdd";
    }

    @PostMapping(route = "/kittens/add")
    @PreAuthorize(loggedIn = true)
    public String addKittenConfirm(KittenAddBindingModel bindingModel) {
        String kittenBreed = bindingModel.getBreed();
        Set<String> allowedBreeds = new HashSet<>(Arrays.asList("Street Transcended", "American Shorthair", "Munchkin", "Siamese"));

        if (!allowedBreeds.contains(kittenBreed)) {
            return "redirect:/kittens/add";
        }

        Kitten kitten = new Kitten();
        kitten.setName(bindingModel.getName());
        kitten.setAge(bindingModel.getAge());
        kitten.setBreed(bindingModel.getBreed());

        this.kittenRepository.createKitten(kitten);
        return "redirect:/kittens/all";
    }
}