package ru.croc.task10;

import java.time.LocalDateTime;
public class Task10 {

	public static void main(String[] args) throws InterruptedException {
		//aucLot car= new aucLot((double) 10000, LocalDateTime.now().plusMinutes(1));
		//aucLot sofa= new aucLot((double) 1500, LocalDateTime.now().plusMinutes(1));
		//aucLot table= new aucLot((double) 4000, LocalDateTime.now().plusMinutes(1));
		//ArrayList<aucLot> prodList= new ArrayList<>();
		//prodList.add(car);
		//prodList.add(sofa);
		//prodList.add(table);
		//System.out.println(car);
		
		
		
		LocalDateTime endTime = LocalDateTime.now().plusMinutes(1); 
		aucLot numLot = new aucLot(Double.valueOf(0), endTime); //создание лота с разумным временем завер
        Thread[] threads = new Thread[100];
        int cnt = 0;
        while (cnt < 100) {		//происходят одновременные ставки на лот (релизован многопоток)
            threads[cnt] = new Thread(new AuctionProcess(Integer.toString(cnt), numLot));
            threads[cnt].start();
            cnt++;
        }
        for (int i = 0; i < 100; i++){
            threads[i].join();
        }
        System.out.println("______The end of auction_____:");
        System.out.println(numLot.winner());
    	}
	}

