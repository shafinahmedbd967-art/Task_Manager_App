package com.taskmanager;

import com.formdev.flatlaf.FlatDarkLaf;
import com.taskmanager.view.MainFrame;
import com.taskmanager.controller.TaskController;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new FlatDarkLaf()); // 🔥 modern dark UI
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            MainFrame view = new MainFrame();
            new TaskController(view);
        });
    }
}