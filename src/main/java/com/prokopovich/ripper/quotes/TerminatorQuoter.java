package com.prokopovich.ripper.quotes;

import com.prokopovich.ripper.annotation.InjectRandomInt;
import com.prokopovich.ripper.annotation.PostProxy;
import com.prokopovich.ripper.annotation.Profiling;

import javax.annotation.PostConstruct;

@Profiling
public class TerminatorQuoter implements Quoter {

    @InjectRandomInt(min = 2, max = 7)
    private int repeat;

    private String message;

    public TerminatorQuoter() {

        System.out.println("Phase 1");
    }

    @PostConstruct
    public void init() {

        System.out.println("Phase 2");
        System.out.println(repeat);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    @PostProxy
    public void sayQuote() {

        for (int i = 0; i < repeat; i++) {
            System.out.println("message = " + message);
        }
    }
}