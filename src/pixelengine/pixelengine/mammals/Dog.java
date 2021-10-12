package pixelengine.mammals;

public class Dog extends Mammal {

	public Dog(String name) {
		super(name);
	}
	
	@Override
	public void makeSound() {
		System.out.println("bark");
		
	}
	
	
	
}
