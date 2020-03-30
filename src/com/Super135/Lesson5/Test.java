package com.Super135.Lesson5;

public class Test {
    public static void main(String[] args) {

        // 4. Создать массив из 5 сотрудников
        Employes[] employes = new Employes[5];
        employes[0] = new Employes("Литвинов Илья", "Программист JAVA", "super05061982@gmail.com", "+7(977)5308560", 150000, 41);
        employes[1] = new Employes("Роман Ильич", "Программист БД", "jh57342@gmail.com", "+7(971)5358865", 19000, 37);
        employes[2] = new Employes("Литвинова галина", "Программист WEB", "sup66547@gmail.com", "+7(966)6338560", 190000, 32);
        employes[3] = new Employes("Моргунов Константин", "Программист", "l;gfkh456@gmail.com", "+7(950)5406540", 110000, 40);
        employes[4] = new Employes("Семен семеныч", "Programmer JavaScript", "fdslkgjdjh@gmail.com", "+7(945)5334530", 113000, 54);

        // 5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
        System.out.println("Сотрудники старше 40 лет.");
        for (int i = 0; i < 5; i++) {
            if (employes[i].getAge() > 40) {
                employes[i].showEmployee();
            }
        }
    }

}
