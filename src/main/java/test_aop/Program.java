package test_aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {
   public static void main(String[] args){
      
      ApplicationContext 콩자루 = new ClassPathXmlApplicationContext("test_aop/aop-context.xml"); // 저걸 지시서 삼아서 일을 해라!
      // test_aop/aop-context.xml에 넣어두면 변경이 자유롭다.
      
      //Calc calc = new NewlecCalc();
      Calc calc = (Calc) 콩자루.getBean("calc");
      calc.set(3,4);
      System.out.println(calc.add());
   
   }
}