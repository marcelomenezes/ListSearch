package xie.araca.listsearch.model;

import java.io.Serializable;

public class Item implements Serializable{
    public String name;


    public Item(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }

}
