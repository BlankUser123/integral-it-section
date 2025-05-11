package com.k1ts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/introduce")
@RestController
public class IntroduceYourselfController {

    @GetMapping("/yourself")
    public String introduceYourself() {
        return "Hello, my name is Rostyslav Bykov, I am 29 years olf, from Odesa, Ukraine";
    }

    @GetMapping("/listFriends")
    public String listFriends() {
        List<String> friends = new ArrayList<>();

        friends.add("Коля Степанов");
        friends.add("Даниил");
        friends.add("Егор Жмуров");
        friends.add("Катя Третьякова");
        friends.add("Вадим");

        return String.join("\n", friends);
    }

    @GetMapping("/getVowelsCountFromWord")
    public String getVowels(@RequestParam(name = "word") String word) {
        char[] vowels = {'a', 'o', 'u', 'y', 'e', 'i'};

        int count = 0;

        for (char c : word.toCharArray()) {
            for (char vowel : vowels) {
                if (c == vowel) {
                    count++;
                }
            }
        }

        return "Number of vowels in word '" + word + "' is: " + count;
    }
}
