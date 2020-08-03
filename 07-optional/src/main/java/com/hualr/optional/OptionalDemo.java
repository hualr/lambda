package com.hualr.optional;

import com.hualr.bean.Car;
import com.hualr.bean.Insurance;
import com.hualr.bean.Person;
import com.hualr.com.hualr.beanX.CarX;
import com.hualr.com.hualr.beanX.PersonX;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        System.out.println(new DemoUse().getCarInsuranceName(new Person()));
        System.out.println(new DemoUse().getCarInsuranceName2(new Person()));

        //创建一个Optional.empty对象
        Optional<CarX> optionalCarX=Optional.empty();
        System.out.println(optionalCarX);
        //当出现空则报错
        Optional<CarX> optionalCarX1=Optional.of(new CarX());
        System.out.println(optionalCarX1);

        //当出现空则返回..empty对象
        Optional<CarX> optionalCarX2=Optional.ofNullable(null);
        System.out.println(optionalCarX2);
        Optional<CarX> optionalCarX3=Optional.ofNullable(new CarX());
        System.out.println(optionalCarX3);

        String name=null;
        Insurance insurance=new Insurance();
        if(null!=insurance){
            name=insurance.getName();
        }
        //首先创建一个Optional的保险对象
        Optional<Insurance> optionalInsurance=Optional.ofNullable(insurance);
        //其次调用对象的map来生成保险对象的name
        Optional<String> name1=optionalInsurance.map(insurance1 -> insurance.getName());
        System.out.println(name1);
//        String name3=name1.get();
//        System.out.println(name3);
        //Optional<String> name2=optionalInsurance.get().getName();

        Person person=new Person();
        Car car=new Car();
        Insurance insurance9=new Insurance();

        car.setInsurance(insurance);
        person.setCar(car);

        Optional<Person> optionalPerson=Optional.ofNullable(new Person());
        System.out.println(new DemoUse().getCarInsuranceName3(optionalPerson));
    }


}

class DemoUse{
    //不太好写
    public String getCarInsuranceName(Person person) {
        if (person != null) {
            Car car = person.getCar();
            if (car != null) {
                Insurance insurance = car.getInsurance();
                if (insurance != null) {
                    return insurance.getName();
                }
            }
        }
        return "Unknown";
    }
    //容易忘记所有属性的选择
    public String getCarInsuranceName2(Person person) {
        if (person == null) {
            return "Unknown";
        }
        Car car = person.getCar();
        if (car == null) {
            return "Unknown";
        }
        Insurance insurance = car.getInsurance();
        if (insurance == null) {
            return "Unknown";
        }
        return insurance.getName();
    }

    public String getCarInsuranceName3(Optional<Person> person) {
        return person.flatMap(x->x.getOptionalCar())
                    .flatMap(x->x.getOptionalInsurance())
                .map(Insurance::getName)
                .orElse("UNKOWN");
    }
}
