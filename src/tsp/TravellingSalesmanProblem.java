package tsp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class TravellingSalesmanProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
                File file = new File("C:\\Users\\jeang\\Desktop\\Cycle1.txt");
                Scanner scanner = null; //initializing scanner
            try {                   //trycatch is an exception handler.
                scanner = new Scanner(file);
            } catch (FileNotFoundException ex) {
                
            }
		int totalLoc = 0;
		
		Address[] address = new Address[6000];//Create an array of addresses
               
               
			
			int cycle = Integer.parseInt(scanner.nextLine()); //Read the first line which is cycle #
			
					//will convert string into an integer									//replaces all commas with spaces
			int packages = Integer.parseInt(scanner.nextLine().replace(",", "")); //Read the second line which is # of packages, EXCLUDING THE COMPLEXES
			System.out.println( "Packages "+ packages);
			
			System.out.println( "Cycle "+ cycle);
                        
                        String Start="125s, 22a, aa";
                        
                                

			while (scanner.hasNextLine()) //loop keeps on reading until there are no more addresses 
				//when it goes null it stops 
                            
				{
				String line = scanner.nextLine();
				address[totalLoc] = new Address(line); //puts all addresses in the array
                                totalLoc = totalLoc + 1; //counts the number of lines
				 //counts the number of lines
				//line = file.readLine(); 
				}
                                scanner.close();
                      address[totalLoc+1]=new Address(Start);   
                      int myStartLoc=totalLoc+1;
                      System.out.println( "Total location is "+ (totalLoc-2));//total number of adresses to go to, including the complexes
                      int totalBartHouses = Integer.parseInt(address[totalLoc - 3].address);//total addresses minus third location of bart
                      System.out.println( "Total Bart  "+ totalBartHouses);
                      int totalLisaHouses = Integer.parseInt(address[totalLoc-1].address);//total - 1 location of Lisa
                      System.out.println( "Total Lisa  "+ totalLisaHouses);
                      System.out.println( "Total houses/units including the complexes is "+ ((totalLoc-4)+totalBartHouses+totalLisaHouses)); //total addresses including Bart and Lisa
			totalLoc = totalLoc - 4; //doesn't consider the last 4 lines
			
                                address[totalLoc] = new Address("2s,3a,q");//reads in Bart 
                                totalLoc++;
                                address[totalLoc] = new Address("149s,33a,q");//reads in Lisa
                                totalLoc++;
                           
                        
			
			
			Address myStartAddress = address[myStartLoc]; //puts the address in variable
                        System.out.println("The starting location is " + address[myStartLoc].address);        
			double totalTime = 0; //total time is now 0. 
			int totaldistanceTravelled = 0; //total blocks is now 0
                        address[myStartLoc].visited = true;//marks starting location as visited
			for (int j = 0 ; j < totalLoc; j++)
			{
			
			int myBestDist =100000000 ; 
			int myBestNeighborLoc = 0;
			Address myBestNeighborAddress = address[myBestNeighborLoc];
			
		
			int totaldistance = 0 ;
			System.out.println("****Iteration " + j);
                        
			for (int i = 0 ; i< totalLoc+1;  i++)//Does it know when to end the loop
			{
				//get the nearest neighbor
				//System.out.println(address[i].address.split(",")[1].replaceAll("\\D+",""));
				if (address[i].visited)//if visited then skip and go to the next address
					continue;
				else//if not visited then find distance of remaining addresses
				{
					int totalStreetBlocks = 0; 
					int totalAvenueBlocks = 0;
					
					totalStreetBlocks = Math.abs(address[myStartLoc].getStreet() -
						address[i].getStreet()); 
					totalAvenueBlocks = Math.abs(address[myStartLoc].getAvenue() -
						address[i].getAvenue()); 
					totaldistance = (totalStreetBlocks*200) + (totalAvenueBlocks*1000); 
					System.out.println("TotalBlocks " + i + " = " + address[i].getStreet() + " streets" + "  " +  address[i].getAvenue() + " avenue = "+totaldistance + " feet.");
                               }
				if (totaldistance < myBestDist)
					{
						myBestDist = totaldistance; 
						myBestNeighborAddress = address[i];
						myBestNeighborLoc = i;
					}
			}
			myBestNeighborAddress.visited = true;
			System.out.println("MyCurrentBest = " + myBestDist);
			System.out.println("myBestNeighborAddress = " + myBestNeighborAddress.address);
			System.out.println("myBestNeighborLoc = " +myBestNeighborLoc );
			totaldistanceTravelled = totaldistanceTravelled + totaldistance;
			myStartLoc = myBestNeighborLoc; 
                        if(j==totalLoc){
                            
					int totalStreetBlocks = 0; 
					int totalAvenueBlocks = 0;
					
					totalStreetBlocks = Math.abs(address[myStartLoc].getStreet() -
						address[totalLoc+1].getStreet()); 
					totalAvenueBlocks = Math.abs(address[myStartLoc].getAvenue() -
						address[totalLoc+1].getAvenue()); 
					totaldistance = (totalStreetBlocks*200) + (totalAvenueBlocks*1000);
                                        totaldistanceTravelled = totaldistanceTravelled + totaldistance;}
			
	}
			
			totalTime = (totaldistanceTravelled/2000) + totalBartHouses  + totalLisaHouses+(totalLoc-2);
//totalLoc is minus two because it includes the addresses of the complexes, and the number of units in those complexes is not included
                        double MinuteswithoutHours= (totalTime%60);
                        double totalHours=(totalTime/60)-(MinuteswithoutHours/60);
			System.out.println("TotaldistanceTravelled= " + totaldistanceTravelled );
			System.out.println("TotalTime= " + totalTime + " minutes");
                        System.out.println("Hours: "+totalHours+" Minutes: "+MinuteswithoutHours);
                        
                        int employees = 2;
                        if (employees == 1)
                        {   
                        double hours = totalTime / 60;

                        double employeeCost1 = 8 * 30;
                       double employeeCost2 = hours - 8;
                       double employeeCost3 = employeeCost2 * 45;
                       double finalemployeeCost = employeeCost3 + employeeCost1; 
                       System.out.println("employees = 1");
                       System.out.println(finalemployeeCost);
                       System.out.println(hours);
                      
                        }
                        else if (employees == 2)
                                {
                        double hours = (totalTime / 60) ;
                        int employeeCost1 = (8 * 30) * 2;
                       double employeeCost2 = hours - 8;
                       double employeeCost3 = employeeCost2 * 45;
                       System.out.println("employees = 2");
                       double finalemployeeCost = employeeCost3 + employeeCost1;
                       System.out.println(finalemployeeCost);
                       System.out.println(hours);
                                }
                         
	}
}
