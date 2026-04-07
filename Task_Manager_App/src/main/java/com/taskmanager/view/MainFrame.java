package com.taskmanager.view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private JTextField taskField;
    private JTextField searchField;
    private JComboBox<String> priorityBox;

    private JButton addButton, deleteButton, completeButton, editButton;

    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;

    private boolean isEditing = false; // 🔥 EDIT MODE FLAG

    public MainFrame() {

        setTitle("Task Manager Pro");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(18, 18, 18));
        mainPanel.setLayout(new GridBagLayout());

        JPanel card = new JPanel();
        card.setPreferredSize(new Dimension(600, 500));
        card.setBackground(new Color(28, 28, 28));
        card.setLayout(new BorderLayout(15, 15));
        card.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        //  Title
        JLabel title = new JLabel("Task Manager", JLabel.CENTER);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));

        //  Input Panel
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(28, 28, 28));

        taskField = new JTextField(12);
        taskField.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        String[] priorities = {"High", "Medium", "Low"};
        priorityBox = new JComboBox<>(priorities);

        addButton = new JButton("Add / Update Task");
        styleButton(addButton, new Color(0, 120, 215));

        topPanel.add(taskField);
        topPanel.add(priorityBox);
        topPanel.add(addButton);

        //  Search
        JPanel searchPanel = new JPanel();
        searchPanel.setBackground(new Color(28, 28, 28));

        searchField = new JTextField(20);
        searchField.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        searchPanel.add(new JLabel("Search: "));
        searchPanel.add(searchField);

        //  Task List
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        taskList.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        taskList.setBackground(new Color(40, 40, 40));
        taskList.setForeground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(taskList);

        //  Buttons
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(28, 28, 28));

        deleteButton = new JButton("Delete");
        completeButton = new JButton("Complete");
        editButton = new JButton("Edit"); // 🔥 NEW

        styleButton(deleteButton, new Color(200, 50, 50));
        styleButton(completeButton, new Color(50, 150, 50));
        styleButton(editButton, new Color(255, 165, 0));

        bottomPanel.add(editButton);
        bottomPanel.add(deleteButton);
        bottomPanel.add(completeButton);

        // Layout
        JPanel topContainer = new JPanel(new BorderLayout());
        topContainer.setBackground(new Color(28, 28, 28));

        topContainer.add(title, BorderLayout.NORTH);
        topContainer.add(topPanel, BorderLayout.CENTER);
        topContainer.add(searchPanel, BorderLayout.SOUTH);

        card.add(topContainer, BorderLayout.NORTH);
        card.add(scrollPane, BorderLayout.CENTER);
        card.add(bottomPanel, BorderLayout.SOUTH);

        mainPanel.add(card);
        add(mainPanel);

        setVisible(true);
    }

    private void styleButton(JButton button, Color color) {
        button.setFocusPainted(false);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    // 🔓 Getters
    public JTextField getTaskField() { return taskField; }
    public JTextField getSearchField() { return searchField; }
    public JComboBox<String> getPriorityBox() { return priorityBox; }

    public JButton getAddButton() { return addButton; }
    public JButton getDeleteButton() { return deleteButton; }
    public JButton getCompleteButton() { return completeButton; }
    public JButton getEditButton() { return editButton; }

    public DefaultListModel<String> getTaskListModel() { return taskListModel; }
    public JList<String> getTaskList() { return taskList; }

    public boolean isEditing() { return isEditing; }
    public void setEditing(boolean editing) { this.isEditing = editing; }
}