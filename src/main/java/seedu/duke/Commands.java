package seedu.duke;

import java.util.ArrayList;

public class Commands {

    public static void addGood(String id, String name, String qty, ArrayList<Goods> userGoods) {
        if (id.isBlank() || name.isBlank() || qty.isBlank()) {
            System.out.println("Please add a good in this format:\n"
                    + "add id/id_of_good_as_number n/name_of_good q/quantity_of_good_as_number");
            return;
        }
        try {
            Goods goods = new Goods(
                    Integer.parseInt(id),
                    name,
                    Integer.parseInt(id),
                    "Empty Description"); //description not yet added since not in UserGuide
            userGoods.add(goods);
            System.out.printf("%d %s Has been added\n" + "You have %d goods in the warehouse\n",
                    goods.getQuantity(), goods, userGoods.size());
        } catch (NumberFormatException e) {
            // error handling here
            System.out.println("Please add a good in this format:\n"
                    + "add id/id_of_good_as_number n/name_of_good q/quantity_of_good_as_number");
        }
    }
}