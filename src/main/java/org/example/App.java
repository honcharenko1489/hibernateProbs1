package org.example;

import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {

        Configuration configuration = new Configuration().
                addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

            Person person1 = new Person("Marina", 34);
            person1.addItem(new Item("Gavka"));
            person1.addItem(new Item("Pupka"));
            person1.addItem(new Item("Alupka"));

            session.save(person1);




                    /*session.get(Person.class, 4);

            Item item = session.get(Item.class, 1);
            item.getOwner().getItems().remove(item);

            item.setOwner(person);*/


            /*Person person3 = session.get(Person.class, 3);
            List<Item> items = person3.getItems();
            for (Item item: items){
                session.remove(item);
            }

            person3.getItems().clear();*/

            /*Person person1 = new Person("Harry", 31);
            Item newItem1 = new Item("Item from harry", person1);

            person1.setItems(new ArrayList<>(Collections.singletonList(newItem1)));

            session.save(person1);

            session.save(newItem1);*/

            /*Person person = session.get(Person.class, 2);
            Item newItem = new Item("Item from hibernate", person);
            person.getItems().add(newItem);
            session.save(newItem);*/

            /*Item item = session.get(Item.class, 5);
            System.out.println(item);
            Person person = item.getOwner();
            System.out.println(person);*/
            /*Person person = session.get(Person.class, 3);
            System.out.println(person);
            List<Item> items = person.getItems();

            System.out.println(items);*/

            session.getTransaction().commit();

        } finally {

            sessionFactory.close();
        }
    }
}
