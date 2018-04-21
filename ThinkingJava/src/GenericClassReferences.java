public class GenericClassReferences {

	public static void main(String[] args) {

		Class<? extends Number> intClass = int.class;
		System.out.println(intClass);
		Class<Integer> genericIntClass = int.class;
		System.out.println(genericIntClass);
		genericIntClass = Integer.class;
		System.out.println(genericIntClass);
		intClass = double.class;

		System.out.println(intClass);

	}

}
