class allcons {
    static String[] siteName = {"Shibuya Crossing", "Meiji Shrine", "Tokyo Tower", "Akihabara", "Senso-Ji Temple", "Ueno Park", "Tokyo Skytree"};
    static int[][] dist = new int[7][7];
    
    static void Map() {
        dist[0][1] = 4; dist[1][0] = 4;
        dist[1][2] = 3; dist[2][1] = 3;
        dist[0][5] = 2; dist[5][0] = 2;
        dist[5][4] = 2; dist[4][5] = 2;
        dist[4][6] = 6; dist[6][4] = 6;
        dist[2][6] = 5; dist[6][2] = 5;
        dist[5][3] = 3; dist[3][5] = 3;
        dist[3][6] = 4; dist[6][3] = 4;
    }
    
    static void AllCons(int i) {
        if (i >= 0 && i < 7) {
            System.out.println("Connections from " + siteName[i] + ":");
            for (int j = 0; j < 7; j++) {
                if (dist[i][j] > 0) {
                    System.out.println(siteName[i] + "  " + siteName[j] + " " + dist[i][j] + "KM");
                } // // displays all direct connections and distances from a specified site.
            }
        }
    }
    
    public static void main(String[] args) {
        Map();
        AllCons(5);
    }
}
