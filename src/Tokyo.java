/*
 * Author(s): Javier Reyes & Konrad Skoczylas
 *
 * Submission Date: 09/December/2025
 * 
 * Purpose: Create an executable program that manages and query a simple map of seven tourist
 * sites in Tokyo. It models the sites and the distances between some of them using arrays and
 * an adjacency matrix.
 *
 * Methods:
 * Search: search for a site by its code or name to return its details and coordinates
 * Insert: inserts or updates the distance between two sites
 * All Connections(allCons): Display direct neighbors from a specefied site along with the distances
 * Closest: find the closest directly connected site to a specified site
 * 
 * Component	 -----------------------> Description
 * Class Tokyo	----------------------> The main class that encapsulates the data and methods for the tokyo site
 * 
 * siteCode[]   ----------------------> An Array of String site codes(i.e "A", "B", "C").
 * 
 * siteName[]		---------------------->	An array of String site names(i.e "Shibuya Crossing", "Meiji Shrine")
 * 
 * x[] , y[] 		---------------------->	Arrays of int representing the (x,y) coordinates of each site.
 * 
 * dist[][]			---------------------->	A 7×7 integer array (adjacency matrix) storing the distance between sites.
 * 																			A value greater than 0 indicates a direct connection and the
 * 																			distance (in KM). A value of 0 indicates no direct connection is defined
 * 																			.It is symmetrical (dist[i][j] == dist[j][i]).
 * initMap()	 -----------------------> Initializes the dist array with the predefined direct
 * 																			connections and distances between the 7 sites.
 * 
 * menu()		 	----------------------->  Displays the interactive main menu and handles user
 * 																			input for selecting program functionality.
 * 
 * search(String searchIndex) -------->	Searches for a site by its code or name and prints its 
 * 																			code, name, and coordinates. Returns the array index of the
 * 																			site if found, otherwise returns -1.
 * 
 * insert(int i, int j, int distance)-->Sets the distance between the site at index i and the site at index j 
 * 																			to distance in the dist matrix (bidirectional).
 * 
 * allCons(int i)	--------------------> Prints a list of all sites directly connected to the site at 
 *																			index i and the distance to each.
 * 
 * closest(int i)	--------------------> Finds and prints the name and distance of the closest site that is
 * 																			directly connected to the site at index i.
 * 
 * */
//private String[] siteCode = {"A", "B", "C", "D", "E", "F", "G"};
// private String[] siteName = {"Shibuya Crossing","Meiji Shrine","Tokyo Tower","Akihabara","Senso-Ji Temple","Ueno Park","Tokyo Skytree"};
//private int[] xValues = {3, 4, 5, 8, 9, 6, 11};
//private int[] yValues = {7, 1, 3, 8, 7, 2, 2};


import java.util.Scanner;
public class Tokyo{

	private Site sites[] = new Site[7];
	static Scanner sc = new Scanner(System.in);
	private int[][] dist = new int[7][7];


	public Tokyo(){
		initMap();
		initSites();
	}

	private void initSites(){
	//public Site(char siteCode, String siteName, int xValue, int yValue){
				sites[0] = new Site('A', "Shibuya Crossing", 3, 7);
				sites[1] = new Site('B', "Meiji Shrine", 4, 1);
				sites[2] = new Site('C', "Tokyo Tower", 5, 3);
				sites[3] = new Site('D', "Akihabara", 8, 8);
				sites[4] = new Site('E', "Senso-Ji Temple", 9, 7);
				sites[5] = new Site('F', "Ueno Park", 6, 2);//Ueno Park
				sites[6] = new Site('G', "Tokyo Skytree", 11, 2);//Tokyo skytree
			}


	public void start(){
		menu();
	}


	private void initMap() {
		dist[0][1] = 4; dist[1][0] = 4;
		dist[1][2] = 3; dist[2][1] = 3;
		dist[0][5] = 2; dist[5][0] = 2;
		dist[5][4] = 2; dist[4][5] = 2;
		dist[4][6] = 6; dist[6][4] = 6;
		dist[2][6] = 5; dist[6][2] = 5;
		dist[5][3] = 3; dist[3][5] = 3;
		dist[3][6] = 4; dist[6][3] = 4;
	}


	private void menu(){
		int choice = 0;
		do{
			System.out.println("----------------------------------------");
			System.out.println("1. Search");
			System.out.println("2. Insert");
			System.out.println("3. All Conections");
			System.out.println("4. Closest");
			System.out.println("0. Exit");
			System.out.print("Enter a choice: ");
			choice = sc.nextInt();
			System.out.println("----------------------------------------");
			switch(choice){
				case 1 -> search();
				case 2 -> insert();
				case 3 -> allCons();
				case 4 -> closest();
				case 0 -> System.out.println("Exit the program");
				default -> System.out.println("Enter a valid choice");
			}
		}while(choice != 0);
	}//end menu()

	//-------------------------------------------------------------------------------------------------//

	private void search() {
		sc.nextLine();
		System.out.print("Enter search index: ");
		char searchIndex = sc.nextLine().charAt(0);
		for (int i = 0; i < 7; i++) {
			if(sites[i].getSiteCode() == searchIndex || sites[i].getSiteName().equals(searchIndex)){
				System.out.println("Found " + sites[i].getSiteCode() + "  " + sites[i].getSiteName());
				System.out.println("Coordinates (" + sites[i].getXValue() + ", " + sites[i].getYValue() + ")");
			}else{
				System.out.println("Site not found");
			}
		}
	}
	//-------------------------------------------------------------------------------------------------//
	private void insert(){
		sc.nextLine();
		System.out.print("Enter x: ");
		int i = sc.nextInt();
		System.out.print("Enter y: ");
		int j = sc.nextInt();
		System.out.print("Enter Distance: ");
		int distance = sc.nextInt();
		if (i >= 0 && i < 7 && j >= 0 && j < 7) {
			dist[i][j] = distance;
			dist[j][i] = distance;
			System.out.println("Connection added " + distance + "KM");
		}
	}
	//-------------------------------------------------------------------------------------------------//

	private void allCons(){
		sc.nextLine();
		System.out.print("Enter x: ");
		int x = sc.nextInt();
		if (x >= 0 && x < 7) {
			System.out.println("Connections from " + sites[x].getSiteName() + " ");
			for (int y = 0; y < 7; y++) {
				if (dist[x][y] > 0) {
					System.out.println(sites[x].getSiteName()  + "  " + sites[y].getSiteName() + ": " + dist[x][y] + "KM");
				}
			}
		}
	}
	//-------------------------------------------------------------------------------------------------//
	private void closest(){
		sc.nextLine();
		System.out.print("Enter x: ");
		int x = sc.nextInt();
		if (x >= 0 && x < 7) {
			int minDistance = 999;
			int closestIndex = -1;
			for (int y = 0; y < 7; y++) {
				if (dist[x][y] > 0 && dist[x][y] < minDistance) {
					minDistance = dist[x][y];
					closestIndex = y;
				}
			}
			if (closestIndex != -1) {
				System.out.println("Closest " + sites[closestIndex].getSiteName() + " at the distance of " + minDistance + "KM");
			}else{
				System.out.println("Not found");
			}
		}
	}
}//end class

