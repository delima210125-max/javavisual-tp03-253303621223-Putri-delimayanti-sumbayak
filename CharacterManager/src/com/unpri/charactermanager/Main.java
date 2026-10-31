
package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

public class Main {

    public static void main(String[] args) {

        System.out.println("===== CHARACTER MANAGER =====");

        // Membuat tiga karakter
        Character c1 = new Character("Aragorn", CharacterType.WARRIOR);
        Character c2 = new Character("Merlin", CharacterType.MAGE, 3);
        Character c3 = new Character("Legolas", CharacterType.ARCHER);

        // Menampilkan tiga karakter
        System.out.println("\n--- Daftar Karakter ---");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        // Demo level up
        System.out.println("\n--- Demo Level Up ---");
        System.out.println("Sebelum: " + c1);

        c1.levelUp();

        System.out.println("Sesudah: " + c1);

        // Mini-Challenge: menguji mana dan isAlive()
        System.out.println("\n--- Pengujian Mana dan Status Karakter ---");

        Character c4 = new Character("Luna", CharacterType.HEALER);

        c4.setMana(50);

        System.out.println(c4);
        System.out.println("Mana Luna: " + c4.getMana());
        System.out.println("Apakah Luna masih hidup? " + c4.isAlive());

    }
}
