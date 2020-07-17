package com.fstar.designpattern.command;

/**
 * Command
 */
@FunctionalInterface
public interface TextFileOperation {
    String execute();
}