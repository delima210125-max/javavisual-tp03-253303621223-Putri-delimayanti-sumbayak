
package com.unpri.charactermanager.model;

public class Character {

    // Atribut karakter
    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attack;
    private int mana;

    // Constructor pertama
    public Character(String name, CharacterType type) {
        this.name = name;
        this.type = type;
        this.level = 1;
        this.mana = 0;
        updateStats();
    }

    // Constructor kedua
    public Character(String name, CharacterType type, int level) {
        this.name = name;
        this.type = type;
        this.mana = 0;
        setLevel(level);
    }

    // Menghitung HP dan attack berdasarkan level
    private void updateStats() {
        this.hitPoints = 100 + (level * 10);
        this.attack = 10 + (level * 5);
    }

    // Getter dan setter name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter dan setter type
    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {
        this.type = type;
    }

    // Getter dan setter level
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException("Level harus minimal 1");
        }

        this.level = level;
        updateStats();
    }

    // Getter dan setter hitPoints
    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    // Getter dan setter attack
    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    // Getter mana
    public int getMana() {
        return mana;
    }

    // Setter mana dengan validasi
    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException(
                "Mana tidak boleh negatif"
            );
        }

        this.mana = mana;
    }

    // Memeriksa apakah karakter masih hidup
    public boolean isAlive() {
        return hitPoints > 0;
    }

    // Menaikkan level
    public void levelUp() {
        setLevel(level + 1);
    }

    // Menampilkan informasi karakter
    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", level=" + level +
                ", hitPoints=" + hitPoints +
                ", attack=" + attack +
                ", mana=" + mana +
                '}';
    }
}
