
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainWindow extends JFrame {

    public MainWindow(List<Character> characters) {

        setTitle("Character Manager - TP8 AP10");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 400);
        setLocationRelativeTo(null);

        // Panel utama
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        // Judul
        JLabel title = new JLabel(
            "DAFTAR KARAKTER",
            SwingConstants.CENTER
        );
        title.setFont(new Font("Arial", Font.BOLD, 22));

        // Panel daftar karakter
        JPanel listPanel = new JPanel();
        listPanel.setLayout(
            new BoxLayout(listPanel, BoxLayout.Y_AXIS)
        );

        int totalLevel = 0;

        // Menampilkan karakter secara dinamis
        for (Character c : characters) {

            JLabel label = new JLabel(
                c.getName()
                + " | Tipe: " + c.getType()
                + " | Level: " + c.getLevel()
            );

            label.setFont(new Font("Arial", Font.PLAIN, 15));
            label.setBorder(
                BorderFactory.createEmptyBorder(8, 5, 8, 5)
            );

            listPanel.add(label);

            totalLevel += c.getLevel();
        }

        // Menghitung rata-rata level
        double average = characters.isEmpty()
            ? 0
            : (double) totalLevel / characters.size();

        // Statistik karakter
        JLabel statistics = new JLabel(
            String.format(
                "Total: %d karakter | Rata-rata level: %.2f",
                characters.size(), average
            ),
            SwingConstants.CENTER
        );

        statistics.setFont(
            new Font("Arial", Font.BOLD, 14)
        );

        // Menyusun tampilan
        mainPanel.add(title, BorderLayout.NORTH);
        mainPanel.add(
            new JScrollPane(listPanel),
            BorderLayout.CENTER
        );
        mainPanel.add(statistics, BorderLayout.SOUTH);

        setContentPane(mainPanel);
    }
}
