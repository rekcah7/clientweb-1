package test;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface maker{
	int num();
	String name();
	String id();
	String date() default "2018-07-05";
}

@maker(id="111", num=1, name="Dominica")
public class Ch10_04 {

	public static void main(String[] args) {
		for(Annotation a : Ch10_04.class.getAnnotations()){
			//System.out.println(" " + a);
		}
		System.out.println("String 생성자");
		for(Constructor c : String.class.getConstructors()){
			//System.out.println(c);
			//public java.lang~~~출력
		}
		System.out.println("String 메소드");
		for(Method m : String.class.getMethods()){
			//System.out.println(m);
		}
		System.out.println("String 필드");
		for(Field f : String.class.getFields()){
			System.out.println(f);
			
		}
	}

}
