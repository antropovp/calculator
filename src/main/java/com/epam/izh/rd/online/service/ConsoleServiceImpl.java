package com.epam.izh.rd.online.service;

import java.util.Scanner;

public class ConsoleServiceImpl implements ConsoleService {

    public String read() {
        return new Scanner(System.in).nextLine();
    }

    public void print(String output) {
        System.out.println(output);
    }
}
