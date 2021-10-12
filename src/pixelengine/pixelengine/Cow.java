package pixelengine;

public class Cow extends Mammal {

	public Cow(String name) {
		super(name);
	
	}
	
	@Override
	public void makeSound() {
		System.out.println("Moo");
	}

}

