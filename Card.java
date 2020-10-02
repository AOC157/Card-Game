package com.company;

public class Card {
    public char type;
    public int number;

    public Card(char type, int number) {
        this.type = type;
        this.number = number;
    }

    public boolean isBigger(Card card, char kingCard) {
        if(type == card.type){
            return number > card.number;
        }
        return card.type != kingCard;
    }

    public String convertCardToString() {
        return (number + "" + type);
    }
}
