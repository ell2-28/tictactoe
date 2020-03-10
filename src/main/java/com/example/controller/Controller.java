package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class Controller {
    private ArrayList <String> names = new ArrayList<>();
    public static int [][] field = new int[3][3];

    @RequestMapping(value = "/sendName", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public NameDto sendName(@RequestBody NameDto dto) {
        names.add(dto.name);
        return dto;
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
    public String sendCell(@RequestBody CellDto dto) {
        if (dto.name.equals(names.get(0))) {
            field[dto.x][dto.y] = 0; // нолик
            return "Cell 0 set";
        }
        else if (dto.name.equals(names.get(1))) {
            field[dto.x][dto.y] = 1; // крестик
            return "Cell X set";
        }
        else return "error";
    }


}
