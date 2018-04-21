package test07;
import static utils.ThinkingJavaUtils.*;
public class Practice20 {
	public static void main(String[] args) {
		OverridFinal2 ov2 = new OverridFinal2();
		ov2.f();
		ov2.g();
		OverridFinal ov = ov2;
		/*	ov.f();
			ov.g();
			不可见
		*/
	}
}
class WithFinals{
	private final void f(){
		println("WithFinals.f()");
	}
	private void g(){
		println("WithFinals.g()");
	}
}
class OverridFinal extends WithFinals{
	private final void f(){
		println("OverridFinal.f()");
	}
	private void g(){
		println("OverridFinal.g()");
	}
}
class OverridFinal2 extends OverridFinal{
	public final void f(){
		println("OverridFinal2.f()");
	}
	public void g(){
		println("OverridFinal2.g()");
	}
}
class OverridFinal3 extends OverridFinal2{
	/*public final void f(){
	Cannot override the final method from OverridFinal2
	}*/
}


