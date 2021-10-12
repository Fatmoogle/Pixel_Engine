package pixelengine;

public class Mammal {

	private String name;
	
	// Constructors are named the same as the class
	
	public Mammal(String name) {
		setName(name);
	}


	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void update() {
		makeSound();
	}
	
	public void makeSound() {
		System.out.println("snort");
	}
	
}


// Getters and setters are needed for when state is private. When something is private, only it's class can modify the information. 
// This is why getters and setters are used. Variables are conventionally set to private to avoid from variables being manipulated 
// when we don't want them to change.