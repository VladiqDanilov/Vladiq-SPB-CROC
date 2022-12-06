package ru.croc.task15;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Task15 {
	public static void main(String[] args) {
        System.out.println("введите границы возрастных групп");
        Scanner scanner = new Scanner(System.in);
        String ageLim = scanner.nextLine();
        System.out.println("Введите пользователей. В конце - END");
        String userString= "";
        List<String[]> users = new ArrayList<>();
        while (!userString.equals("END")) {
        	userString= scanner.nextLine();
            if (!userString.equals("END")) {
                users.add(userString.split(","));
            }
        };
        if(scanner != null) {
            scanner.close();
        }
        System.out.println("\nСозданные возрастные группы: ");
        List<DescAge> newGrp = AgeFind.createGroups(ageLim, users);
        for (int i = newGrp.size() - 1; i >= 0; i--) {
            System.out.println(newGrp.get(i));
        }
    }
	// На вход программе:
			// сначала:
	        //18 25 35 45 60 80 100
	        //Кошельков Захар Брониславович,105
			// потом:
	        //Старостин Ростислав Ермолаевич,50
	        //Егоров Алан Петрович,7
	        //Ярилова Розалия Трофимовна,29
	        //Дьячков Нисон Иринеевич,88
	        //Соколов Андрей Сергеевич,15
	        //Иванов Варлам Якунович,88

}
