import java.util.Scanner;

public class Game {

    public static Character manager;
    public static Story story;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Вы прошли собеседование и вот-вот станете сотрудником Корпорации. \n"
                + "Осталось уладить формальности - подпись под договором (Введите ваше имя):");
        String name = in.next();
        manager = new Character(name);
        story = new Story();
        while (true) {
            StringBuilder symbols_situation_subject_length = new StringBuilder();
            for (int i = 0; i < story.current_situation.subject.length(); i++) {
                symbols_situation_subject_length.append("=");
            }
            System.out.println("=============" + symbols_situation_subject_length.toString() + "==============");
            System.out.println("=============" + story.current_situation.subject + "==============");
            int dA = story.current_situation.dA, dK = story.current_situation.dK, dR = story.current_situation.dR;
            manager.A += dA;
            manager.K += dK;
            manager.R += dR;
            System.out.println( "-----" + "\t\t----\t\t" + "-----"
                + "\n|\tКарьера:\t"    + manager.K + ((dK == 0) ? "\t\t==" : ((dK > 0) ? "\t\t↑ (" : "\t\t↓ (") + dK + ")") + "\t\t\t"
                + "\n|\tАктивы:\t\t"   + manager.A + ((dA == 0) ? "\t\t==" : ((dA > 0) ? "\t\t↑ (" : "\t\t↓ (") + dA + ")") + "\t\t\t"
                + "\n|\tРепутация:\t"  + manager.R + ((dR == 0) ? "\t\t==" : ((dR > 0) ? "\t\t↑ (" : "\t\t↓ (") + dR + ")") + "\t\t\t"
            + "\n-----"  + "\t\t----\t\t" + "-----");
            System.out.println(story.current_situation.text);
            if (story.isEnd()) {
                System.out.println("====================the end!===================");
                System.out.println( "-----" + "\t\t----\t\t" + "-----"
                    + "\n|\tКарьера:\t"    + manager.K + ((dK == 0) ? "\t\t==" : ((dK > 0) ? "\t\t↑ (" : "\t\t↓ (") + dK + ")") + "\t\t\t"
                    + "\n|\tАктивы:\t\t"   + manager.A + ((dA == 0) ? "\t\t==" : ((dA > 0) ? "\t\t↑ (" : "\t\t↓ (") + dA + ")") + "\t\t\t"
                    + "\n|\tРепутация:\t"  + manager.R + ((dR == 0) ? "\t\t==" : ((dR > 0) ? "\t\t↑ (" : "\t\t↓ (") + dR + ")") + "\t\t\t"
                    + "\n-----"  + "\t\t----\t\t" + "-----");
                System.out.println("\nСыграем ещё раз? (y/n)");
                String reset = in.next();
                if (reset.equals("y")) {
                    story.resetStory();
                    manager = new Character(name);
                    System.out.println("До свидания, " + manager.name + "!\n");
                    continue;
                } else {
                    return;
                }
            }
            story.go(in.nextInt());
        }

    }

}
