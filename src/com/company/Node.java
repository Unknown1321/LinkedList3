package com.company;

public class Node {
    public FootballPlayer data;
    public Node next;

    public Node(){
        this(null, null);
    }
    public Node(FootballPlayer data){
        this(data, null);
    }
    public Node(FootballPlayer data, Node next){
        this.data = data;
        this.next = next;
    }
}
