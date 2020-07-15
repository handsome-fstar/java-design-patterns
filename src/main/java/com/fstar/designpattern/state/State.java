package com.fstar.designpattern.state;

import com.fstar.designpattern.state.Package;

public interface State {
    void next(Package pkg);

    void prev(Package pkg);

    void printStatus();
}
