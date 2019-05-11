package com.example.sarafan.controller;

import com.example.sarafan.DBConnection;
import com.example.sarafan.People;
import com.example.sarafan.exeptions.NotFoundExeption;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("rest/user")
public class MessageComtroller {
    private int counter = 7;

    private List<People> messages = new ArrayList<People>(){        {
        DBConnection connection = new DBConnection();
        connection.createConnection();
        List<People> people = new ArrayList<>();
        people = connection.getAllBuses();

        for(People p : people){
            add(p);

        }
//        add(new HashMap<String, String>(){{put("id", "2");put("text", "asdf");}});
//        add(new HashMap<String, String>(){{put("id", "3");put("text", "zxcv");}});
//        add(new HashMap<String, String>(){{put("id", "4");put("text", "vcz");}});
//        add(new HashMap<String, String>(){{put("id", "5");put("text", "fdsa");}});
//        add(new HashMap<String, String>(){{put("id", "6");put("text", "reqw");}});
    }};

   @GetMapping
    public List<People> list(){
       System.out.println(messages.get(0).getName());
       return messages;
   }

   @GetMapping("{id}")
    public People getOne(@PathVariable String id) {
       return getMessage(id);
   }

    private People getMessage(@PathVariable String id) {
        return messages.stream()
                .filter(message -> message.getId().equals(id))
                .findFirst()
                .orElseThrow(NotFoundExeption::new);
    }

    @PostMapping
    public People create(@RequestBody People message){
       message.setId(String.valueOf(counter++));
       messages.add(message);
       return message;
   }

   @PutMapping("{id}")
    public  People update(@PathVariable String id, @RequestBody People message){
       People messageFromDB = getMessage( id);
       messageFromDB = message;
       messageFromDB.setId(id);

       return messageFromDB;
   }

   @DeleteMapping("{id}")
    public void delete (@PathVariable String id){
       People message = getMessage(id);

       messages.remove(message);
   }
}
