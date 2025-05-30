import java.util.*;
import java.lang.*;
public class velha {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[][] velha = new String[3][3];
        for (int i = 0; i < velha.length; i++) {
            for (int j = 0; j < velha.length; j++) {
                velha[i][j] = " ";
            }
        }
        int cont10 = 0;
        System.out.println("oi");
        System.out.println("");
        while (true) {
            printVelha(velha);
            System.out.print("Escolha o lugar(de 1 à 9): ");
            int y=0;
            while (y == 0) {
                int lugar = scan.nextInt();
                if (lugar <= 9 && lugar >= 1) {
                    if (lugar <=3 && velha[0][lugar - 1].equals(" ")) {
                        velha[0][lugar - 1] = "X";
                        y++;
                    } else if(lugar <=6 && lugar > 3 && velha[1][lugar - 4].equals(" ")){
                        velha[1][lugar - 4] = "X";
                        y++;
                    } else if(lugar <=9 && lugar > 6 && velha[2][lugar - 7].equals(" ")){
                        velha[2][lugar - 7] = "X";
                        y++;
                    } else {
                        System.out.println("Lugar inválido");
                    }
                } else {
                    System.out.println("Lugar inválido");
                }
            }

            if (contagem("X", velha, false)) {
                printVelha(velha);
                System.out.println("PARABÉNS!!!");
                break;
            }
            cont10++;

            while (true) {
                if (contagem("O", velha, true)) {
                    break;
                }else if (contagem("X", velha, true)) {
                    break;
                } else {
                    int botLugar = (int)(Math.random() * 10);
                    if (botLugar != 10 && botLugar != 0) {
                        if (botLugar <= 3) {
                            if (velha[0][botLugar - 1].equals(" ")) {
                                velha[0][botLugar - 1] = "O";
                                break;
                            }
                        } else if (botLugar <= 6) {
                            if (velha[1][botLugar - 4].equals(" ")) {
                                velha[1][botLugar - 4] = "O";
                                break;
                            }
                        } else if (botLugar <= 9) {
                            if (velha[2][botLugar - 7].equals(" ")) {
                                velha[2][botLugar - 7] = "O";
                                break;
                            }
                        }
                    }
                    if (cont10 == 5) {
                        break;
                    }
                }
            }

            if (contagem("O", velha, false)) {
                printVelha(velha);
                System.out.println("PERDEU PRO BOT KKKKKKKK!!!");
                break;
            }

            int cont9 = 0;
            for (int i = 0; i < velha.length; i++) {
                for (int j = 0; j < velha.length; j++) {
                    if(velha[i][j].equals(" ")){
                        cont9++;
                    }
                }
            }

            if(cont9 == 0){
                printVelha(velha);
                System.out.println("VELHA!!!!");
                break;
            }
        }
    }
    public static void printVelha(String[][] velha){
        System.out.println(" " + velha[0][0] + " | " + velha[0][1] + " | " + velha[0][2] + "\n---|---|---");
        System.out.println(" " + velha[1][0] + " | " + velha[1][1] + " | " + velha[1][2] + "\n---|---|---");
        System.out.println(" " + velha[2][0] + " | " + velha[2][1] + " | " + velha[2][2]);
    }
    public static boolean contagem(String string, String[][] velha, boolean impedimento){
        int cont1 = 0;
        int cont2 = 0;
        int cont3 = 0;
        int cont4 = 0;
        int cont5 = 0;
        int cont6 = 0;
        int cont7 = 0;
        int cont8 = 0;
        for (int i = 0; i < velha.length; i++) {
            for (int j = 0; j < velha.length; j++) {
                if (i == j && velha[i][j].equals(string)) {
                    cont1++;
                }
                if (i == 0 && velha[i][j].equals(string)) {
                    cont2++;
                }
                if (j == 0 && velha[i][j].equals(string)) {
                    cont3++;
                }
                if (j + i == 2 && velha[i][j].equals(string)) {
                    cont4++;
                }
                if (j == 1 && velha[i][j].equals(string)) {
                    cont5++;
                }
                if (i == 1 && velha[i][j].equals(string)) {
                    cont6++;
                }
                if (j == 2 && velha[i][j].equals(string)) {
                    cont7++;
                }
                if (i == 2 && velha[i][j].equals(string)) {
                    cont8++;
                }
            }
        }

        if(impedimento){
            for (int i = 0; i < velha.length; i++) {
                for (int j = 0; j < velha.length; j++) {
                    if (i == j && velha[i][j].equals(" ") && cont1 == 2) {
                        velha[i][j] = "O";
                        return true;
                    } else if (i == 0 && velha[i][j].equals(" ") && cont2 == 2) {
                        velha[i][j] = "O";
                        return true;
                    } else if (j == 0 && velha[i][j].equals(" ") && cont3 == 2) {
                        velha[i][j] = "O";
                        return true;
                    } else if (i + j == 2 && velha[i][j].equals(" ") && cont4 == 2) {
                        velha[i][j] = "O";
                        return true;
                    } else if (j == 1 && velha[i][j].equals(" ") && cont5 == 2) {
                        velha[i][j] = "O";
                        return true;
                    } else if (i == 1 && velha[i][j].equals(" ") && cont6 == 2) {
                        velha[i][j] = "O";
                        return true;
                    } else if (j == 2 && velha[i][j].equals(" ") && cont7 == 2) {
                        velha[i][j] = "O";
                        return true;
                    } else if (i == 2 && velha[i][j].equals(" ") && cont8 == 2) {
                        velha[i][j] = "O";
                        return true;
                    }
                }
            }
        }

        if(cont1 == 3 || cont2 == 3 || cont3 == 3 || cont4 == 3 || cont5 == 3 || cont6 == 3 || cont7 == 3 || cont8 == 3){
            return true;
        } else {
            return false;
        }
    }
    
}
