package org.example.controller;

import org.example.dto.Guest;

public abstract class Controller {
    public abstract void doAction(String cmd, String actionMethodName);
}
