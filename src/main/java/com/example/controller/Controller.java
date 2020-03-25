package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

// Доработки:
// 1. юнит тест
// 2. интеграционный(апи) тест с примером партии
// 3. доработать чтобы можно было сыграть ещё раз без перезапуска сервера
// *4. доработать чтобы параллельно могли идти несколько партий
@RestController
public class Controller {
    private ArrayList <String> names = new ArrayList<>();
    public static int [][] field = new int[3][3]; // игровое поле не должно быть статическим

    @RequestMapping(value = "/sendName", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK) // это лишнее
    @ResponseBody // это лишнее
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
    @ResponseStatus(HttpStatus.OK) // это лишнее
    @ResponseBody // это лишнее
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
