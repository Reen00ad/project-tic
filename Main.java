import java.util.*;

public class Main {

    static ArrayList<Integer> playerposition = new ArrayList<Integer>();
    static ArrayList<Integer> computerposition = new ArrayList<Integer>();

    public static void main(String[] args) {


        //2d array for board
        char[][] board = {{'*', '*', '*'},
                          {'*', '*', '*'},
                          {'*', '*', '*'}};

        printBoard(board);
        Scanner s = new Scanner(System.in);
// to start game , tell user to enter a position
        while (true) {
            System.out.println("your turn , enter position (1-9) : ");
            int playerpos = s.nextInt();
            // to check if position available or not
            while (playerposition.contains(playerpos) || computerposition.contains(playerpos)) {
                System.out.println("position is not available try again");
                playerpos = s.nextInt();
            }

            place(board, playerpos, "player");
            printBoard(board);

            String result = winner();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }

// for computer turn and check position
            Random r = new Random();
            int compos = r.nextInt(9) + 1;
            while (playerposition.contains(compos) || computerposition.contains(compos)) {
                System.out.println("position is not available try again");
                compos = r.nextInt(9) + 1;
            }
            place(board, compos, "computer");

            printBoard(board);
// check winner
            result = winner();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }

        }

    }

    public static void printBoard(char[][] board) {

        System.out.println(board[0][0]+"|"+board[0][1]+"|"+board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0]+"|"+board[1][1]+"|"+board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0]+"|"+board[2][1]+"|"+board[2][2]);
        System.out.println();


    }

    public static void place(char[][] board, int position, String player) {
        char ch = ' ';
        if (player.equals("player")) {
            ch = 'x';
            playerposition.add(position);
        } else if (player.equals("computer")) {
            ch = 'o';
            computerposition.add(position);
        }

        switch (position) {
            case 1:
                board[0][0] = ch;
                break;
            case 2:
                board[0][1] = ch;
                break;
            case 3:
                board[0][2] = ch;
                break;
            case 4:
                board[1][0] = ch;
                break;
            case 5:
                board[1][1] = ch;
                break;
            case 6:
                board[1][2] = ch;
                break;
            case 7:
                board[2][0] = ch;
                break;
            case 8:
                board[2][1] = ch;
                break;
            case 9:
                board[2][2] = ch;
                break;
            default:
                break;
        }
    }

    public static String winner() {


        ArrayList<List> winn = new ArrayList<List>();
        List row1 = Arrays.asList(1, 2, 3);
        List row2 = Arrays.asList(4, 5, 6);
        List row3 = Arrays.asList(7, 8, 9);
        List col1 = Arrays.asList(1, 4, 7);
        List col2 = Arrays.asList(2, 5, 8);
        List col3 = Arrays.asList(3, 6, 9);
        List dia1 = Arrays.asList(1, 5, 9);
        List dia2 = Arrays.asList(3, 5, 7);
        winn.add(row1);
        winn.add(row2);
        winn.add(row3);
        winn.add(col1);
        winn.add(col2);
        winn.add(col3);
        winn.add(dia1);
        winn.add(dia2);

        for (List l : winn) {
            if (playerposition.containsAll(l)) {
                return "you won :)";
            } else if (computerposition.containsAll(l)) {
                return "you lose :( ";
            } else if (playerposition.size() + computerposition.size() == 9) {
                return "no one win :(";
            }

        }

        return "";
    }
}