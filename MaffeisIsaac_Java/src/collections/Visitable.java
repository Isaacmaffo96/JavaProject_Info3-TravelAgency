package collections;

interface Visitable {

	<T> T accept(Visitor<T> v);

}
