
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainWindow extends JFrame {

    // Konstanta batas level tinggi
    private static final int HIGH_LEVEL_THRESHOLD = 5;

    public MainWindow(List<Character> characters) {

        setTitle("Character Manager - TP10 AP13");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel utama
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBackground(AppTheme.BACKGROUND);
        mainPanel.setBorder(AppTheme.MAIN_BORDER);

        // Judul aplikasi
        JLabel title = new JLabel(
                "CHARACTER MANAGER",
                SwingConstants.CENTER
        );

        title.setFont(AppTheme.TITLE_FONT);
        title.setForeground(AppTheme.TEXT);

        // Panel daftar karakter
        JPanel listPanel = new JPanel();
        listPanel.setLayout(
                new BoxLayout(listPanel, BoxLayout.Y_AXIS)
        );
        listPanel.setBackground(AppTheme.BACKGROUND);

        int totalLevel = 0;

        // Menampilkan karakter secara dinamis
        for (Character c : characters) {

            // Kartu karakter
            JPanel card = new JPanel(new BorderLayout(10, 5));

            card.setBackground(AppTheme.colorFor(c.getType()));
            card.setOpaque(true);
            card.setBorder(AppTheme.CARD_BORDER);

            // Properti tambahan: kursor tangan
            card.setCursor(new Cursor(Cursor.HAND_CURSOR));

            // Nama dan role
            JLabel nameLabel = new JLabel(
                    c.getName() + " | " + c.getType()
            );

            nameLabel.setFont(AppTheme.BODY_FONT);
            nameLabel.setForeground(AppTheme.TEXT);

            // Level karakter
            JLabel levelLabel = new JLabel(
                    "Level: " + c.getLevel()
            );

            levelLabel.setFont(AppTheme.BODY_FONT);
            levelLabel.setForeground(AppTheme.MUTED);

            // Mini-Challenge: level 5 ke atas berwarna emas dan tebal
            if (c.getLevel() >= HIGH_LEVEL_THRESHOLD) {
                levelLabel.setFont(AppTheme.HIGHLIGHT_FONT);
                levelLabel.setForeground(AppTheme.GOLD);
            }

            // Properti tambahan: Tooltip
            card.setToolTipText(
                    "Nama: " + c.getName()
                    + " | Role: " + c.getType()
                    + " | Level: " + c.getLevel()
            );

            // Status aktif/nonaktif
            // Karakter level 1 dibuat nonaktif
            card.setEnabled(c.getLevel() != 1);

            // Menyusun isi kartu
            card.add(nameLabel, BorderLayout.CENTER);
            card.add(levelLabel, BorderLayout.EAST);

            card.setMaximumSize(
                    new Dimension(Integer.MAX_VALUE, 65)
            );

            listPanel.add(card);
            listPanel.add(Box.createVerticalStrut(8));

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

        statistics.setFont(AppTheme.BODY_FONT);
        statistics.setForeground(AppTheme.TEXT);

        // Menyusun tampilan utama
        mainPanel.add(title, BorderLayout.NORTH);

        mainPanel.add(
                new JScrollPane(listPanel),
                BorderLayout.CENTER
        );

        mainPanel.add(statistics, BorderLayout.SOUTH);

        mainPanel.setPreferredSize(new Dimension(550, 400));

        setContentPane(mainPanel);

        // Menyesuaikan ukuran jendela
        pack();
        setMinimumSize(new Dimension(420, 300));
        setLocationRelativeTo(null);
    }
}
