
package com.unpri.charactermanager.model;

import java.util.ArrayList;

public class CharacterManager {

    // Menyimpan daftar karakter
    private ArrayList<Character> characters;

    // Menghitung jumlah karakter yang pernah dibuat
    private static int totalCharacterCreated = 0;

    // Constructor
    public CharacterManager() {
        characters = new ArrayList<>();
    }

    // Menambahkan karakter dan menolak nama duplikat
    public boolean addCharacter(Character character) {
        if (character == null || character.getName() == null
                || findByName(character.getName()) != null) {
            return false;
        }

        characters.add(character);
        totalCharacterCreated++;
        return true;
    }

    // Mencari karakter berdasarkan nama
    public Character findByName(String name) {
        if (name == null) {
            return null;
        }

        for (Character character : characters) {
            if (character.getName().equalsIgnoreCase(name)) {
                return character;
            }
        }
        return null;
    }

    // Menghapus karakter berdasarkan nama
    public boolean removeCharacter(String name) {
        Character character = findByName(name);

        if (character == null) {
            return false;
        }

        characters.remove(character);
        return true;
    }

    // Menghitung jumlah karakter saat ini
    public int getTotalCharacters() {
        return characters.size();
    }

    // Mengembalikan salinan daftar karakter
    public ArrayList<Character> getAllCharacters() {
        return new ArrayList<>(characters);
    }

    // Menghitung rata-rata level karakter
    public double getAverageLevel() {
        if (characters.isEmpty()) {
            return 0.0;
        }

        int totalLevel = 0;

        for (Character character : characters) {
            totalLevel += character.getLevel();
        }

        return (double) totalLevel / characters.size();
    }

    // Mencari semua karakter berdasarkan tipe
    public ArrayList<Character> findByType(CharacterType type) {
        ArrayList<Character> result = new ArrayList<>();

        for (Character character : characters) {
            if (character.getType() == type) {
                result.add(character);
            }
        }

        return result;
    }

    // Menghitung jumlah karakter yang pernah dibuat
    public static int getTotalCharacterCreated() {
        return totalCharacterCreated;
    }

    /**
     * Mencari karakter dengan nilai attack tertinggi.
     *
     * @return karakter dengan attack tertinggi,
     *         atau null jika daftar karakter kosong.
     */
    public Character findStrongest() {
        if (characters.isEmpty()) {
            return null;
        }

        Character strongest = characters.get(0);

        for (Character character : characters) {
            if (character.getAttack() > strongest.getAttack()) {
                strongest = character;
            }
        }

        return strongest;
    }
}
