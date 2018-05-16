import java.util.ArrayList;

public class test {
    static int height=3;
    static int width=3;
    static int[][] matrix = new int[height][width];
    public static void main(String... args){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i==2 || i==1) matrix[i][j]=1;
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        removeFullLines();System.out.println();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void removeFullLines() {
        //Например так:
        //Создаем список для хранения линий
        ArrayList<int[]> lines = new ArrayList<int[]>();

        //Копируем все непустые линии в список.
        boolean isEmpty = true;
        for (int i = 0; i < height; i++) {
            if (lineIsFull(matrix, i)) continue;
            lines.add(new int[width]);
            for (int j = 0; j < width; j++) {
                lines.get(lines.size() - 1)[j] = matrix[i][j];
            }
        }

        //Добавляем недостающие строки в начало списка.
        int size = lines.size();
        for (int i = 0; i < height - size; i++) {
            lines.add(0, new int[width]);
        }

        //Преобразуем список обратно в матрицу
        for (int i = 0; i < height; i++) {
            matrix[i] = lines.get(i);
        }
    }

    public static boolean lineIsFull(int[][] m, int lineNumber) {
        for (int j = 0; j < width; j++) {
            if (matrix[lineNumber][j] == 0) return false;
        }
        return true;
    }
}
