import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//Interface Soup
//Интерфейс содержит в себе несколько методов, которые должны быть поделены на разные интерфейсы по принципу ISP
interface SuperInterface{
    //Работа с базой данных
    void saveToDB(String txt);
    void readFromDB(int id);

    //Какие-то вычисления
    int calculateSize(double n);
    int fact(int n);
    double trArea(double h, double a);

    //Вывод некоторых сообщений
    void printMsg(String msg);
    void saveMsgToFile(String msg);
}

//God Object
//Один общий класс Calculator, который делает все: выполняет математические операции, выводит интерфейс, считывает введенные данные, работает с файлами и так далее
public class Calculator implements SuperInterface{
    //Magic Number
    //Константа, которая просто обозначена как E. Не совсем понятно для чего она нужна, нет пояснений
    public static final double E=0.001;

    //Boat Anchor
    //Метод, который нигде не используется. Оставлен на "будущее"
    public double trArea(double h, double a){
        double s;
        s=h*a/2;
        return s;
    }

    //Boat Anchor
    //Метод, который нигде не используется. Оставлен на "будущее"
    public int fact(int n){
        int r;
        r=1;
        for (int i=1; i<= n; i++){
            r=r*i;
        }
        return r;
    }

    //Cryptic Code
    //Название метода "o" ни о чем не говорит, в отличие от "operations" или "mathOperations"
    //Непонятные названия переменных ("l","u","fn","nextfn","r", "t")
    public double o(int t, double a, double b){

        //Спагетти код
        //Огромная конструкция if else, в которой выполняются все операции
        if (t==1){
            double c;
            c=a+b;
            saveToDB(a+"+"+b+"="+c);
            return c;
        }else if(t==2){
            double c;
            c=a-b;
            saveToDB(a+"-"+b+"="+c);
            return c;
        }else if(t==3){
            double c;
            c=a*b;
            saveToDB(a+"*"+b+"="+c);
            return c;
        }else if(t==4){
            double c;
            c=a/b;
            saveToDB(a+"/"+b+"="+c);
            return c;
        }else if(t==5){
            //Reinventing the wheel - "придуман" метод, который ищет квадратный корень путем усреднения результатов, когда уже есть готовая функция Math.sqrt()
            //Blind Faith - вера в то, что пользователь не введет отрицательное число для поиска корня. Если он это сделает, программа зависнет, так как не выйдет из цикла
            double l=0;
            while (l*l<a){
                l=l+1;
            }
            if (l*l==a){
                return l;
            }
            l=l-1;

            double u=l+1;
            double fn=(l+u)/2;
            while (true){
                double nextfn = (fn + a/fn)/2;
                if (Math.abs(nextfn-fn)<E){
                    saveToDB("sqrt("+a+")="+nextfn);
                    return nextfn;
                }
                fn=nextfn;
            }
        }else if(t==6){
            //Reinventing the square wheel - "придуман" плохой и неэффективный метод возведения числа в степень, в котором используется сложение и цикл в цикле.
            if (b==0){return 1;}
            double r=a;

            for (int i=0; i<Math.abs(b)-1; i++){
                double tmp=0;
                for (int j=0; j<Math.abs(a);j++){
                    tmp+=r;
                }
                r=tmp;
            }
            if(b<0){
                saveToDB(a+"^"+b+"="+1/r);
                return 1/r;
            }
            saveToDB(a+"^"+b+"="+r);
            return r;
        }
        return 0;
    }

    public void prntMn(){
        System.out.println("1. Sum два числа");
        System.out.println("2. Sub два числа");
        System.out.println("3. Mult два числа");
        System.out.println("4. Div два числа");
        System.out.println("5. Найти sqrt корень из числа");
        System.out.println("6. Возвести целое число в power");

        Scanner s = new Scanner(System.in);

        int a=s.nextInt();
        //Copy and Paste
        //Операции с 1 по 4 просто ctrl+c ctrl+v с минимальным изменением
        if (a==1){
            double n1, n2;
            n1=s.nextDouble();
            n2=s.nextDouble();
            System.out.println("Enter two numbers:");
            System.out.println(o(1, n1, n2));
        } else if (a==2) {
            double n1, n2;
            n1=s.nextDouble();
            n2=s.nextDouble();
            System.out.println("Enter two numbers:");
            System.out.println(o(2, n1, n2));
        } else if (a==3) {
            double n1, n2;
            n1=s.nextDouble();
            n2=s.nextDouble();
            System.out.println("Enter two numbers:");
            System.out.println(o(3, n1, n2));
        } else if (a==4) {
            double n1, n2;
            n1=s.nextDouble();
            n2=s.nextDouble();
            System.out.println("Enter two numbers:");
            System.out.println(o(4, n1, n2));
        } else if (a==5) {
            System.out.println("Enter a number:");
            System.out.println(o(5, s.nextDouble(), 0));
        } else if (a==6) {
            System.out.println("Enter two numbers:");
            System.out.println(o(6, s.nextInt(), s.nextInt()));
        }
    }

    //Заглушка
    //Метод saveToDB интерфейса, который по названию должен работать с БД, выполняет сохранение в файл
    public void saveToDB(String txt){
        try{
            //Hard code
            //В коде hard вписан путь, по которому нужно сохранять историю вычислений
            FileWriter writer = new FileWriter("D:/calc_history/history.txt", true);
            writer.write(txt+"\n");
            writer.close();

        //Пустой блок catch
        //Блок catch не обрабатывает ошибку и просто "проглотит" ее
        } catch (IOException e){}
    }

    //Висящий конец
    //Методы интерфейса - "пустышки", потому что они не нужны
    public void readFromDB(int id){}
    public void saveMsgToFile(String msg){}
    public int calculateSize(double n){return 0;}
    public void printMsg(String msg){System.out.println("Сообщение: "+msg);}

    public static void main(String[] args) {
        Calculator calc=new Calculator();
        while (true){
            calc.prntMn();
        }
    }
}