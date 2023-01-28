package com.abhay.app.model;


import org.springframework.stereotype.Component;

@Component
public class Data {
    String id;
    String message;

   public Data(String id,String message){
       this.id = id;
       this.message = message;
   }

   public String getId(){
       return id;
   }
   public void setId(String id){
       this.id = id;
   }
    public String getmessage(){
        return message;
    }
    public void setMessage(String message){
        this.message= message;
    }

    @Override
    public String toString(){
        return "Data [id = "+id+", message = "+message+ "]";
    }
}
