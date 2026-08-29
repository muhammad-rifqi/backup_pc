package com.djmapi.djmapi.controller;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @GetMapping("/list")
    public List<List<String>> getMenu() {
        List<List<String>> menu = new ArrayList<>();

        menu.add(Arrays.asList("Dashboard"));
        menu.add(Arrays.asList("Master", "User", "Role"));
        menu.add(Arrays.asList("Laporan", "Harian", "Bulanan"));

        return menu;

    }
}
