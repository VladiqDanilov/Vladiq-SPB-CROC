package ru.croc.task15;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task15 {
	public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите пользователей. В конце - END");
            String curUser;
            List<String[]> users = new ArrayList<>();
            do {
                curUser = scanner.nextLine();
                if (!curUser.equals("END")) {
                    users.add(curUser.split(","));
                }
            } while (!curUser.equals("END"));

            System.out.println("\nСозданные возрастные группы: ");
            List<DescAge> newGrp = AgeFind.createGroups(args, users);
            for (int i = newGrp.size() - 1; i >= 0; i--) {
                System.out.println(newGrp.get(i));
            }
            scanner.close();
    }
	// На вход программе:
				// сначала:
		        //границы возрастных групп задаются как арг командной строки
	
	
				// потом:
				//Кошельков Захар Брониславович,105
		        //Старостин Ростислав Ермолаевич,50
		        //Егоров Алан Петрович,7
		        //Ярилова Розалия Трофимовна,29
		        //Дьячков Нисон Иринеевич,88
		        //Соколов Андрей Сергеевич,15
		        //Иванов Варлам Якунович,88
}
