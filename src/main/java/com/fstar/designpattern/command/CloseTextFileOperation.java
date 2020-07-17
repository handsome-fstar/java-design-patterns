package com.fstar.designpattern.command;

/**
 * Command
 */
public class CloseTextFileOperation implements TextFileOperation {
    private TextFile textFile;

    public CloseTextFileOperation(TextFile textFile) {
        this.textFile = textFile;
    }

    @Override
    public String execute() {
        return textFile.close();
    }
}
