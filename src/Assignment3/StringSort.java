package Assignment3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

class Name {
    String name;

    Name(String name) {
        this.name = name;
    }
}

class SortByName implements Comparator<Name> {

    @Override
    public int compare(Name name1, Name name2) {
        if (name1.name.contains(name2.name) || name2.name.contains(name1.name)) {
            return name2.name.compareTo(name1.name);
        }
        return name1.name.compareTo(name2.name);
    }
}

public class StringSort {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int num = scan.nextInt();
        ArrayList<Name> names = new ArrayList<>();
        while (num-- >0) {
            String getname = scan.next();
            Name name = new Name(getname);
            names.add(name);
        }

        names.sort(new SortByName());
        for (Name nameObj: names){
            System.out.println(nameObj.name);
        }
    }
}