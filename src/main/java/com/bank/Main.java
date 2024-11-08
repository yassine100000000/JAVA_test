package com.bank;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Banque banque = new Banque("12321", "maroc");
        Client client1 = new Client("1", "Yassine", "HAMDIS", "marrakech", "12345", "hamdisyassine57@gmail.com");
        Client client2 = new Client("2", "Yassine", "HAMDIS", "marrakech", "12345", "hamdisyassine57@gmail.com");
        Date instant = new Date();
        
        client1.addCompte("43214", "mad", instant , instant, banque);
        client2.addCompte("3r343", "mad", instant , instant, banque);
        List<Compte> comptes = new ArrayList<>();
        comptes.add(client2.comptes.get(0));
        client1.comptes.get(0).AddTransaction("dfadsf", "dafd", comptes );

        System.out.println(client1.toJson());
        System.out.println(banque.toJson());



    }
}