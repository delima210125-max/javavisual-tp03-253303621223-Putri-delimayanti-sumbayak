
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.CharacterType;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class AppTheme {

    // ===============================
    // WARNA APLIKASI
    // ===============================

    public static final Color BACKGROUND = new Color(245, 247, 250);
    public static final Color SURFACE = new Color(255, 255, 255);
    public static final Color TEXT = new Color(35, 40, 50);
    public static final Color MUTED = new Color(110, 120, 135);
    public static final Color BORDER_COLOR = new Color(220, 225, 232);
    public static final Color GOLD = new Color(190, 140, 20);
    public static final Color BG_STATUS = Color.decode("#0d0d1a");
    public static final Color TEXT_MUTED = Color.decode("#9d9dbf");

    // ===============================
    // FONT APLIKASI
    // ===============================

    public static final Font TITLE_FONT =
            new Font("SansSerif", Font.BOLD, 22);

    public static final Font BODY_FONT =
            new Font("SansSerif", Font.PLAIN, 15);

    public static final Font SMALL_FONT =
            new Font("SansSerif", Font.PLAIN, 12);

    public static final Font HIGHLIGHT_FONT =
            new Font("SansSerif", Font.BOLD, 15);

    // ===============================
    // BORDER APLIKASI
    // ===============================

    public static final Border MAIN_BORDER =
            BorderFactory.createEmptyBorder(15, 15, 15, 15);

    public static final Border CARD_BORDER =
            BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(BORDER_COLOR, 1),
                    BorderFactory.createEmptyBorder(10, 12, 10, 12)
            );

    // ===============================
    // WARNA BERDASARKAN ROLE
    // ===============================

    public static Color colorFor(CharacterType type) {

        switch (type) {
            case WARRIOR:
                return new Color(255, 235, 235);

            case MAGE:
                return new Color(240, 230, 255);

            case ARCHER:
                return new Color(230, 250, 235);

            case HEALER:
                return new Color(230, 240, 255);

            default:
                return SURFACE;
        }
    }

    private AppTheme() {
        // Mencegah objek AppTheme dibuat.
    }
}
