package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class Controller {
    private ArrayList <String> names = new ArrayList<>();
    private int [][] field = new int[3][3];

    @RequestMapping(value = "/sendName", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String sendName(@RequestBody String name) {
        names.add(name);
        return "Name sent";
    }

    @GetMapping(value = "/getNames")
    public ArrayList<String> getNames() {
        for (int i = 0; i < names.size(); i++) {
            System.out.println(i);
        }
        return names;
    }

    @RequestMapping(value = "/sendCell", method = RequestMethod.POST, consumes = {"application/json ; charset=utf-8"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String sendCell(@RequestBody String name, Integer x, Integer y) {
        if (name.equals(names.get(0))) {
            field[x][y] = 0; // нолик
            return "Cell set";
        }
        else if (name.equals(names.get(1))) {
            field[x][y] = 1; // крестик
            return "Cell set";
        }
        else return "error";
    }


}
