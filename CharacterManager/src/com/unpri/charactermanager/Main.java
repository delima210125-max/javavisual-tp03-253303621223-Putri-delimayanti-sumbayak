package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.model.CharacterManager;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        System.out.println("===== CHARACTER MANAGER TP3 + TP5 =====");

        // =====================================
        // BAGIAN TP3 - DEMO KARAKTER
        // =====================================

        Character c1 = new Character("Aragorn", CharacterType.WARRIOR);
        Character c2 = new Character("Merlin", CharacterType.MAGE, 3);
        Character c3 = new Character("Legolas", CharacterType.ARCHER);

        System.out.println("\n--- TP3: Daftar Karakter ---");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        System.out.println("\n--- TP3: Demo Level Up ---");
        System.out.println("Sebelum: " + c1);
        c1.levelUp();
        System.out.println("Sesudah: " + c1);

        Character c4 = new Character("Luna", CharacterType.HEALER);
        c4.setMana(50);

        System.out.println("\n--- TP3: Pengujian Mana dan Status ---");
        System.out.println(c4);
        System.out.println("Mana Luna: " + c4.getMana());
        System.out.println("Apakah Luna masih hidup? " + c4.isAlive());

        // =====================================
        // BAGIAN TP5 - CHARACTER MANAGER
        // =====================================

        CharacterManager manager = new CharacterManager();

        System.out.println("\n===== TP5: CHARACTER MANAGER =====");

        // CREATE
        System.out.println("\n--- CREATE ---");

        System.out.println("Aragorn: " + manager.addCharacter(c1));
        System.out.println("Merlin: " + manager.addCharacter(c2));
        System.out.println("Legolas: " + manager.addCharacter(c3));
        System.out.println("Luna: " + manager.addCharacter(c4));

        // UJI DUPLIKAT
        System.out.println("\n--- UJI DUPLIKAT ---");

        Character duplicate = new Character("Aragorn", CharacterType.MAGE);

        System.out.println("Menambahkan Aragorn lagi: "
                + manager.addCharacter(duplicate));

        System.out.println("Total karakter: "
                + manager.getTotalCharacters());

        // UJI EQUALS
        System.out.println("\n--- UJI EQUALS ---");

        Character anotherAragorn =
                new Character("Aragorn", CharacterType.MAGE);

        System.out.println("Apakah dua Aragorn sama? "
                + c1.equals(anotherAragorn));

        System.out.println("Apakah objek Aragorn sama? "
                + (c1 == anotherAragorn));

        // UJI OBJECT REFERENCE
        System.out.println("\n--- UJI OBJECT REFERENCE ---");

        Character a = new Character("Aragorn", CharacterType.WARRIOR);
        Character b = a;

        b.setLevel(8);

        System.out.println("Level melalui a: " + a.getLevel());
        System.out.println("Apakah a dan b objek yang sama? " + (a == b));

        // READ
        System.out.println("\n--- READ: DAFTAR KARAKTER ---");

        for (Character character : manager.getAllCharacters()) {
            System.out.println(character);
        }

        // FIND BY NAME
        System.out.println("\n--- FIND BY NAME ---");

        Character found = manager.findByName("Merlin");

        System.out.println("Karakter ditemukan: " + found);

        // AVERAGE LEVEL
        System.out.println("\n--- AVERAGE LEVEL ---");

        System.out.println("Rata-rata level: "
                + manager.getAverageLevel());

        // FIND BY TYPE
        System.out.println("\n--- FIND BY TYPE: MAGE ---");

        ArrayList<Character> mages =
                manager.findByType(CharacterType.MAGE);

        for (Character mage : mages) {
            System.out.println(mage);
        }

        // FITUR MANDIRI: FIND STRONGEST
        System.out.println("\n--- KARAKTER TERKUAT ---");

        Character strongest = manager.findStrongest();

        System.out.println("Karakter terkuat: " + strongest);

        // UJI DEFENSIVE COPY
        System.out.println("\n--- UJI DEFENSIVE COPY ---");

        ArrayList<Character> salinan = manager.getAllCharacters();

        System.out.println("Jumlah karakter asli sebelum clear: "
                + manager.getTotalCharacters());

        salinan.clear();

        System.out.println("Jumlah dalam salinan setelah clear: "
                + salinan.size());

        System.out.println("Jumlah karakter asli setelah clear salinan: "
                + manager.getTotalCharacters());

        // DELETE
        System.out.println("\n--- DELETE ---");

        System.out.println("Hapus Legolas: "
                + manager.removeCharacter("Legolas"));

        System.out.println("Total karakter setelah dihapus: "
                + manager.getTotalCharacters());

        // UJI LIST KOSONG
        System.out.println("\n--- UJI DAFTAR KOSONG ---");

        CharacterManager managerKosong = new CharacterManager();

        System.out.println("Rata-rata level daftar kosong: "
                + managerKosong.getAverageLevel());

        // STATIC
        System.out.println("\n--- TOTAL KARAKTER DIBUAT ---");

        System.out.println("Total karakter berhasil ditambahkan: "
                + CharacterManager.getTotalCharacterCreated());

        System.out.println("\n===== PROGRAM SELESAI =====");
    }
}