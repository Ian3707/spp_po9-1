import java.util.Scanner;
import java.util.Random;

interface PrinterState {
    void printDocument(Printer printer);
    void removeJam(Printer printer);
    void loadPaper(Printer printer, int count);
    void refillInk(Printer printer);
    String getStateDescription();
}

class PrintingState implements PrinterState {
    @Override
    public void printDocument(Printer printer) {
        int jamProbability = new Random().nextInt(100) + 1;
        if (jamProbability <= printer.getJamProbability()) {
            System.out.println("Бумага замята!");
            printer.setCurrentState(new PaperJamState());
            System.out.println(printer.getCurrentState().getStateDescription());
        } else if (printer.getPaperCount() <= 0 || printer.getInkLevel() <= 0) {
            System.out.println("Закончилась бумага или чернила. Печать остановлена.");
            printer.setCurrentState(new OutOfPaperOrInkState());
            System.out.println(printer.getCurrentState().getStateDescription());
        }
        else {
            System.out.println("Уже печатается...");
            printer.setPaperCount(printer.getPaperCount() - 1);
            printer.setInkLevel(printer.getInkLevel() - 10);
            printer.setCurrentState(new IdleState());
            System.out.println(printer.getCurrentState().getStateDescription());
        }
    }

    @Override
    public void removeJam(Printer printer) {
        System.out.println("Не удается устранить замятие бумаги во время печати.");
    }

    @Override
    public void loadPaper(Printer printer, int count) {
        System.out.println("Не удается загрузить бумагу во время печати.");
    }

    @Override
    public void refillInk(Printer printer) {
        System.out.println("Невозможно долить чернила во время печати.");
    }

    @Override
    public String getStateDescription() {
        return "Состояние печати";
    }
}

class IdleState implements PrinterState {
    @Override
    public void printDocument(Printer printer) {
        System.out.println("Переключение в режим печати...");
        printer.setCurrentState(new PrintingState());
        System.out.println(printer.getCurrentState().getStateDescription());
        printer.printDocument();
    }

    @Override
    public void removeJam(Printer printer) {
        System.out.println("Нет замятостей для устранения.");
    }

    @Override
    public void loadPaper(Printer printer, int count) {
        printer.setPaperCount(printer.getPaperCount() + count);
        System.out.println("Загружено " + count + " листов бумаги.");
    }

    @Override
    public void refillInk(Printer printer) {
        printer.setInkLevel(100);
        System.out.println("Чернила заправлены на 100%.");
    }

    @Override
    public String getStateDescription() {
        return "Состояние ожидания";
    }
}

class Printer {
    private String model;
    private int paperCount;
    private int inkLevel;
    private int jamProbability;
    private PrinterState currentState;

    public Printer(String model, int paperCount, int inkLevel, int jamProbability) {
        this.model = model;
        this.paperCount = paperCount;
        this.inkLevel = inkLevel;
        this.jamProbability = jamProbability;
        this.currentState = new IdleState();
    }

    public void printDocument() {
        currentState.printDocument(this);
    }

    public void loadPaper(int count) {
        currentState.loadPaper(this, count);
    }

    public void refillInk() {
        currentState.refillInk(this);
    }

    public void removeJam() {
        currentState.removeJam(this);
    }

    public String getModel() {
        return model;
    }

    public int getPaperCount() {
        return paperCount;
    }

    public void setPaperCount(int paperCount) {
        this.paperCount = paperCount;
    }

    public int getInkLevel() {
        return inkLevel;
    }

    public void setInkLevel(int inkLevel) {
        this.inkLevel = inkLevel;
    }

    public int getJamProbability() {
        return jamProbability;
    }

    public void setCurrentState(PrinterState currentState) {
        this.currentState = currentState;
    }

    public PrinterState getCurrentState() {
        return currentState;
    }

    public void printStatus() {
        System.out.println("Модель принтера: " + model);
        System.out.println("Кличество бумаги: " + paperCount);
        System.out.println("Уровень краски: " + inkLevel + "%");
        System.out.println("Текущее состояние: " + currentState.getStateDescription());
    }
}


class PaperJamState implements PrinterState {
    @Override
    public void printDocument(Printer printer) {
        System.out.println("Не удается выполнить печать. Бумага замята.");
    }

    @Override
    public void removeJam(Printer printer) {
        System.out.println("Устранение замятия бумаги...");
        printer.setCurrentState(new IdleState());
        System.out.println(printer.getCurrentState().getStateDescription());
    }

    @Override
    public void loadPaper(Printer printer, int count) {
        printer.setPaperCount(printer.getPaperCount() + count);
        System.out.println("Загружено " + count + " листов бумаги.");
    }

    @Override
    public void refillInk(Printer printer) {
        printer.setInkLevel(100);
        System.out.println("Чернила заправлены на 100%.");
    }

    @Override
    public String getStateDescription() {
        return "Состояние замятия бумаги.";
    }
}

class OutOfPaperOrInkState implements PrinterState {
    @Override
    public void printDocument(Printer printer) {
        System.out.println("Не удается распечатать. Закончилась бумага или чернила.");
    }

    @Override
    public void removeJam(Printer printer) {
        System.out.println("Нет замятостей для устранения.");
    }

    @Override
    public void loadPaper(Printer printer, int count) {
        printer.setPaperCount(printer.getPaperCount() + count);
        printer.setCurrentState(new IdleState());
        System.out.println("Бумага загружена. Принтер готов.");
        System.out.println(printer.getCurrentState().getStateDescription());
    }

    @Override
    public void refillInk(Printer printer) {
        printer.setInkLevel(100);
        printer.setCurrentState(new IdleState());
        System.out.println("Чернила заправлены. Принтер готов.");
        System.out.println(printer.getCurrentState().getStateDescription());
    }

    @Override
    public String getStateDescription() {
        return "Чернила или бумага закончились.";
    }
}

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Printer printer = new Printer("HP LaserJet Pro", 50, 10, 5);

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("========== Меню ==========");
            System.out.println("1. Печать документа");
            System.out.println("2. Загрузить бумагу");
            System.out.println("3. Устранить замятие бумаги");
            System.out.println("4. Заправить чернила");
            System.out.println("5. Проверить статус принтера");
            System.out.println("0. Выход");
            System.out.print("Ваш выбор: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    printer.printDocument();
                    break;
                case 2:
                    System.out.print("Enter number of sheets to load: ");
                    int sheets = scanner.nextInt();
                    printer.loadPaper(sheets);
                    break;
                case 3:
                    printer.removeJam();
                    break;
                case 4:
                    printer.refillInk();
                    break;
                case 5:
                    printer.printStatus();
                    break;
                case 0:
                    isRunning = false;
                    System.out.println("Exit...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
            System.out.println();
        }
        scanner.close();
    }
}
