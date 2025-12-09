class insert {
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
    
    static void insert(int i, int j, int distance) {
        if (i >= 0 && i < 7 && j >= 0 && j < 7) {
            dist[i][j] = distance;
            dist[j][i] = distance;
            System.out.println("Connection added " + distance + "KM");
        }
    } //adds a connection between two sites with a specified distance in kilometers.
    
    public static void main(String[] args) {
        Map();
        insert(0, 2, 8);
    }
}