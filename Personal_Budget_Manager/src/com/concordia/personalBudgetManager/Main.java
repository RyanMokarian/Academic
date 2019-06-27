/*
Title: Personal Budget Manager
Authors: Ryan Mokarian, Bilal Qandeel, Vladslav Melnikov, Kaidi Guo, Greg Selinger
Category: Software Development
Description:
- a Java-based GUI personal budget manager application to track personal expenses.
- Implemented MVC Architectural model and Swing user interface.
- Junit tested, driven by functional requirements.
*/

package com.concordia.personalBudgetManager;
import com.concordia.personalBudgetManager.RecordManagementForm;

public class Main {
    public static void main(String[] args) {
    	User JaneDoe = new User("Jane Doe");
    	new RecordManagementForm(JaneDoe);
    }
}