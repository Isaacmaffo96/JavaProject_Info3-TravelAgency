package collections;

interface Visitor<T> {
	
	T visit(City c);
	T visit(SeaCity s);
	T visit(MountainCity m);

}
