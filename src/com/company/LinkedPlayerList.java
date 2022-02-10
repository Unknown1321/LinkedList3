package com.company;

public class LinkedPlayerList {
    private Node front;

    public LinkedPlayerList(){
        front = null;
    }
    public void add(FootballPlayer data){
        if (front == null){
            front = new Node(data);
        } else {
            Node current = front;
            while (current.next != null){
                current = current.next;
            }
            current.next = new Node(data);
        }
    }
    public int indexOf(FootballPlayer value){
        int index = 0;
        Node current = front;
        while (current != null){
            if (current.data == value){
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }
    public void add(FootballPlayer data, int index){
        if(index == 0){
            front = new Node(data, null);
        } else {
            Node current = nodeAt(- 1);
            current.next = new Node(data, current.next);
        }
    }
    public Node nodeAt(int index){
        Node current = front;
        for (int i = 0; i < index; i++)
            current = current.next;

        return current;
    }
    public void remove(int index){
        if (index == 0){
            front = front.next;
        } else {
            Node current = nodeAt(-1);
            current.next = current.next.next;
        }
    }
    public int size(){
        int count = 0;
        Node current = front;
        while (current != null){
            current = current.next;
            count++;
        }
        return count;
    }
    public FootballPlayer search(String data, LinkedPlayerList playerList){
        for (int i = 0; i <playerList.size(); i++) {
            if (playerList.get(i).getFirstName().equalsIgnoreCase(data)){
                return playerList.get(i);
            }
        } return null;
    }
    public FootballPlayer get(int index){
        return nodeAt(index).data;
    }
}
