package patterns.creational;

class Singleton
{
    private static Singleton instance;

    private Singleton()
    {
    }

    public static Singleton getInstance()
    {
        if (instance == null)
        {
            instance = new Singleton();
        }
        return instance;
    }

    public void showMessage()
    {
        System.out.println("Привіт! Це Максим!");
    }
}

class Car
{
    String model;

    Car(String model)
    {
        this.model = model;
    }

    void drive()
    {
        System.out.println("Ви їдете на " + model);
    }
}

class CarFactory
{
    static Car createCar(String model)
    {
        return new Car(model);
    }
}

class Phone
{
    String brand;

    Phone(String brand)
    {
        this.brand = brand;
    }

    void call()
    {
        System.out.println("Дзвінок з " + brand);
    }
}

class PhoneFactory
{
    static Phone createPhone(String type)
    {
        if (type.equals("Samsung."))
        {
            return new Phone("Samsung.");
        } else if (type.equals("Apple."))
        {
            return new Phone("iPhone.");
        } else
        {
            return new Phone("Невідомий телефон.");
        }
    }
}

class House
{
    String walls;
    String roof;

    void showHouse()
    {
        System.out.println("Будинок з " + walls + " та з " + roof);
    }
}

class HouseBuilder
{
    House house = new House();

    HouseBuilder setWalls(String walls)
    {
        house.walls = walls;
        return this;
    }

    HouseBuilder setRoof(String roof)
    {
        house.roof = roof;
        return this;
    }

    House build()
    {
        return house;
    }
}

class Book
{
    String title;

    Book(String title)
    {
        this.title = title;
    }

    Book cloneBook()
    {
        return new Book(this.title);
    }

    void showTitle()
    {
        System.out.println("Книга: " + title);
    }
}

public class Main
{
    public static void main(String[] args)
    {
        Singleton singleton = Singleton.getInstance();
        singleton.showMessage();

        Car myCar = CarFactory.createCar("BMW.");
        myCar.drive();

        Phone myPhone = PhoneFactory.createPhone("Apple.");
        myPhone.call();

        House house = new HouseBuilder()
                .setWalls("цеглянних стін")
                .setRoof("металевим дахом.")
                .build();
        house.showHouse();

        Book book1 = new Book("The Witcher.");
        Book book2 = book1.cloneBook();
        book2.showTitle();
    }
}