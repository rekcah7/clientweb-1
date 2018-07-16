package test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@inerface PrintToString{
	
}

class TOStringHelper{
	public static String toString(Object obj){
		StringBuffer sb = new StringBuffer();
		Class clazz = obj.getClass();
		for(Field field : clazz.getDeclaredFields()){
			if(field.isAnnotationPresent(PrintToString.class))
			{
				String fieldName = field.getName();
				fieldName = "get" +
				fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
				
				Method method = null;
			}
			try{
				method = clazz.getMethod(fieldName, null);
			} catch(NoSuchMethodException | SecurityException e){
				e.printStackTrace();
			}
			Object value = null;
			try{
				value = method.invoke(obj);
			}catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException e ){
				e.printStackTrace();
			}
			sb.append(field.getName()).append("=").append(value);
		}
		return sb.toString();
	}
}

class Person{
	@PrintToString
	private String name;
	
	private int age;
	
	@PrintToString
	private String remark;
	
	public String toString(){
		return ToStringHelper.toString(this);
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age = age;
	}
	public String getRemark(){
		return remark;
	}
	public void setRemark(){
		this.remark = remark;
	}
}

public class Ch10_05 {

	public static void main(String[] args) {
		Person person = new Person();
		person.setName("±æµ¿¾¾");
		person.setAge(31);
		person.setRemark("¿À´Ã ¼ö¿äÀÏ");
		System.out.println(person);
	}

}
