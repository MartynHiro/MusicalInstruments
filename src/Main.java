public class Main {
    public static void main(String[] args) throws Exception{

        Instrument[] instruments = {
                new Guitar(),        //заводим переменную массив и в ней создаем 4 объекта инструментов для игры
                new Piano(),
                new Flute(),
                new Guitar()
        };
        boolean[][] shouldPlay = { //прописываем когда какой инструмент будет играть по секундам, каждая строка это 1 инструмент
                {false, true, true, true, true, false},//гитара
                {true, false, true, false, true, false},//пианино
                {false, false, true, true, false, false},//флейта
                {false, true, true, true, true, false}//2я гитара
        };

        Song song = new Song(instruments, shouldPlay); //сам объект песни и передаем ему набор инструментов и тайминг их игры
        song.play(); //вызов метода игры
    }
}