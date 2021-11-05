package com.company.Behavioraldesignpatterns.commandpatterns;

import java.util.ArrayList;

public class CommandProcessor {

    ArrayList<OrderCommand> queue = new ArrayList<>();

    public void addToQueue(OrderCommand orderCommand) {
        queue.add(orderCommand);
    }

    public void processCommands() {
        queue.forEach(OrderCommand::execute);
        queue.clear();
    }


}
