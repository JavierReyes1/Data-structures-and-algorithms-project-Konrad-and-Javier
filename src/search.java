class search {
    static String[] siteCode = {"A", "B", "C", "D", "E", "F", "G"};
    static String[] siteName = {"Shibuya Crossing", "Meiji Shrine", "Tokyo Tower", "Akihabara", "Senso-Ji Temple", "Ueno Park", "Tokyo Skytree"};
    static int[] x = {3, 4, 5, 8, 9, 6, 11};
    static int[] y = {7, 1, 3, 8, 7, 2, 2};
    
    static int Search(String searchIndex) {
        for (int i = 0; i < 7; i++) {
            if (siteCode[i].equals(searchIndex) || siteName[i].equals(searchIndex)) {
                System.out.println("found " + siteCode[i] + "  " + siteName[i]);
                System.out.println("Coordinates (" + x[i] + "," + y[i] + ")");
                return i;
            }
        }
        System.out.println("site not found");
        return -1;
    } // searches for a tourist site by its code or name and returns its index in the array.
    
    public static void main(String[] args) {
        Search("Tokyo Tower");
    }
}
