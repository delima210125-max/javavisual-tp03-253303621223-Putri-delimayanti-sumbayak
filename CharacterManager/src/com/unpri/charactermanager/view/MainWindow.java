
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainWindow extends JFrame {

    private static final int HIGH_LEVEL_THRESHOLD = 5;

    public MainWindow(List<Character> characters) {

        setTitle("Character Manager - TP12 AP16");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // PANEL UTAMA
        JPanel mainPanel = new JPanel(new BorderLayout(12, 12));
        mainPanel.setBackground(AppTheme.BACKGROUND);
        mainPanel.setBorder(AppTheme.MAIN_BORDER);

        // NORTH: HEADER DAN STATISTIK
        JPanel northPanel = new JPanel(new BorderLayout(8, 10));
        northPanel.setBackground(AppTheme.BACKGROUND);

        JLabel title = new JLabel("CHARACTER MANAGER");
        title.setFont(AppTheme.TITLE_FONT);
        title.setForeground(AppTheme.TEXT);

        northPanel.add(title, BorderLayout.NORTH);

        // Statistik menggunakan GridLayout
        JPanel statsPanel = new JPanel(new GridLayout(2, 2, 10, 8));
        statsPanel.setBackground(AppTheme.BACKGROUND);

        int totalLevel = 0;
        int highestLevel = 0;

        for (Character c : characters) {
            totalLevel += c.getLevel();
            highestLevel = Math.max(highestLevel, c.getLevel());
        }

        double average = characters.isEmpty()
                ? 0
                : (double) totalLevel / characters.size();

        statsPanel.add(createStatLabel(
                "Total Karakter: " + characters.size()));

        statsPanel.add(createStatLabel(
                String.format("Rata-rata Level: %.2f", average)));

        statsPanel.add(createStatLabel(
                "Level Tertinggi: " + highestLevel));

        statsPanel.add(createStatLabel(
                "Jumlah Role: " + CharacterType.values().length));

        northPanel.add(statsPanel, BorderLayout.SOUTH);
        mainPanel.add(northPanel, BorderLayout.NORTH);

        // CENTER: DAFTAR KARAKTER
        JPanel cardsPanel = new JPanel(
                new GridLayout(0, 1, 0, 8)
        );
        cardsPanel.setBackground(AppTheme.BACKGROUND);

        for (Character c : characters) {

            JPanel card = new JPanel(new BorderLayout(10, 5));

            card.setBackground(AppTheme.colorFor(c.getType()));
            card.setBorder(AppTheme.CARD_BORDER);
            card.setPreferredSize(new Dimension(450, 65));

            JLabel nameLabel = new JLabel(
                    c.getName() + " | " + c.getType()
            );

            nameLabel.setFont(AppTheme.BODY_FONT);
            nameLabel.setForeground(AppTheme.TEXT);

            JLabel levelLabel = new JLabel(
                    "Level: " + c.getLevel()
            );

            levelLabel.setFont(AppTheme.BODY_FONT);
            levelLabel.setForeground(AppTheme.MUTED);

            if (c.getLevel() >= HIGH_LEVEL_THRESHOLD) {
                levelLabel.setFont(AppTheme.HIGHLIGHT_FONT);
                levelLabel.setForeground(AppTheme.GOLD);
            }

            card.setToolTipText(
                    "Nama: " + c.getName()
                    + " | Role: " + c.getType()
                    + " | Level: " + c.getLevel()
            );

            card.add(nameLabel, BorderLayout.CENTER);
            card.add(levelLabel, BorderLayout.EAST);

            cardsPanel.add(card);
        }

        // Wrapper agar daftar karakter dapat di-scroll
        JPanel listWrapper = new JPanel(new BorderLayout());
        listWrapper.setBackground(AppTheme.BACKGROUND);
        listWrapper.add(cardsPanel, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(listWrapper);
        scrollPane.setPreferredSize(new Dimension(500, 350));
        scrollPane.getViewport().setBackground(AppTheme.BACKGROUND);

        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // EAST: LEGENDA ROLE
        JPanel legendPanel = new JPanel();
        legendPanel.setLayout(
                new BoxLayout(legendPanel, BoxLayout.Y_AXIS)
        );

        legendPanel.setBackground(AppTheme.SURFACE);
        legendPanel.setBorder(AppTheme.CARD_BORDER);
        legendPanel.setPreferredSize(new Dimension(160, 200));

        JLabel legendTitle = new JLabel("LEGENDA ROLE");
        legendTitle.setFont(AppTheme.HIGHLIGHT_FONT);
        legendTitle.setForeground(AppTheme.TEXT);
        legendTitle.setAlignmentX(Component.LEFT_ALIGNMENT);

        legendPanel.add(legendTitle);
        legendPanel.add(Box.createVerticalStrut(15));

        // Role dibuat otomatis berdasarkan enum
        for (CharacterType type : CharacterType.values()) {

            JPanel roleItem = new JPanel(new FlowLayout(
                    FlowLayout.LEFT, 5, 3
            ));

            roleItem.setBackground(AppTheme.colorFor(type));
            roleItem.setAlignmentX(Component.LEFT_ALIGNMENT);

            JLabel roleLabel = new JLabel(type.toString());
            roleLabel.setFont(AppTheme.SMALL_FONT);
            roleLabel.setForeground(AppTheme.TEXT);

            roleItem.add(roleLabel);

            legendPanel.add(roleItem);
            legendPanel.add(Box.createVerticalStrut(8));
        }

        // Glue mendorong isi legenda ke bagian atas
        legendPanel.add(Box.createVerticalGlue());

        mainPanel.add(legendPanel, BorderLayout.EAST);

        // SOUTH: STATUS BAR
        JPanel statusPanel = new JPanel(new BorderLayout());
        statusPanel.setBackground(AppTheme.BG_STATUS);
        statusPanel.setBorder(
                BorderFactory.createEmptyBorder(8, 12, 8, 12)
        );

        JLabel statusLabel = new JLabel(
                "Status: " + characters.size() + " karakter dimuat"
        );

        statusLabel.setFont(AppTheme.SMALL_FONT);
        statusLabel.setForeground(AppTheme.TEXT_MUTED);

        // Versi aplikasi
        JLabel versionLabel = new JLabel("v0.5");
        versionLabel.setFont(AppTheme.SMALL_FONT);
        versionLabel.setForeground(AppTheme.TEXT_MUTED);

        statusPanel.add(statusLabel, BorderLayout.WEST);
        statusPanel.add(versionLabel, BorderLayout.EAST);

        mainPanel.add(statusPanel, BorderLayout.SOUTH);

        // PENGATURAN JENDELA
        setContentPane(mainPanel);
        setPreferredSize(new Dimension(850, 600));

        pack();
        setMinimumSize(new Dimension(550, 400));
        setLocationRelativeTo(null);
    }

    // Membuat label statistik
    private JLabel createStatLabel(String text) {

        JLabel label = new JLabel(text);

        label.setFont(AppTheme.BODY_FONT);
        label.setForeground(AppTheme.TEXT);

        return label;
    }
}
