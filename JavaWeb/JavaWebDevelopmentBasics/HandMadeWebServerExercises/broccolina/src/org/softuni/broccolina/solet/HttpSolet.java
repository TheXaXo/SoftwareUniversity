package org.softuni.broccolina.solet;

public interface HttpSolet {
    void doGet(HttpSoletRequest soletRequest, HttpSoletResponse soletResponse);

    void doPost(HttpSoletRequest soletRequest, HttpSoletResponse soletResponse);

    void doPut(HttpSoletRequest soletRequest, HttpSoletResponse soletResponse);

    void doDelete(HttpSoletRequest soletRequest, HttpSoletResponse soletResponse);
}