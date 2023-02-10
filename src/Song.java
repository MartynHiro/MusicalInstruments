public class Song {
    protected Instrument[] instruments;//массив с типом инструмент, можем сохранять все потомки благодаря полиморфизму
    protected boolean[][] shouldPlay;//1-й индекс номер инструмента, 2-й индекс номер секунды, а в ячейке сохраним должен ли он играть

    public Song (Instrument[] instruments, boolean[][] shouldPlay) { //конструктор, который заполняет наши поля
        this.instruments = instruments;                            //благодаря ему мы выставляем набор инструментов
        this.shouldPlay = shouldPlay;
    }

    public void play() throws Exception {
        int time = shouldPlay[0].length;//можно заглянуть в любой массив(они одинаковые по длине) и узнать длину нашей песни
                                        //если бы они были разные надо было бы сначала узнать максимальной длины по секундам
        for (int t = 0; t < time; t++) {//пройдемся по всем секундам (каждая строка это будет определенная секунда)
            for (int i = 0; i < instruments.length; i++) {//наши столбики это количество инструментов заданных
                if (shouldPlay[i][t]) {//проверяем должен ли играть вынятый инструмент
                    Instrument instrument = instruments[i];//вынимаем нужный нам инструмент
                    char c = instrument.playSound();//вынимаем его символ игры
                    System.out.print(c + " ");//выводим это символ не переводя строку
                } else {
                    System.out.print("  ");//либо если не должен играть то просто 2 пробела до следующего столбика
                }
            }
            System.out.println();//наш переход на следующую строку(секунду)
            Thread.sleep(1000);
        }
    }
}
