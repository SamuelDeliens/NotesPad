package com.company.samuel;

import com.company.samuel.controllers.Views;
import com.company.samuel.models.BlocNotes;
import com.company.samuel.views.mainView.MainView;

import java.io.File;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Views> listView = null;
    public static ArrayList<BlocNotes> listBloc = null;

    public static void main(String[] args) {
        listView = new ArrayList<>();
        listBloc = new ArrayList<>();

        setListBloc();

        MainView mainView = new MainView();
        Main.addView(mainView);
        mainView.display();
    }

    public static void setListBloc() {
        listBloc.clear();
        java.io.File data = new File("./data");
        File[] listFiles = data.listFiles();
        if (listFiles != null) {
            for (File item : listFiles) {
                if (!item.getName().equals(".DS_Store")) {
                    BlocNotes bloc = new BlocNotes();
                    bloc = bloc.recup(item);
                    if (bloc != null) {
                        listBloc.add(bloc);
                    }
                }
            }
        }
    }
    public static ArrayList<BlocNotes> getListBloc() {
        return listBloc;
    }

    public static Views getView(int id) {
        return listView.get(id);
    }
    public static void addView(Views viewX) {
        listView.add(viewX);
    }
    public static void removeView(int id) {
        listView.remove(id);
    }
    public static void removeView(Views view) {
        listView.remove(view);
    }
}

