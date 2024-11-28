package main.Application.MTCG.entity;

import java.util.UUID;

public class Card {

        private final String id;
        private String cardType;
        private String cardName;
        private int damage;
        private int coinCost;

        public Card() {
            this.id = UUID.randomUUID().toString();
        }

    public String getCardType() {

        return cardType;
    }

    public void setCardType(String cardType) {

            this.cardType = cardType;
    }

    public String getCardName() {

            return cardName;
    }

    public void setCardName(String cardName) {

            this.cardName = cardName;
    }

    public int getDamage() {

            return damage;
    }

    public void setDamage(int damage) {

            this.damage = damage;
    }

    public int getCoinCost() {

            return coinCost;
    }

    public void setCoinCost(int coinCost) {

            this.coinCost = coinCost;
    }
}
