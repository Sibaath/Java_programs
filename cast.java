public class cast {
   public static void main(String[] args) {
    Animal obj = new Dog();
    obj.makeSound();
    //obj.growl();
   } 
}

class Animal
{
    void makeSound()
    {
        System.out.println("Make sound");
    }
}

class Dog extends Animal
{
    void makeSound()
    {
        System.out.println("woof woof!!");
    }

    void growl()
    {
        System.out.println("Growl");
    }
}
