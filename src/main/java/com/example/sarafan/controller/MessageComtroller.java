package com.example.sarafan.controller;

import com.example.sarafan.DBConnection;
import com.example.sarafan.exeptions.NotFoundExeption;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("rest/user")
public class MessageComtroller {
    private int counter = 7;

    private List<Map<String, String>> messages = new ArrayList<Map<String, String>>(){        {
        DBConnection connection = new DBConnection();
        connection.createConnection();





        add(new HashMap<String, String>(){{put("id", "1");put("text", "qwer");}});
        add(new HashMap<String, String>(){{put("id", "2");put("text", "asdf");}});
        add(new HashMap<String, String>(){{put("id", "3");put("text", "zxcv");}});
        add(new HashMap<String, String>(){{put("id", "4");put("text", "vcz");}});
        add(new HashMap<String, String>(){{put("id", "5");put("text", "fdsa");}});
        add(new HashMap<String, String>(){{put("id", "6");put("text", "reqw");}});
    }};

   @GetMapping
    public List<Map<String, String>> list(){
       return messages;
   }

   @GetMapping("{id}")
    public Map<String, String> getOne(@PathVariable String id) {
       return getMessage(id);
   }

    private Map<String, String> getMessage(@PathVariable String id) {
        return messages.stream()
                .filter(message -> message.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundExeption::new);
    }

    @PostMapping
    public Map<String, String> create(@RequestBody Map<String, String> message){
       message.put("id", String.valueOf(counter++));
       messages.add(message);
       return message;
   }

   @PutMapping("{id}")
    public  Map<String, String> update(@PathVariable String id, @RequestBody Map<String, String> message){
       Map<String, String> messageFromDB = getMessage( id);
       messageFromDB.putAll(message);
       messageFromDB.put("id", id);

       return messageFromDB;
   }

   @DeleteMapping("{id}")
    public void delete (@PathVariable String id){
       Map<String,String> message = getMessage(id);

       messages.remove(message);
   }
}
