package com.abhay.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.abhay.app.model.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class HeaderController
{

    @PostMapping("/send/data")
    public ResponseEntity sendData(@RequestBody List<Data> datas , @RequestHeader String sessionId){

        if(sessionId == null){
            return  new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
       datas.forEach(data -> System.out.println("Received the message"+data.toString()));
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("/data")
        public List<Data> getData(@RequestHeader String getId){
            if(getId == null){
                return null;
            }

            Data data1 = new Data("1","First id");
            Data data2 = new Data("2","Second id");
            List<Data> datas =  Arrays.asList(data1,data2);
            datas.addAll(datas);

            return datas;

        }
}

