package com.taskmanager.controller;

import com.taskmanager.view.MainFrame;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TaskController {

    private MainFrame view;

    //  Backup (source of truth)
    private DefaultListModel<String> originalModel = new DefaultListModel<>();

    public TaskController(MainFrame view) {
        this.view = view;

        initController();
    }

    private void initController() {

        // ADD / UPDATE
        view.getAddButton().addActionListener(e -> addOrUpdateTask());

        // EDIT
        view.getEditButton().addActionListener(e -> editTask());

        // DELETE
        view.getDeleteButton().addActionListener(e -> deleteTask());

        // COMPLETE
        view.getCompleteButton().addActionListener(e -> completeTask());

        // 🔍 SEARCH
        view.getSearchField().getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                filterTasks();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filterTasks();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filterTasks();
            }
        });
    }

    // =========================
    // ADD / UPDATE
    // =========================
    private void addOrUpdateTask() {

        String task = view.getTaskField().getText().trim();
        String priority = (String) view.getPriorityBox().getSelectedItem();

        if (task.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Task cannot be empty!");
            return;
        }

        String formattedTask = task + " [" + priority + "]";

        view.getTaskListModel().addElement(formattedTask);
        originalModel.addElement(formattedTask);

        view.getTaskField().setText("");
        view.setEditing(false);
    }

    // =========================
    // EDIT
    // =========================
    private void editTask() {

        int index = view.getTaskList().getSelectedIndex();

        if (index != -1) {

            String selected = view.getTaskList().getSelectedValue();

            view.getTaskField().setText(selected);

            view.getTaskListModel().removeElement(selected);
            originalModel.removeElement(selected);

            view.setEditing(true);

        } else {
            JOptionPane.showMessageDialog(null, "Select a task first!");
        }
    }

    // =========================
    // DELETE
    // =========================
    private void deleteTask() {

        int index = view.getTaskList().getSelectedIndex();

        if (index != -1) {

            String selected = view.getTaskList().getSelectedValue();

            view.getTaskListModel().removeElement(selected);
            originalModel.removeElement(selected);

        } else {
            JOptionPane.showMessageDialog(null, "Select a task to delete!");
        }
    }

    // =========================
    // COMPLETE
    // =========================
    private void completeTask() {

        int index = view.getTaskList().getSelectedIndex();

        if (index != -1) {

            String selected = view.getTaskList().getSelectedValue();

            String updated = selected.startsWith("✔") ? selected : "✔ " + selected;

            view.getTaskListModel().setElementAt(updated, index);

            int originalIndex = originalModel.indexOf(selected);
            if (originalIndex != -1) {
                originalModel.setElementAt(updated, originalIndex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Select a task to complete!");
        }
    }

    // =========================
    // SEARCH FILTER
    // =========================
    private void filterTasks() {

        String query = view.getSearchField().getText().toLowerCase();

        DefaultListModel<String> filteredModel = new DefaultListModel<>();

        // If search empty → restore full list
        if (query.isEmpty()) {
            view.getTaskList().setModel(originalModel);
            return;
        }

        for (int i = 0; i < originalModel.size(); i++) {
            String task = originalModel.getElementAt(i);

            if (task.toLowerCase().contains(query)) {
                filteredModel.addElement(task);
            }
        }

        view.getTaskList().setModel(filteredModel);
    }
}